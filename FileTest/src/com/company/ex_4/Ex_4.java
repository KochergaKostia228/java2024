package com.company.ex_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();

        while(true){
            System.out.println("Введите число для масива, если вы написали все числа то напишите \"e\":");
            String number = scanner.nextLine();

            if(number.equals("e")){
                System.out.println("Цикл завершен.");
                break;
            }

            if(!isInteger(number)){
                System.out.println("Введите число а не символ");
            }else{
                numbers.add(Integer.parseInt(number));
            }
        }

        // Разделение массива на четные и нечетные
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }

        // Перевёрнутый массив
        List<Integer> reversedArray = new ArrayList<>();

        for (int i = numbers.size()-1; i >= 0; i--) {
            reversedArray.add(numbers.get(i));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".txt"))) {
            // Запись исходного массива
            writer.write(arrayListToString(numbers));
            writer.newLine();

            // Запись четных чисел
            writer.write(arrayListToString(evenList));
            writer.newLine();

            // Запись нечетных чисел
            writer.write(arrayListToString(oddList));
            writer.newLine();

            // Запись перевёрнутого массива
            writer.write(arrayListToString(reversedArray));
            writer.newLine();

            System.out.println("Данные успешно записаны в файл!");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);  // Попытка преобразования в int
            return true;
        } catch (NumberFormatException e) {
            return false;  // Если строка не является числом
        }
    }

    // Метод для преобразования списка в строку
    private static String arrayListToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
