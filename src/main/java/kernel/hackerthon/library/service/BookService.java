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
//        Date todayDate = new Date(Calendar.getInstance().getTimeInMillis());
//        Date returnDate = new Date(Calendar.getInstance().getTimeInMillis()+1);
//        Optional<User> user = userRepository.findById(userId);
//        rentalRepository.save(Rental.builder().user(user.map(User::getUserId)).book(bookRepository.findById(bookId)).loanDate(todayDate).returnDate(returnDate));
//    }
}


