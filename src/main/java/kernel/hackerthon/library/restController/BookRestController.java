package kernel.hackerthon.library.restController;

import com.google.gson.Gson;
import kernel.hackerthon.library.dto.GoogleBooksResponse;
import kernel.hackerthon.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BookRestController {

    private final BookService bookService;

    @Value("${google-books-api-key}")
    private String apiKey;

    @PostMapping("/v1/books/search")
    public String searchBookWithIsbn(@RequestBody String isbnData) {
        String json = null;
        try {
            Gson gsonRequest = new Gson();
            Map<Object, String> requestMap = new HashMap<>();
            // FIXME :: 캐스팅을 서비스에 넣는게 좋을 듯...?
            requestMap = (Map<Object, String>)gsonRequest
                    .fromJson(isbnData, requestMap.getClass());
            requestMap.put("apiKey", apiKey);

            GoogleBooksResponse response = bookService.searchBookWithIsbn(requestMap);

            Gson gsonResponse = new Gson();
            Map<Object, Object> responseMap = new HashMap<>();
            responseMap.put("bookname", response.getItems().get(0).getVolumeInfo().getTitle());

            json = gsonResponse.toJson(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}
