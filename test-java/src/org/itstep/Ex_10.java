package org.itstep;

import java.util.Random;

public class Ex_10 {
    public static void main(String[] args) {
        Random rand = new Random();
        int arraySize = 10;
        int[] arr = new int[arraySize];

        // Заповнюємо масив випадковими числами
        for (int i = 0; i < arraySize; i++) {
            arr[i] = rand.nextInt(21) - 10; // Випадкові числа від -10 до 10
        }

        // Виводимо массив
        for (int i = 0; i < arraySize; i++) {
            System.out.print(arr[i] + " ");
        }

        int negativeCount = 0;
        int positiveCount = 0;
        int oddCount = 0;
        int evenCount = 0;

        // Дізнаємось розмір кожного із 4-ох масивів
        for (int i = 0; i < arraySize; i++) {
            if(arr[i] > 0){
                positiveCount++;
            }
            if (arr[i] < 0) {
                negativeCount++;
            }

            if (arr[i] % 2 == 0){
                evenCount++;
            }
            if (arr[i] % 2 != 0){
                oddCount++;
            }
        }

        // Створюємо массиви
        int[] arrEven = new int[evenCount];
        int[] arrOdd = new int[oddCount];
        int[] arrNegative = new int[negativeCount];
        int[] arrPositive = new int[positiveCount];

        // Обнуляємо для заповнення массиву з конкретних чисел
        negativeCount = 0;
        positiveCount = 0;
        oddCount = 0;
        evenCount = 0;

        //Заповнюємо массиви конкретними данними
        for (int i = 0; i < arraySize; i++) {
            if(arr[i] % 2 == 0 && arrEven.length != 0){
                arrEven[evenCount] = arr[i];
                evenCount++;
            }
            if (arr[i] % 2 != 0 && arrOdd.length != 0){
                arrOdd[oddCount] = arr[i];
                oddCount++;
            }
            if (arr[i] < 0 && arrNegative.length != 0){
                arrNegative[negativeCount] = arr[i];
                negativeCount++;
            }
            if (arr[i] > 0 && arrPositive.length != 0){
                arrPositive[positiveCount] = arr[i];
                positiveCount++;
            }
        }

        // Виводимо массив з парних чисел
        System.out.println(" ");
        System.out.print("Массив з парних чисел: ");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(arrEven[i] + " ");
        }
        // Виводимо массив з непарних чисел
        System.out.println(" ");
        System.out.print("Массив з непарних чисел: ");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(arrOdd[i] + " ");
        }// Виводимо массив з мінусових чисел
        System.out.println(" ");
        System.out.print("Массив з мінусових чисел: ");
        for (int i = 0; i < negativeCount; i++) {
            System.out.print(arrNegative[i] + " ");
        }// Виводимо массив з плюсових чисел
        System.out.println(" ");
        System.out.print("Массив з плюсових чисел: ");
        for (int i = 0; i < positiveCount; i++) {
            System.out.print(arrPositive[i] + " ");
        }
    }
}
