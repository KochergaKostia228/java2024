package org.itstep;

import java.util.Scanner;

public class Ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шестизначне число: ");
        String number = scanner.nextLine();
        int digitCount = number.replace("-", "").length();

        if(digitCount != 6) {
            System.out.print("Ви ввели не шестизначне число");
        }
        else{
            String newNumber = "" + number.charAt(5) + number.charAt(4) + number.charAt(3) +
                    number.charAt(2) + number.charAt(1) + number.charAt(0);
            System.out.println("Нове число: " + newNumber);
        }
    }
}
