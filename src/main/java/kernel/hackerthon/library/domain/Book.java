package kernel.hackerthon.library.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "varchar", length = 255)
    private String name;
    @Column(name = "isbn", columnDefinition = "varchar", length = 255)
    private Long isbn;
    // false = 대출가능
    private Boolean rentalStatus;

    @Builder
    public Book(String name, Long isbn, boolean rentalStatus){
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
