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

    @GetMapping("/rentals")
    public String viewRental(RentalRequest rentalRequest, HttpSession session, Model model) {
        boolean userHasPermission = userService.isUserRegisteredBook(session);
        if(!userHasPermission) return "redirect:/user/noPermission";
        List<Book> bookList = rentalService.getBooksRentalAvailable(session);
        List<Rental> rentaledBookList = rentalService.getBooksReturnAvailable(session);

        model.addAttribute("bookList", bookList);
        model.addAttribute("rentaledBookList", rentaledBookList);
        return "rentalPage";
    }

    @PostMapping("/api/v1/rentals")
    public String rentalByBook(RentalRequest rentalRequest, HttpSession httpSession) {
        rentalService.rentalByBook(rentalRequest, httpSession);
        return "redirect:/rentals";
    }

    @PostMapping("/api/v1/returns")
    public String returnByBook(RentalRequest rentalRequest, HttpSession httpSession) {
        rentalService.returnByBook(rentalRequest, httpSession);
        return "redirect:/rentals";
    }
}
