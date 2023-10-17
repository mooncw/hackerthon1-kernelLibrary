package kernel.hackerthon.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id") // 'user' 테이블과 연결된 외래 키 (user 엔티티의 기본 키)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id") // 'book' 테이블과 연결된 외래 키 (book 엔티티의 기본 키)
    private Book book;

    @Column(name = "loan_date")
    private Date loanDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "loan_status")
    private Boolean loanStatus;
}
