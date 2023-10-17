package kernel.hackerthon.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity  @RequiredArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long isbn;

    private boolean rentalStatus;
    @Builder
    public Book(String name,Long isbn,boolean rentalStatus){
        this.name = name;
        this.isbn = isbn;
        this.rentalStatus = rentalStatus;
    }

    //-- 비즈니스 로직 --//
    // 대출 상태를 토글 하는 메서드 //
    public void changeRentalStatus(){
        this.rentalStatus = !rentalStatus;
    }
}
