package org.itstep.service.newspaper;

import com.sun.net.httpserver.Headers;
import org.itstep.model.Book;
import org.itstep.model.Newspaper;

public class NewspaperPrintable implements NewspaperPrintableInterface {

    @Override
    public void printNewspaper(Newspaper newspaper) {
        System.out.println("--------------Newspaper----------------");
        System.out.println("Title is " + newspaper.getTitle());
        System.out.println("Release is " + newspaper.getReleaseDate());
        System.out.print("Headers: [ ");
        for(int i = 0; i < newspaper.getHeadlines().length; i++){
            System.out.print(newspaper.getHeadlines()[i]);
            System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("-".repeat(40));
    }
}
