package kernel.hackerthon.library.repository;

import jakarta.persistence.Id;
import kernel.hackerthon.library.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findByRentalDateIsNotNullAndIdAndUserId(Long rentalId, Long userId);
}
