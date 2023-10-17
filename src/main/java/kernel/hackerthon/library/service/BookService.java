package kernel.hackerthon.library.service;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.dto.AddBookRequest;
import kernel.hackerthon.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public Book save(AddBookRequest request){
        return bookRepository.save(request.toEntity());
    }
}
