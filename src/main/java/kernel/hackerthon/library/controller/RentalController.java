package kernel.hackerthon.library.controller;

import kernel.hackerthon.library.dto.RentalRequest;
import kernel.hackerthon.library.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping("/rentals")
    public String viewRental(RentalRequest rentalRequest) {
        return "rentalPage";
    }

    @PostMapping("/api/v1/rentals")
    public String rentalByBook(RentalRequest rentalRequest) {
        rentalService.rentalByBook(rentalRequest);
        return "redirect:/books";
    }

    @PostMapping("/api/v1/returns")
    public String returnByBook(RentalRequest rentalRequest) {
        rentalService.returnByBook(rentalRequest);
        return "redirect:/books";
    }
}
