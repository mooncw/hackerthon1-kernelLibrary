package kernel.hackerthon.library.service;

import kernel.hackerthon.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {
//    @Autowired
//    BookService bookService;
//    @Test
//    void recover() {
//        // given
//        Long testBookId = 1L;
//        bookService.save(Book.builder().name("testBookName").isRental(false).isRecovery(false).build());
//
//        //when
//        bookService.recover(testBookId);
//
//        // then
//        Book recoveredBook = bookService.getBook(testBookId).orElseThrow();
//        assertThat(recoveredBook.getIsRecovery()).isEqualTo(true);
//    }
}