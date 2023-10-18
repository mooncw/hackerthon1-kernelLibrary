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
    public String createRental(RentalRequest rentalRequest) {
        rentalService.create(rentalRequest);
        return "redirect:/books";
    }
}
