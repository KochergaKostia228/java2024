package org.itstep;

import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть першу цифру: ");
        int a = scanner.nextInt();
        System.out.print("Введіть другу цифру: ");
        int b = scanner.nextInt();
        System.out.print("Введіть третью цифру: ");
        int c = scanner.nextInt();

        if(a > 9 || b > 9 || c > 9 || a < 0 || b < 0 || c < 0) {
            System.out.print("Ви ввели число більше ніж 9 або мінусове число");
        }
        else{
            a *= 100;
            b *= 10;

            int number = a + b + c;

            System.out.print("Результат: " + number);
        }
    }
}
