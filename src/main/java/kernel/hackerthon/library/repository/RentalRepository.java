package kernel.hackerthon.library.repository;

import jakarta.persistence.Id;
import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findByReturnDateIsNullAndIdAndUserId(Long rentalId, Long userId);

    List<Rental> findRentalsByUserIdAndReturnDateIsNull(Long userId);
}
