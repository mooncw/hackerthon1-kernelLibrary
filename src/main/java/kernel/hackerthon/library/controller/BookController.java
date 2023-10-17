package kernel.hackerthon.library.controller;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.dto.AddBookRequest;
import kernel.hackerthon.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookController {
    @Autowired
    private final BookService bookService;

    @PostMapping("api/v1/books")
    private ResponseEntity<Book> addBook(@RequestBody AddBookRequest addBookRequest){
        Book savedBook = bookService.save(addBookRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);
    }

}
