package kernel.hackerthon.library.service;

import kernel.hackerthon.library.repository.RentalRepository;
import kernel.hackerthon.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
}
