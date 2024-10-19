package org.itstep;

import java.util.Scanner;

public class Ex_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше число: ");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();

        System.out.println("Таблиця множення в діапазоні від " + a + " до " + b + ": ");

        for (int i = a; i <= b; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d x %d = %d%n", i, j, i * j);
            }
            System.out.println();
        }
    }
}
