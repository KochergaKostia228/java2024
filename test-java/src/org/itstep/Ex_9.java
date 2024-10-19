package org.itstep;

import java.util.Random;
import java.util.Scanner;

public class Ex_9 {
    public static void main(String[] args) {
        Random rand = new Random();
        int arraySize = 10;
        int[] arr = new int[arraySize];

        // Заповнюємо масив випадковими числами
        for (int i = 0; i < arraySize; i++) {
            arr[i] = rand.nextInt(21) - 10; // Випадкові числа від -10 до 10
        }

        for (int i = 0; i < arraySize; i++) {
            System.out.print(arr[i] + " ");
        }

        int min = arr[0];
        int max = arr[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < arraySize; i++) {
            if(arr[i] > 0){
                positiveCount++;
            } else if (arr[i] < 0) {
                negativeCount++;
            } else{
                zeroCount++;
            }

            if (arr[i] < min){
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }

        System.out.println(" ");
        System.out.println("Мінімальне число: " + min);
        System.out.println("Максимальне число: " + max);
        System.out.println("Кількість мінусових чисел: " + negativeCount);
        System.out.println("Кількість плюсових чисел: " + positiveCount);
        System.out.println("Кількість нулів: " + zeroCount);
    }
}
