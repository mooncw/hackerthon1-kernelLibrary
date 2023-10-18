package kernel.hackerthon.library.controller;

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
public class BookApiController {

    private final BookService bookService;

    @Value("${google-books-api-key}")
    private String apiKey;

    @PostMapping("/search")
    public String searchBookWithIsbn(@RequestBody String isbnData) {
        String json = null;
        try {
            Gson gsonRequest = new Gson();
            Map<Object, Object> requestMap = new HashMap<>();
            requestMap = (Map<Object, Object>)gsonRequest.fromJson(isbnData, requestMap.getClass());
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
