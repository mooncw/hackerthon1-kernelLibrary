package kernel.hackerthon.library.dto;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecoverBookRequest {
    private Long bookId;
    public static Book toEntity(Book book) {
        return Book.builder()
                .id(book.getId())
                .build();
    }
}
