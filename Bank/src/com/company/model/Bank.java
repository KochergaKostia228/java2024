package com.company.model;

import java.util.Random;

public class Bank {
    private ATM[] bankomates;

    public Bank(int size) {
        bankomates = new ATM[size];
        Random random = new Random();

        for(int i = 0; i < size; i++){
            bankomates[i] = new ATM(20, 100);
        }
    }

    public void addATM(ATM atm) {
        int count = bankomates.length;
        ATM[] newArr = new ATM[count];

        for (int i = 0; i < count; i++){
            newArr[i] = bankomates[i];
        }

        bankomates = new ATM[count+1];

        for (int i = 0; i < count; i++){
            bankomates[i] = newArr[i];
        }

        bankomates[count] = atm;
    }

    public int allSumMoney(){
        int sum = 0;

        for(int i = 0; i < bankomates.length; i++){
            sum += bankomates[i].getTotalCash();
        }

        return sum;
    }

    public ATM[] getBankomates() {
        return bankomates;
    }
}
