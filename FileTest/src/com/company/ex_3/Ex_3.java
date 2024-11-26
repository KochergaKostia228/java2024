package com.company.ex_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath + ".txt"));
            String line;
            List<int[]> arrays = new ArrayList<>();
            int totalSum = 0;
            int globalMax = Integer.MIN_VALUE;
            int globalMin = Integer.MAX_VALUE;

            while ((line = reader.readLine()) != null) {

                String[] strNumbers = line.split(" ");
                int[] array = new int[strNumbers.length];

                int sum = 0;
                int localMax = Integer.MIN_VALUE;
                int localMin = Integer.MAX_VALUE;

                for (int i = 0; i < strNumbers.length; i++) {
                    array[i] = Integer.parseInt(strNumbers[i]);
                    sum += array[i];
                    localMax = Math.max(localMax, array[i]);
                    localMin = Math.min(localMin, array[i]);
                }

                arrays.add(array);
                totalSum += sum;

                globalMax = Math.max(globalMax, localMax);
                globalMin = Math.min(globalMin, localMin);

                // Выводим информацию о текущем массиве
                System.out.println("Массив " + arrays.size() + ": " + Arrays.toString(array));
                System.out.println("Максимум в массиве: " + localMax);
                System.out.println("Минимум в массиве: " + localMin);
                System.out.println("Сумма элементов массива: " + sum);
                System.out.println();
            }

            reader.close();

            // Выводим итоговые результаты
            System.out.println("Глобальный максимум среди всех массивов: " + globalMax);
            System.out.println("Глобальный минимум среди всех массивов: " + globalMin);
            System.out.println("Общая сумма всех массивов: " + totalSum);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
