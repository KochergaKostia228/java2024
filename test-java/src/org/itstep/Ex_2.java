package org.itstep;

import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        double number = scanner.nextDouble();
        System.out.print("Введіть відсоток: ");
        double percent = scanner.nextDouble();

        if(percent > 0 && number > 0) {
            percent *= 0.01;

            System.out.print("Результат: " + number * percent);
        }
        else{
            System.out.print("Ви ввели мынусове число або выдсоток");
        }
    }
}
