package com.company;

import com.company.exeption.ATMException;
import com.company.exeption.InvalidAmountException;
import com.company.model.ATM;
import com.company.model.Bank;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            try {
                // Меню взаимодействия с пользователем
                System.out.println("\nМеню:");
                System.out.println("1. Добавить банкомат");
                System.out.println("2. Загрузить деньги в банкомат");
                System.out.println("3. Снять деньги с банкомата");
                System.out.println("4. Получить общий баланс");
                System.out.println("5. Выход");
                System.out.print("Выберите опцию: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Введіть максимальну кількість видачі банкнот в банкоматі: ");
                        int maxNotes = scanner.nextInt();
                        System.out.print("Введіть мінімальну суму зняття коштів в банкоматі: ");
                        int minAmount = scanner.nextInt();
                        bank.addATM(new ATM(maxNotes, minAmount));
                        break;
                    case 2:
                        bank.loadMoneyToATM(bank);
                        break;
                    case 3:
                        withdrawMoneyFromATM(bank);
                        break;
                    case 4:
                        showTotalBalance(bank);
                        break;
                    case 5:
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверный выбор! Попробуйте снова.");
                        break;
                }
            } catch (ATMException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

    }
}