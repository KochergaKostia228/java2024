package org.itstep.model;

import org.itstep.service.newspaper.NewspaperPrintable;
import org.itstep.service.newspaper.NewspaperPrintableInterface;

public class Newspaper extends Publication{
    private String releaseDate;
    private String[] headlines;
    private NewspaperPrintableInterface printable;

    public Newspaper(String title, String releaseDate, String[] headlines) {
        super(title);
        this.headlines = headlines;
        this.releaseDate = releaseDate;
        this.printable = new NewspaperPrintable();
    }

    @Override
    public void print() {
        printable.printNewspaper(this);
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String[] headlines) {
        this.headlines = headlines;
    }
}
