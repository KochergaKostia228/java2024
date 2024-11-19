package com.compane.ex_3;

import com.compane.ex_2.Ex_2;

import java.util.List;
import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Device> devices= List.of(
                new Device("Smartphone", 2020, 500.0, "Black", "Phone"),
                new Device("Laptop", 2021, 1500.0, "Silver", "Computer"),
                new Device("Tablet", 2022, 800.0, "White", "Tablet"),
                new Device("SmartWatch", 2023, 200.0, "Black", "Watch"),
                new Device("SmartTV", 2020, 1000.0, "Black", "TV")
        );

        //1
        System.out.println("Всі девайси:");
        devices.stream()
                .map(Device::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //2
        System.out.println("Введіть колір для пошуку:");
        String color = scanner.nextLine();
        System.out.println(" ");

        System.out.println("Всі девайси заданого кольору:");
        devices.stream()
                .filter(x -> x.getColor().equalsIgnoreCase(color))
                .map(Device::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //3
        System.out.println("Введіть рік випуску для пошуку:");
        Integer year = scanner.nextInt();
        System.out.println(" ");

        System.out.println("Всі девайси заданого року випуску:");
        devices.stream()
                .filter(x -> x.getYearRelease() == year)
                .map(Device::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //4
        System.out.println("Введіть ціну для пошуку:");
        Double pay = scanner.nextDouble();
        System.out.println(" ");

        System.out.println("Всі девайси дорожчі заданої ціни:");
        devices.stream()
                .filter(x -> x.getPay() > pay)
                .map(Device::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //5
        System.out.println("Введіть тип девайсу для пошуку:");
        String type = scanner.nextLine();
        System.out.println(" ");

        System.out.println("Всі девайси заданого типу:");
        devices.stream()
                .filter(x -> x.getType().equalsIgnoreCase(type))
                .map(Device::getName)
                .forEach(System.out::println);

        System.out.println(" ");

        //6
        System.out.println("Введіть початковий рік діапазону:");
        int startYears = scanner.nextInt();

        System.out.println("Введіть кінцевий рік діапазону:");
        int endYear = scanner.nextInt();
        System.out.println(" ");

        System.out.println("Всі девайси в яких дата випуску від " + startYears + "до " + endYear + ": ");
        devices.stream()
                .filter(x -> x.getYearRelease() >= startYears && x.getYearRelease() <= endYear)
                .map(Device::getName)
                .forEach(System.out::println);

        System.out.println(" ");
    }
}
