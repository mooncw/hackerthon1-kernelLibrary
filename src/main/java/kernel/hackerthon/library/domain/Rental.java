package kernel.hackerthon.library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@Builder
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    // 유저 정보를 id로 연결
    @ManyToOne(optional = false) @JoinColumn(name = "id") private User user;

    // 북 정보를 id로 연결
    @ManyToOne(optional = false) @JoinColumn(name = "id") private Book book;


    @Column(name ="loan_date")
    private Date loanDate;

    @Column(name ="return_date")
    private Date returnDate;

    @Column(name = "loan_status")
    private Boolean loanStatus;


    public Rental() {

    }
}
