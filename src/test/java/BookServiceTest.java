import cz.czechitas.ukol07.Book;
import cz.czechitas.ukol07.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    private BookService bookService;
    private List<Book> mockBooks;

    @BeforeEach
    void  setUp() {
        bookService = new BookService();

        mockBooks = List.of(
                new Book("Author 01", "Book 1", 1991),
                new Book("Author 02", "Book 2", 1991),
                new Book("Author 01", "Book 3", 1993)
        );
    }

    @Test
    void  testGetAllBooks() {
        bookService.books=mockBooks;
        assertEquals(mockBooks, bookService.getAllBooks());
    }

    @Test
    void testGetBooksByAuthor() {
        bookService.books = mockBooks;

        List<Book> booksByAuthor1 = bookService.getBooksByAuthor("Author 01");
        List<Book>booksByAuthor2 = bookService.getBooksByAuthor("Author 02");

        assertEquals(2, booksByAuthor1.size());
        assertEquals(1,booksByAuthor2.size());
    }

    @Test
    void testGetBookByYear() {
        bookService.books = mockBooks;

        List<Book> booksByYear1991 = bookService.getBooksByYear(1991);
        List<Book> booksByYear1993 = bookService.getBooksByYear(1993);
        List<Book> booksByYear2000 = bookService.getBooksByYear(2000);

        assertEquals(2, booksByYear1991.size());
        assertEquals(1, booksByYear1993.size());
        assertEquals(0, booksByYear2000.size());

    }

}
