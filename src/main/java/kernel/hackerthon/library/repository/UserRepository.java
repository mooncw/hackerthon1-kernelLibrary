package kernel.hackerthon.library.repository;


import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {
}
