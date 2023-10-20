package kernel.hackerthon.library.controller;

import jakarta.servlet.http.HttpSession;
import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.dto.BookRequest;
import kernel.hackerthon.library.dto.RecoverBookRequest;

import kernel.hackerthon.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/books")
@Controller
public class BookController {

    private final BookService bookService;
    private final HttpSession httpSession;

    private String apiKey;

    @GetMapping
    public String findBooksAvailable(Model model) {
        List<Book> books = bookService.findBooksByIsRecoveryIsFalse();
        model.addAttribute("books", books);
        return "firstpage";
    }

    @GetMapping("/add")
    public String showAddBookForm(BookRequest addBookRequest) {
        return "addingBooksForm";
    }

    @PostMapping("/add")
    public String addBook(BookRequest addBookRequest) {
        bookService.addBook(addBookRequest, httpSession);
        return "redirect:/books";
    }

    @GetMapping("/recovers")
    public String recoverMyBook(RecoverBookRequest recoverBookRequest, Model model ) {
        List<Book> bookList = bookService.findMyBooks(httpSession);
        model.addAttribute("bookList", bookList);
        return "recoverBookForm";
    }

    @PostMapping("/recovers")
    public String recoverBook(RecoverBookRequest recoverBookRequest) {
        bookService.recover(recoverBookRequest.getBookId(),httpSession);
        return "redirect:/books/recovers";
    }

}
