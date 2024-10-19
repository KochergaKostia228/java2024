package org.itstep;

import java.util.Scanner;

public class Ex_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше число: ");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();

        if(a > b) {
            System.out.println("Всі непарні числа в діапазоні від " + a + " до " + b + ": ");

            for (int i = b; i < a; i++){
                if (i % 2 != 0){
                    System.out.print(i + " ");
                }
            }
        }
        else{
            System.out.println("Всі непарні числа в діапазоні від " + b + " до " + a + ": ");

            for (int i = a; i < b; i++){
                if (i % 2 != 0){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
