package kernel.hackerthon.library.controller;

import jakarta.servlet.http.HttpSession;
import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.dto.RentalRequest;
import kernel.hackerthon.library.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping("/rentals")
    public String viewRental(RentalRequest rentalRequest, HttpSession session, Model model) {
        List<Book> bookList = rentalService.getBooksRentalAvailable(session);
        model.addAttribute("bookList", bookList);
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
        return "redirect:/books";
    }
}
