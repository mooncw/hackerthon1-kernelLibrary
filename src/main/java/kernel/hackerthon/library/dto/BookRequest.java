package kernel.hackerthon.library.dto;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {
    private String bookname;
    private User user;
    public Book toEntity(User user){
        return Book.builder()
                .name(bookname).isRental(false).isRecovery(false).user(user)
                .build();
    }
}
