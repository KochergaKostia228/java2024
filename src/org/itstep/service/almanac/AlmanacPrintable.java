package org.itstep.service.almanac;

import org.itstep.model.Almanac;
import org.itstep.model.Book;
import org.itstep.service.book.BookPrintableInterface;

public class AlmanacPrintable implements AlmanacPrintableInterface {
    @Override
    public void printAlmanac(Almanac almanac) {
        System.out.println("--------------Almanac----------------");
        System.out.println("Title is " + almanac.getTitle());
        System.out.print("Works: [ ");
        for(int i = 0; i < almanac.getWorks().length; i++){
            System.out.print(almanac.getWorks()[i].getTitle());
            System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("-".repeat(40));
    }
}
