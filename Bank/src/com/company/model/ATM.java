package com.company.model;

import com.company.exeption.InsufficientFundsException;
import com.company.exeption.InvalidAmountException;
import com.company.exeption.InvalidDenominationException;

public class ATM {
    private Bill[] bills = new Bill[]{
            new Bill(1, 10),
            new Bill(2, 5),
            new Bill(5, 20),
            new Bill(10, 100),
            new Bill(20, 200),
            new Bill(50, 75),
            new Bill(100, 60),
            new Bill(200, 75),
            new Bill(500, 50),
    };
    private int maxNotes; // Максимальна кількість банкнот, яку можна видати
    private int minAmount; // Мінімальна сума для зняття коштів

    public ATM(int maxNotes, int minAmount) {
        this.maxNotes = maxNotes;
        this.minAmount = minAmount;
    }

    public void loadCash(int nominal, int count) throws InvalidDenominationException {
        boolean isNominal = false;
        for (int i = 0; i < getBills().length; i++) {
            if(getBills()[i].getNominal() == nominal){
                int totalCount = count + getBills()[i].getCount();
                getBills()[i].setCount(totalCount);
                isNominal = true;
            }
        }

        if(!isNominal){
            throw new InvalidDenominationException("Ви вказали невірний номінал банкноти: " + nominal);
        }
    }

    public Bill[] withdrawMoney(int money) throws InvalidAmountException, InsufficientFundsException{
        if (money < minAmount) {
            throw new InvalidAmountException("Сума для зняття меньша мінімально можливої");
        }

        Bill[] withdrawnBills = new Bill[]{
                new Bill(1, 0),
                new Bill(2, 0),
                new Bill(5, 0),
                new Bill(10, 0),
                new Bill(20, 0),
                new Bill(50, 0),
                new Bill(100, 0),
                new Bill(200, 0),
                new Bill(500, 0),
        };

        int remainingAmount = money;

        for (int i = bills.length - 1; i >= 0; i--) {
            int denomination = bills[i].getNominal();
            int billsAvailable = bills[i].getCount(); // Кількість банкнот конкретного номіналу є в банкоматі

            if (remainingAmount >= denomination && billsAvailable > 0) {
                int requiredBills = remainingAmount / denomination; // Кількість банкнот потрібно для виконання запросу
                int billsToWithdraw = Math.min(requiredBills, billsAvailable);

                if (billsToWithdraw > maxNotes) {
                    billsToWithdraw = maxNotes;
                }

                withdrawnBills[i].setCount(billsToWithdraw); // Добавляємо банкноти в масив для знятя коштів
                bills[i].setCount(bills[i].getCount() - billsToWithdraw); // Знімаємо з банкомата конкретні банкноти
                remainingAmount -= billsToWithdraw * denomination;

                if (remainingAmount == 0) {
                    break;
                }
            }
        }

        if (remainingAmount > 0) {
            throw new InsufficientFundsException("Недостатньо коштів в банкоматі для зняття вказаної суми.");
        }

        return withdrawnBills;
    }

    public int getTotalCash() {
        int total = 0;
        for (int i = 0; i < bills.length; i++){
            total += bills[i].getCount() * bills[i].getNominal();
        }
        return total;
    }

    public Bill[] getBills() {
        return bills;
    }

    public void setBills(Bill[] bills) {
        this.bills = bills;
    }
}
