package kernel.hackerthon.library.repository;

import jakarta.persistence.Id;
import kernel.hackerthon.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Id> {
}
