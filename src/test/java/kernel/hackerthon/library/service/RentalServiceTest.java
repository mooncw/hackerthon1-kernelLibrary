package kernel.hackerthon.library.service;

import kernel.hackerthon.library.domain.Book;
import kernel.hackerthon.library.domain.User;
import kernel.hackerthon.library.dto.RentalRequest;
import kernel.hackerthon.library.repository.BookRepository;
import kernel.hackerthon.library.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RentalServiceTest {
    @Autowired
    private RentalService rentalService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자의 도서 대여를 테스트한다.")
    void 도서대여() {
        // given
        User savedUser = userRepository.save(new User(null, null, null, null));
        Book savedBook = bookRepository.save(new Book(null, null, null, null, null));
        RentalRequest rentalRequest = new RentalRequest(savedUser.getId(), savedBook.getId(), 1L);

        // when
//        Long savedRentalId = rentalService.rentalByBook(rentalRequest, new Http);

        // then
//        assertThat(savedRentalId).isNotNull();
    }
}