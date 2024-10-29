package org.itstep.model;

import org.itstep.service.almanac.AlmanacPrintable;
import org.itstep.service.almanac.AlmanacPrintableInterface;

public class Almanac extends Publication{
    private Book[] works;
    private AlmanacPrintableInterface printable;

    public Almanac(String title, Book[] works) {
        super(title);
        this.works = works;
        this.printable = new AlmanacPrintable();
    }

    @Override
    public void print() {
        printable.printAlmanac(this);
    }

    public Book[] getWorks() {
        return works;
    }

    public void setWorks(Book[] works) {
        this.works = works;
    }
}
