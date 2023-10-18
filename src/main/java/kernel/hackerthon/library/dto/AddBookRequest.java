package kernel.hackerthon.library.dto;

import kernel.hackerthon.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookRequest {
    private String bookname;

    public Book toEntity(){
        return Book.builder()
                .name(bookname).isRental(false).isRecovery(false)
                .build();
    }
}
