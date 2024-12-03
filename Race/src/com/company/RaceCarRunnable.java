package com.company;

import java.util.concurrent.CountDownLatch;

public class RaceCarRunnable extends Car{
    private int passed;
    private int distance;
    private boolean isFinish;
    private CountDownLatch latch;  // Счетчик для синхронизации
    private long finishTime;

    public RaceCarRunnable(String name, int maxSpeed, int distance, CountDownLatch latch) {
        super(maxSpeed, name);
        this.distance = distance;
        this.passed = 0;
        this.isFinish = false;
        this.latch = latch;
        this.finishTime = -1;
    }

    public int getRandomSpeed(){
        int minSpeed = getMaxSpeed() / 2;
        int maxSpeed = getMaxSpeed();
        return (int) (Math.random() * (maxSpeed - minSpeed) + minSpeed);
    }

    @Override
    public void run(){
        while (!this.isFinish){
            int speed = getRandomSpeed();
            passed += speed;

            if (passed >= distance) {
                isFinish = true;
                passed = distance;

                finishTime = System.currentTimeMillis() - Race.startRaceTime.get();
                latch.countDown();
            }

            System.out.println(this.getName() + "=> speed: " + getRandomSpeed() + "; progress: " + this.passed + "/" + this.distance);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getFinishTime() {
        return finishTime;
    }
}
