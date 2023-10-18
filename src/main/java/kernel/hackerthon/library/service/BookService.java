package kernel.hackerthon.library.service;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.Rental;
import kernel.hackerthon.library.domain.User;
import kernel.hackerthon.library.dto.AddBookRequest;
import kernel.hackerthon.library.dto.GoogleBooksResponse;
import kernel.hackerthon.library.repository.BookRepository;
import kernel.hackerthon.library.repository.RentalRepository;
import kernel.hackerthon.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

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

    public GoogleBooksResponse searchBookWithIsbn(Map<Object, Object> map) {
        String isbn = (String) map.get("isbn");
        String apiKey = (String) map.get("apiKey");

        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn + "&key=" + apiKey;

        System.out.println(apiUrl);

        RestTemplate restTemplate = new RestTemplate();

        GoogleBooksResponse response = restTemplate.getForObject(apiUrl, GoogleBooksResponse.class);

        return response;
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

    // 책 반납하기
//    @Transactional
//    public int returnBook(Long bookId){
//        Optional<Book> book = bookRepository.findById(bookId);
//        if (book.isPresent()) {
//            Book bookEntity = book.get();
//            Long id = bookEntity.getId();
//            Optional<Rental> rental = rentalRepository.findById(id);
//            if (rental.isPresent()) {
//                bookEntity.returnByBook();
//                Rental rentalEntity = rental.get();
//                rentalEntity.inputReturnDate();
//                // 변경 사항을 저장
//                bookRepository.save(bookEntity);
//                rentalRepository.save(rentalEntity);
//                return 0;    // 정상적으로 처리되면 0 출력
//            } else {
//                return 1;    // Rental엔티티에 문제가 생긴 경우 1 출력
//            }
//        } else {
//            return 2;        // Book엔티티에 문제가 생긴 경우 2 출력
//        }
//    }
}


