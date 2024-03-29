package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplication {
    public static void main (String[] args) {
        BookService bookService = new BookService();

        // Print total number of books
        System.out.println("Total number of books: " + bookService.getAllBooks().size());

        // Print names of all books by Karel Čapek
      List<Book> booksByKarelCapek = bookService.getBooksByAuthor("Karel Čapek");
        System.out.println("Books by Karel Čapek:");
        for (Book book : booksByKarelCapek) {
            System.out.println(book.getName());
        }

        // Print all books first published in 1845
        List<Book> booksPublishedIn1845 = bookService.getBooksByYear(1845);
        System.out.println("Books first published in 1845:");
        for (Book book : booksPublishedIn1845) {
            System.out.println(book.getAuthor() + ": " + book.getName());
        }
    }
}
