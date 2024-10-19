package org.itstep;

import java.util.Scanner;

public class Ex_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число від 1 до 12: ");
        int number = scanner.nextInt();

        if(number == 1 || number == 2 || number == 12){
            System.out.print("Winter");
        }
        else if(number == 3 || number == 4 || number == 5){
            System.out.print("Spring");
        }
        else if(number == 6 || number == 7 || number == 8){
            System.out.print("Summer");
        }
        else if (number == 9 || number == 10 || number == 11) {
            System.out.print("Autumn");
        }
        else{
            System.out.print("Ви ввели некоректное число");
        }
    }
}
