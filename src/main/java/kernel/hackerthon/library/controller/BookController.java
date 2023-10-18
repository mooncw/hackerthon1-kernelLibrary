package kernel.hackerthon.library.controller;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.dto.AddBookRequest;
import kernel.hackerthon.library.repository.BookRepository;

import kernel.hackerthon.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/books")
@Controller
public class BookController {
    private final BookService bookService;


    private String apiKey;

    //@PostMapping("api/v1/books")
    //private ResponseEntity<Book> addBook(@RequestBody AddBookRequest addBookRequest){
    //    Book savedBook = bookService.save(addBookRequest);
    //    return ResponseEntity.status(HttpStatus.CREATED)
    //            .body(savedBook);
    //}

    // (메인 서고화면)서고에 있는 모든 책 get 하기
    // 회수한 책은 제외하도록 처리해야
    @GetMapping
    public String books(ModelMap map) {
        List<Book> books = bookService.getBooks();

        map.addAttribute("books", books);

        return "firstpage";
    }


    //(메인 화면에서 책 한권 클릭시)책 한권 get - 책 상세페이지
    @GetMapping("/{bookId}")
    public String book(@PathVariable Long bookId, ModelMap map) {
        Optional<Book> book = bookService.getBook(bookId);

        map.addAttribute("book", book);
        // view에서 book 의 대출상태가 대출가능 이어야 대출 버튼 보이게 처리
        return "books/detail";
    }

    // 책 한권 페이지 - 책 상세페이지에서 [빌리기] 눌렀을때
    @PostMapping("/{bookId}/borrow/{userId}")
    public String borrowBook(
            @PathVariable Long bookId,
            @PathVariable Long userId
//          @AuthenticationPrincipal BoardPrincipal boardPrincipal  스프링시큐리티에서 유저 정보 처리..?
            // 현재는 유저 정보 바로 올리기
    )
    {
        //bookService.borrowBook(bookId, userId);

        return "redirect:/books";
    }

    @GetMapping("/add")
    public String showAddBookForm(AddBookRequest addBookRequest) {
        System.out.println(apiKey);
        return "addingBooksForm";
    }

    @PostMapping("/add")
    public String addBook(AddBookRequest addBookRequest) {
        bookService.addBook(addBookRequest);
        return "redirect:/books";
    }

    @GetMapping("/{bookId}/return")  // url 예시
    public String  returnBook(@PathVariable Long bookId, Model model) {
//        int result = bookService.returnBook(bookId);
//        model.addAttribute("status", result);
        return "returnPage";
    }
}
         



//@GetMapping("/addBook")
//public String addBookForm(Model model) {
//    model.addAttribute("addBookRequest", new AddBookRequest());
//    model.addAttribute("books", bookService.getAllBooks());
//    return "addBook";
//}
//
//    @PostMapping("/api/v1/books")
//    public String addBook(@ModelAttribute AddBookRequest addBookRequest) {
//        bookService.save(addBookRequest);
//        return "redirect:/addBook";
//    }
