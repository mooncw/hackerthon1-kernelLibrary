package kernel.hackerthon.library.controller;

import jakarta.servlet.http.HttpSession;
import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.Rental;
import kernel.hackerthon.library.dto.RentalRequest;
import kernel.hackerthon.library.service.RentalService;
import kernel.hackerthon.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    private final UserService userService;
    private final HttpSession httpSession;

    @GetMapping("/rentals")
    public String viewRental(RentalRequest rentalRequest, Model model) {
        if(!isUserRegisteredBook()) return "redirect:/user/noPermission";

        // FIXME : DTO로 변환해서 받는 것이 좋아보임
        List<Book> bookList = rentalService.getBooksRentalAvailable(httpSession);
        List<Rental> rentaledBookList = rentalService.getBooksReturnAvailable(httpSession);

        model.addAttribute("bookList", bookList);
        model.addAttribute("rentaledBookList", rentaledBookList);
        return "rentalPage";
    }

    private Boolean isUserRegisteredBook() {
        return userService.isUserRegisteredBook(httpSession);
    }

    @PostMapping("/rentals")
    public String rentalByBook(RentalRequest rentalRequest) {
        rentalService.rentalByBook(rentalRequest, httpSession);
        return "redirect:/rentals";
    }

    @PostMapping("/returns")
    public String returnByBook(RentalRequest rentalRequest) {
        rentalService.returnByBook(rentalRequest, httpSession);
        return "redirect:/rentals";
    }
}
