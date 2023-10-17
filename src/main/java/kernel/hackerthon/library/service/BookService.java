package kernel.hackerthon.library.service;


import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.repository.BookRepository;
import kernel.hackerthon.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    // 책 전체 가져오는
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long bookId){
        return bookRepository.findById(bookId);
    }

}
