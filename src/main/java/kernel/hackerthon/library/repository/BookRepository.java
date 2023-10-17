package kernel.hackerthon.library.repository;


import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<Book, Id> {
}
