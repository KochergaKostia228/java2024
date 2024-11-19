package com.compane.ex_1;

import java.util.ArrayList;
import java.util.List;

public class Ex_1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(121, -33, 4224, 100, 45, -99, 222, 0, -121);

        //1
        long positiveNumbers = numbers.stream().filter(x -> x > 0).count();
        System.out.println("Кількість позитивних чисел: " + positiveNumbers);

        //2
        long negativeNumbers = numbers.stream().filter(x -> x < 0).count();
        System.out.println("Кількість негативних чисел: " + negativeNumbers);

        //3
        long twoDigitPositiveNumbers = numbers.stream().filter(x -> x / 10 >= 1 && x / 10 <= 9).count();
        long twoDigitNegativeNumbers = numbers.stream().filter(x -> x / 10 <= -1 && x / 10 >= -9).count();
        long twoDigitNumbers = twoDigitNegativeNumbers + twoDigitPositiveNumbers;
        System.out.println("Кількість двухзначних чисел: " + twoDigitNumbers);

        //4
        long palindromeNumbers = numbers.stream().filter(Ex_1::isPalindrome).count();
        System.out.println("Кількість чисел паліндромом: " + palindromeNumbers);
    }

    // Метод для перевірки, являється це число зеркальним (паліндромом)
    private static boolean isPalindrome(int num) {
        String strNum = String.valueOf(Math.abs(num)); // работаем с модулем числа
        String reversed = new StringBuilder(strNum).reverse().toString();
        return strNum.equals(reversed);
    }
}
