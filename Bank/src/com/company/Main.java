package com.company;

import com.company.exeption.ATMException;
import com.company.exeption.InvalidAmountException;
import com.company.model.ATM;
import com.company.model.Bank;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Створюємо банк з 5-ма дефолтними банкоматами
            Bank bank = new Bank(2);

            // Додамо в банк ще один банкомат
            ATM atm = new ATM(20, 50);
            bank.addATM(atm);
            System.out.println("Банкомат додано в банк!");

            // Рахуємо спільну суму коштів в банкі
            System.out.println("Спільна сума коштів в банкі: " + bank.allSumMoney());

            // Виводимо кошти
            atm.withdrawMoney(650);
            System.out.println("Спільна сума коштів в банкі: " + bank.allSumMoney());

            // Додаємо купюри в один з банкоматів
            atm.loadCash(50, 20);
            System.out.println("Спільна сума коштів в банкі: " + bank.allSumMoney());


        }catch (ATMException e){
            System.out.println("Помилка: " + e.getMessage());
        }

    }
}