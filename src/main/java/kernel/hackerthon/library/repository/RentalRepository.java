package kernel.hackerthon.library.repository;

import jakarta.persistence.Id;
import kernel.hackerthon.library.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Id> {
}
