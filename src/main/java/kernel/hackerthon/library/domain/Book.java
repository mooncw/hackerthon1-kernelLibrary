package kernel.hackerthon.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long isbn;

    // false = 대출가능
    private Boolean rentalStatus;

    //-- 비즈니스 로직 --//
    public void changeRentalStatus(){
        this.rentalStatus = !rentalStatus;
    }

}
