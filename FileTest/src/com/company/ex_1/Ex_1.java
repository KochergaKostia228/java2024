package com.company.ex_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шлях до першого файлу:");
        String file1Path = scanner.nextLine();
        System.out.println("Введіть шлях до другого файлу:");
        String file2Path = scanner.nextLine();

        try{
            InputStream inputFile1 = new FileInputStream(file1Path + ".txt");
            InputStream inputFile2 = new FileInputStream(file2Path + ".txt");

            compareFiles(inputFile1, inputFile2);

            inputFile1.close();
            inputFile2.close();

        }catch (IOException e) {
            System.out.println("Помилка при читанні файлів: " + e.getMessage());
        }
    }

    private static void compareFiles(InputStream file1InputStream, InputStream file2InputStream) throws IOException {
        int byte1;
        int byte2;
        int position = 1;
        boolean isCorect = true;

        while ((byte1 = file1InputStream.read()) != -1 && (byte2 = file2InputStream.read()) != -1) {
            if (byte1 != byte2) {
                System.out.println("Несовпадающий байт на позиции " + position + ":");
                System.out.println("Файл 1: " + byte1);
                System.out.println("Файл 2: " + byte2);
                isCorect = false;
            }
            position++;
        }

        // Проверка на случай, если один файл длиннее другого
        if ((byte1 = file1InputStream.read()) != -1) {
            System.out.println("Файл 1 длиннее файла 2. Несовпадающий байт на позиции " + position + ": " + byte1);
            isCorect = false;
        } else if ((byte2 = file2InputStream.read()) != -1) {
            System.out.println("Файл 2 длиннее файла 1. Несовпадающий байт на позиции " + position + ": " + byte2);
            isCorect = false;
        }

        if(isCorect){
            System.out.println("Содержимое файлов совпадают");
        }

    }
}
