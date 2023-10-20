package kernel.hackerthon.library.service;

import jakarta.servlet.http.HttpSession;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public List<Book> getBooksRentalAvailable(HttpSession session) {
        return bookRepository.findBooksByIsRentalIsFalse();
    }

    @Transactional
    public List<Rental> getBooksReturnAvailable(HttpSession session) {
        return rentalRepository.findRentalsByUserIdAndReturnDateIsNull((Long) session.getAttribute("loginUser"));
    }

    @Transactional
    public Long rentalByBook(RentalRequest rentalRequest, HttpSession httpSession) {
        Book findBook = findByBook(rentalRequest.getBookId());
        User findUser = findByUser((Long) httpSession.getAttribute("loginUser"));

        Rental savedRental = rentalRepository.save(RentalRequest.toEntity(findUser, findBook));

        findBook.rentalByBook();

        return savedRental.getId();
    }

    @Transactional
    public void returnByBook(RentalRequest rentalRequest, HttpSession httpSession){
        Rental findRental = rentalRepository.findByReturnDateIsNullAndIdAndUserId(rentalRequest.getRentalId(), (Long)httpSession.getAttribute("loginUser"))
                .orElseThrow(() -> new IllegalArgumentException("대여 정보를 찾을 수 없습니다."));
        findRental.saveReturnDate();
        Book findBook = findByBook(findRental.getBook().getId());
        findBook.returnByBook();
    }

    private Book findByBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("책 정보가 없습니다."));
    }
    private User findByUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

}
