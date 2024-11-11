package seminars.fourth.book;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.assertj.core.api.Assertions.assertThat;

public class BookServiceTest {

    @Test
    public void testFindBookById() {

        BookRepository mockBookRepository = mock(BookRepository.class);

        Book mockBook = new Book("1", "Book1", "Author1");

        when(mockBookRepository.findById("1")).thenReturn(mockBook);

        BookService bookService = new BookService(mockBookRepository);

        Book foundBook = bookService.findBookById("1");

        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getId()).isEqualTo("1");
        assertThat(foundBook.getTitle()).isEqualTo("Book1");
        assertThat(foundBook.getAuthor()).isEqualTo("Author1");

        verify(mockBookRepository, times(1)).findById("1");
    }

    @Test
    public void testFindAllBooks() {

        BookRepository mockBookRepository = mock(BookRepository.class);

        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");

        when(mockBookRepository.findAll()).thenReturn(List.of(book1, book2));

        BookService bookService = new BookService(mockBookRepository);

        List<Book> books = bookService.findAllBooks();

        assertThat(books).hasSize(2);
        assertThat(books.get(0).getId()).isEqualTo("1");
        assertThat(books.get(1).getId()).isEqualTo("2");

        verify(mockBookRepository, times(1)).findAll();
    }
}
