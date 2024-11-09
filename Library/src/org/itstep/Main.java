package org.itstep;

import itstep.model.*;
import org.itstep.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Створюємо публікації
        PublicationInterface book1 = new Book("The Adventures of Tom Sawyer", "Mark Tven", "Fiction", 200);
        PublicationInterface book2 = new Book("Eneida", "Ivan Kotlyarevskyi", "poem", 500);

        PublicationInterface newspaper = new Newspaper("England lost in the Euro 2024 final to Spain", "14,07,2024", new String[]{"Euro 2024", "Spain win Euro 2024"});

        PublicationInterface almanac = new Almanac("Almanac 1", new Book[]{
                (Book) book1,
                (Book) book2
        });

        //Створюємо каталог
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.addItem(book1);
        catalog.addItem(book2);
        catalog.addItem(newspaper);
        catalog.addItem(almanac);

        //Шукаємо коритувача
        catalog.searchByTitle("Eneida");
        catalog.searchByAuthor("Mark Tven");

        //Вивід на екран всіх публікацій в каталогі
        catalog.showItems();
    }
}