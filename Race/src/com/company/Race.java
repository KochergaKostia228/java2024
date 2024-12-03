package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Race {
    public static AtomicLong startRaceTime = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        List<RaceCarRunnable> cars = new ArrayList<>();

        cars.add(new RaceCarRunnable("Car1", 200, 500, latch));
        cars.add(new RaceCarRunnable("Car2", 180, 500, latch));
        cars.add(new RaceCarRunnable("Car3", 220, 500, latch));
        cars.add(new RaceCarRunnable("Car4", 150, 500, latch));
        cars.add(new RaceCarRunnable("Car5", 300, 500, latch));

        ArrayList<Thread> threads = new ArrayList<>();

        for (RaceCarRunnable car : cars) {
            Thread thread = new Thread(car);
            threads.add(thread);
        }

        startRace(threads);

        latch.await();

        printResults(cars);
    }

    static void startRace(List<Thread> cars){
        Thread countdownThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "...");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("GO!!!");

                startRaceTime.set(System.currentTimeMillis());

                for (Thread carThread : cars) {
                    carThread.start();
                }
            }
        });

        countdownThread.start();
    }

    public static void printResults(List<RaceCarRunnable> cars) {
        RaceCarRunnable winner = null;
        long minTime = Long.MAX_VALUE;

        System.out.println("\nRace results:");

        for (RaceCarRunnable car : cars) {
            System.out.println(car.getName() + " FINISHED! Time: " + convertToTime(car.getFinishTime()));
            if (car.getFinishTime() < minTime) {
                minTime = car.getFinishTime();
                winner = car;
            }
        }

        // Выводим победителя
        System.out.println("\nWinner: " + winner.getName() + " with time: " +  convertToTime(winner.getFinishTime()));
    }

    public static String convertToTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        return sdf.format(new Date(time));
    }
}
