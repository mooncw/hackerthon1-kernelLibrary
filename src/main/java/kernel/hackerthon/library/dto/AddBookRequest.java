package kernel.hackerthon.library.dto;

import kernel.hackerthon.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Getter
public class AddBookRequest {
    private String name;
    private Long isbn;

    public Book toEntity(){
        return Book.builder()
                .name(name).isbn(isbn).rentalStatus(true)
                .build();
    }
}
