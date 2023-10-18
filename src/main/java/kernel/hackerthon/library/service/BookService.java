package kernel.hackerthon.library.service;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.Rental;
import kernel.hackerthon.library.domain.User;
import kernel.hackerthon.library.dto.AddBookRequest;
import kernel.hackerthon.library.repository.BookRepository;
import kernel.hackerthon.library.repository.RentalRepository;
import kernel.hackerthon.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;

    public Book save(AddBookRequest request){
        return bookRepository.save(request.toEntity());
    }

    // 책 전체 가져오는
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long bookId){
        return bookRepository.findById(bookId);
    }

//    public void borrowBook(Long bookId, Long userId){
//        bookRepository.findById(bookId).orElseThrow().changeRentalStatus();
//
//        LocalDateTime todayDate = LocalDateTime.now();
//        LocalDateTime returnDate = LocalDateTime.now().plusDays(1);
//        User user = userRepository.findById(userId).orElseThrow();
//        Book book = bookRepository.findById(bookId).orElseThrow();
//
//        Rental rental = Rental.builder()
//                .user(user)
//                .book(book)
//                .rentalDate(todayDate)
//                .returnDate(returnDate)
//                .build();
//        rentalRepository.save(rental);
//    }

    public void addBook(AddBookRequest addBookRequest) { bookRepository.save(addBookRequest.toEntity());}

}


