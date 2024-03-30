import cz.czechitas.ukol07.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void testSetAuthorValid() throws IllegalAccessException {
        Book book = new Book();
        book.setAuthor("Jack Kerouac");
        assertEquals("Jack Kerouac", book.getAuthor());
    }

    @Test
    public void testSetNameValid() throws IllegalAccessException {
        Book book = new Book();
        book.setName("On The Road");
        assertEquals("On The Road", book.getName());
    }

    @Test
    public void testSetYearValid() throws IllegalAccessException {
        Book book = new Book();
        book.setPublicationYear(1957);
        assertEquals(1957, book.getPublicationYear());
    }


    @Test
    public void testSetAuthorNull(){
        Book book = new Book();
        assertThrows(IllegalArgumentException.class, () -> book.setAuthor(null));
    }

    @Test
    public void testSetNameEmpty(){
        Book book = new Book();
        assertThrows(IllegalArgumentException.class, () -> book.setName(""));
    }

    @Test
    public void testSetYearInvalidPastYear(){
        Book book = new Book();
        assertThrows(IllegalArgumentException.class, () -> book.setPublicationYear(500));
    }

    @Test
    public void testSetYearInvalidFutureYear(){
        Book book = new Book();
        assertThrows(IllegalArgumentException.class, () -> book.setPublicationYear(5000));
    }
}
