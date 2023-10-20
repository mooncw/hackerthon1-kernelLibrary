package kernel.hackerthon.library.dto;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.Rental;
import kernel.hackerthon.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequest {
    private Long userId;
    private Long bookId;
    private Long rentalId;

    public static Rental toEntity(User user, Book book) {
        return Rental.builder()
                .user(user)
                .book(book)
                .build();
    }
}
