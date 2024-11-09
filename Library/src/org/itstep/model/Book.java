package org.itstep.model;

import org.itstep.service.book.BookPrintable;
import org.itstep.service.book.BookPrintableInterface;

public class Book extends Publication {
    private String author;
    private String genre;
    private int pageCount;
    private BookPrintableInterface printable;

    public Book(String title, String author, String genre, int pageCount) {
        super(title);
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
        this.printable = new BookPrintable();
    }

    @Override
    public void print() {
        printable.printBook(this);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
