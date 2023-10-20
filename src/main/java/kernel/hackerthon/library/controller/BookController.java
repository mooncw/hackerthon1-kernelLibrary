package kernel.hackerthon.library.controller;

import jakarta.servlet.http.HttpSession;
import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.dto.AddBookRequest;
import kernel.hackerthon.library.dto.RecoverBookRequest;

import kernel.hackerthon.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/books")
@Controller
public class BookController {
    @Autowired
    private final BookService bookService;
    @Autowired
    private HttpSession httpSession;

    private String apiKey;

    @GetMapping
    public String findBooksAvailable(Model model) {
        List<Book> books = bookService.findBooksByIsRecoveryIsFalse();
        model.addAttribute("books", books);
        return "firstpage";
    }


    @GetMapping("/{bookId}")
    public String findBookByBookId(@PathVariable Long bookId, ModelMap map) {
        Optional<Book> book = bookService.getBook(bookId);

        map.addAttribute("book", book);

        return "books/detail";
    }

    @GetMapping("/add")
    public String showAddBookForm(AddBookRequest addBookRequest) {
        return "addingBooksForm";
    }

    @PostMapping("/add")
    public String addBook(AddBookRequest addBookRequest) {
        bookService.addBook(addBookRequest, httpSession);
        return "redirect:/books";
    }

    @GetMapping("/recovers")
    public String recoverMyBook(RecoverBookRequest recoverBookRequest, Model model ) {
        List<Book> bookList = bookService.findMyBooks(httpSession);
        model.addAttribute("bookList", bookList);
        return "recoverBookForm";
    }

    @PostMapping("/api/v1/recovers")
    public String recoverBook(RecoverBookRequest recoverBookRequest) {
        bookService.recover(recoverBookRequest.getBookId(),httpSession);
        return "redirect:/books/recovers";
    }

}
