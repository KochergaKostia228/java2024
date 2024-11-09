package org.itstep.service.almanac;

import org.itstep.model.Almanac;

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
