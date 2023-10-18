package kernel.hackerthon.library.service;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.Rental;
import kernel.hackerthon.library.domain.User;
import kernel.hackerthon.library.dto.RentalRequest;
import kernel.hackerthon.library.repository.BookRepository;
import kernel.hackerthon.library.repository.RentalRepository;
import kernel.hackerthon.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long create(RentalRequest rentalRequest) {
        Book findBook = bookRepository.findById(rentalRequest.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("책 정보가 없습니다."));
        User findUser = userRepository.findById(rentalRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Rental savedRental = rentalRepository.save(RentalRequest.toEntity(findUser, findBook));

        findBook.rentalByBook();

        return savedRental.getId();
    }
}
