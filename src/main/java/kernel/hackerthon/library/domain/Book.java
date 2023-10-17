package kernel.hackerthon.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity @Builder @RequiredArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long isbn;

<<<<<<< HEAD
    // false = 대출가능
    private Boolean rentalStatus;

    //-- 비즈니스 로직 --//
    public void changeRentalStatus(){
        this.rentalStatus = !rentalStatus;
    }
=======
    private boolean rentalStatus;
>>>>>>> da8ea1fea40ebb33f00ef1f23caae2c12a13a37e

    //-- 비즈니스 로직 --//
    // 대출 상태를 토글 하는 메서드 //
    public void changeRentalStatus(){
        this.rentalStatus = !rentalStatus;
    }
}
