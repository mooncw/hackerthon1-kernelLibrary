package kernel.hackerthon.library.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar", length = 255)
    private String name;

    @Column(name="is_rental", columnDefinition = "varchar", length = 255)
    private Boolean isRental;

    @Column(name="is_recovery", columnDefinition = "varchar", length = 255)
    private Boolean isRecovery;

    @Builder
    public Book(Long id, String name, Boolean isRental, Boolean isRecovery) {
        this.id = id;
        this.name = name;
        this.isRental = isRental;
        this.isRecovery = isRecovery;
    }
  
    // 대출 상태를 토글 하는 메서드 //
    public void changeRentalStatus(){
        this.isRental = !isRental;
    }
}
