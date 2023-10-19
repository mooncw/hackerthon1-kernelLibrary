package kernel.hackerthon.library.repository;


import kernel.hackerthon.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends
        JpaRepository<Book, Long> {

    List<Book> findBooksByIsRentalIsFalse();

     List<Book> findBookByIsRecoveryIsFalseAndIsRentalIsFalse();

    List<Book> findBooksByUserIdAndIsRecoveryIsFalseAndIsRentalIsFalse(Long id);

     boolean existsBookByUserId(Long id);

     List<Book> findBooksByIsRecoveryIsFalse();

}


