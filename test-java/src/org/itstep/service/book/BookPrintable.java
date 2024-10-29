package org.itstep.service.book;

import org.itstep.model.Book;

public class BookPrintable implements BookPrintableInterface{
    @Override
    public void printBook(Book book) {
        System.out.println("--------------Book----------------");
        System.out.println("Title is " + book.getTitle());
        System.out.println("Author is " + book.getAuthor());
        System.out.println("Genre is " + book.getGenre());
        System.out.println("Count pages is " + book.getPageCount());
        System.out.println("-".repeat(40));
    }
}
