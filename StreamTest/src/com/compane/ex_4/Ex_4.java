package com.compane.ex_4;

import com.compane.ex_3.Device;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Projector> projectors = List.of(
                new Projector("Epson XG5000", 2023, 25000.0, "Epson"),
                new Projector("BenQ HT3550", 2022, 30000.0, "BenQ"),
                new Projector("Optoma UHD50X", 2023, 45000.0, "Optoma"),
                new Projector("LG PF50KA", 2021, 15000.0, "LG"),
                new Projector("Epson EH-TW7100", 2023, 60000.0, "Epson"),
                new Projector("BenQ TK800M", 2022, 35000.0, "BenQ")
        );

        //1
        System.out.println("Всі проектори:");
        projectors.stream()
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //2
        System.out.println("Введіть виробника для пошуку:");
        String manufacturer = scanner.nextLine();
        System.out.println(" ");

        System.out.println("Всі проектори одного виробника:");
        projectors.stream()
                .filter(x -> x.getManufacturer().equalsIgnoreCase(manufacturer))
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //3
        System.out.println("Введіть рік випуску для пошуку:");
        Integer year = scanner.nextInt();
        System.out.println(" ");

        System.out.println("Всі проектори заданого року випуску:");
        projectors.stream()
                .filter(x -> x.getYearRelease() == year)
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //4
        System.out.println("Введіть ціну для пошуку:");
        Double pay = scanner.nextDouble();
        System.out.println(" ");

        System.out.println("Всі проектори дорожчі заданої ціни:");
        projectors.stream()
                .filter(x -> x.getPay() > pay)
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //5
        System.out.println("Всі проектори отсортовані по ціні (за зростанням):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPay))
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //6
        System.out.println("Всі проектори отсортовані по ціні (за спаданням):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPay).reversed())
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //7
        System.out.println("Всі проектори отсортовані по року випуску (за зростанням):");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYearRelease))
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //8
        System.out.println("Всі проектори отсортовані по року випуску (за спаданням):");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYearRelease).reversed())
                .map(Projector::getName)
                .forEach(System.out::println);

        System.out.println(" ");
    }
}
