package kernel.hackerthon.library.service;

import kernel.hackerthon.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService  {

    @Autowired
    private final BookRepository bookRepository;


}
