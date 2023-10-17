package kernel.hackerthon.library.repository;

import jakarta.persistence.Id;
import kernel.hackerthon.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Id> {

}
