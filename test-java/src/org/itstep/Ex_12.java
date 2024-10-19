package org.itstep;

import java.util.Random;
import java.util.Scanner;

public class Ex_12 {
    public static void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void reverseSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int arraySize = 10;
        int[] arr = new int[arraySize];
        Scanner scanner = new Scanner(System.in);

        // Заповнюємо масив випадковими числами
        for (int i = 0; i < arraySize; i++) {
            arr[i] = rand.nextInt(21) - 10; // Випадкові числа від -10 до 10
        }

        System.out.print("Введите 'asc' для сортировки по возрастанию или 'desc' для сортировки по убыванию: ");
        String userChoice = scanner.nextLine();

        if (userChoice.equals("asc")) {
            sort(arr);
            System.out.println("Отсортированный массив:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else if (userChoice.equals("desc")) {
            reverseSort(arr);
            System.out.println("Отсортированный массив:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }

    }
}
