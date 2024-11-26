package com.company.ex_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath + ".txt"))) {
            String line;
            String longestLine = "";
            int maxLength = 0;

            while ((line = reader.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }

            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Самая длинная строка: " + longestLine);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
