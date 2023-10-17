package kernel.hackerthon.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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
}

