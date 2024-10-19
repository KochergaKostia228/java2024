package org.itstep;

import java.util.Scanner;

public class Ex_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість метрів: ");
        int metr = scanner.nextInt();

        if(metr > 0){
            System.out.print("Введіть число яке стоїть перед величиною в яку ви хочете перевести метри:\n" +
                    "1) Миль\n" +
                    "2) Дюйми\n" +
                    "3) Ярди\n");
            int a = scanner.nextInt();
            double number = 0;

            if(a == 1){
                number = metr * 0.00062137;
                System.out.print("Результат: " + number);
            } else if (a == 2) {
                number = metr * 39.3700787;
                System.out.print("Результат: " + number);
            } else if (a == 3) {
                number = metr * 1.0936133 ;
                System.out.print("Результат: " + number);
            }else {
                System.out.print("Ви ввели неправильне число із перечислених");
            }
        }
        else{
            System.out.print("Ви ввели мінусове число");
        }
    }
}
