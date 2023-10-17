package kernel.hackerthon.library.repository;


import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface UserRepository extends
        JpaRepository<User, Long>
{}
=======
public interface UserRepository extends JpaRepository<User, Long> {
}

>>>>>>> da8ea1fea40ebb33f00ef1f23caae2c12a13a37e
