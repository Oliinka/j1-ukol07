package cz.czechitas.ukol07;


import java.time.Year;

public class Book {
    private String author;
    private String name;
    private int publicationYear;

    public Book(String author, String name, int publicationYear) {
        this.author = author;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public Book() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalAccessException {
        if (author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Author's name can't be null or empty.");
        }
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Book's name can't be null or empty.");
        }
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        int currentYear = Year.now().getValue();
        if(publicationYear < 1440){
            throw new IllegalArgumentException("The printing press was invented 1440. Are you sure your book was published earlier?");
        } else if (publicationYear > currentYear) {
            throw new IllegalArgumentException("Publication year can not be in the future.");
        }
        this.publicationYear = publicationYear;
    }
}
