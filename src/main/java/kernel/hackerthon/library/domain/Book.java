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

    private boolean rentalStatus;

    //-- 비즈니스 로직 --//
    // 대출 상태를 토글 하는 메서드 //
    public void changeRentalStatus(){
        this.rentalStatus = !rentalStatus;
    }
}
