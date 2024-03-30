package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public List<Book> books;

    public BookService() {
        try (InputStream inputStream = BookService.class.getResourceAsStream("books.json")) {
            if (inputStream == null) {
                throw new IOException("Failed to load books.json. Resource not found.");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            books = objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            String message = "Failed to load books from JSON file: " + e.getMessage();
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public List<Book> getBooksByYear(int year) {
        List<Book> booksByYear = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublicationYear() == year)                                                                                                                                          {
                booksByYear.add(book);
            }
        }
        return booksByYear;
    }

    public void listAllBooks() {
        for (Book book: books) {
            System.out.println("Title: "+ book.getName());
            System.out.println("Author: "+ book.getAuthor());
            System.out.println("Year of publication: " + book.getPublicationYear());
            System.out.println("------------------------------------------------");
        }
    }
}
