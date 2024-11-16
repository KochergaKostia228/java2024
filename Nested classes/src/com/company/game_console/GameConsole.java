package com.company.game_console;

import com.company.game.Game;

public class GameConsole implements Powered{
    private Brand brand;
    private String model;
    private String serial;
    private Gamepad firstGamepad;
    private Gamepad secondGamepad;
    private Game activeGame;
    private boolean isOn;
    private int waitingCounter = 0;

    public class Gamepad implements Powered{
        private Brand brand;
        private String consoleSerial;
        private int connectedNumber;
        private Color color;
        private double chargeLevel;
        private boolean isOn;

        public Gamepad(Brand brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = GameConsole.this.serial;
        }

        @Override
        public void powerOn() {
            if (!isOn) {
                System.out.println("Gamepad " + connectedNumber + " is now ON.");
                isOn = true;

                if (connectedNumber == 1) {
                    powerOn();
                }
            }
        }

        @Override
        public void powerOff() {
            if (isOn) {
                System.out.println("Gamepad " + connectedNumber + " is now OFF.");
                isOn = false;
            }
        }

        public Brand getBrand() {
            return brand;
        }

        public void setBrand(Brand brand) {
            this.brand = brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public void setConsoleSerial(String consoleSerial) {
            this.consoleSerial = consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public void setConnectedNumber(int connectedNumber) {
            this.connectedNumber = connectedNumber;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public double getChargeLevel() {
            return chargeLevel;
        }

        public void setChargeLevel(double chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean on) {
            isOn = on;
        }
    }

    public GameConsole(Brand brand, String serial) {
        this.brand = brand;
        this.serial = serial;

        this.firstGamepad = new Gamepad(this.brand, 1);
        this.secondGamepad = new Gamepad(this.brand, 2);
        this.isOn = false;
    }

    @Override
    public void powerOn() {
        if (!isOn) {
            System.out.println("Game Console is now ON.");
            isOn = true;

            firstGamepad.powerOn();
        }
    }

    @Override
    public void powerOff() {
        if (isOn) {
            System.out.println("Game Console is now OFF.");
            isOn = false;
            firstGamepad.powerOff();
            secondGamepad.powerOff();
        }
    }

    public void replacementGamepad(){
        if(firstGamepad.isOn == false){
            secondGamepad.connectedNumber = 1;
        }
    }

    public void loadGame(Game game){
        activeGame = game;
        System.out.println("Игра \"" + game.getNAME() + "\" загружается.");
    }

    public void playGame() throws ConsoleShutdownException {
        checkStatus();

        if (activeGame != null) {
            System.out.println("Играем в \"" + activeGame.getNAME() + "\".");

            if (firstGamepad.isOn()) {
                if (firstGamepad.getChargeLevel() == 0) {
                    firstGamepad.powerOff();
                }
                else{
                    firstGamepad.chargeLevel -= 10;
                }
            }


            if (secondGamepad.isOn()) {
                if (secondGamepad.getChargeLevel() == 0) {
                    secondGamepad.powerOff();
                }
                else{
                    secondGamepad.chargeLevel -= 10;
                }
            }
        }
    }

    private void checkStatus() throws ConsoleShutdownException{
        if (!firstGamepad.isOn() && !secondGamepad.isOn()) {
            waitingCounter++;
            System.out.println("Подключите джойстик. Ожидаем: " + waitingCounter);
            if (waitingCounter > 5) {
                throw new ConsoleShutdownException("Приставка завершает работу из-за отсутствия активности.");
            }
        } else {
            waitingCounter = 0;
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    public void setFirstGamepad(Gamepad firstGamepad) {
        this.firstGamepad = firstGamepad;
    }

    public Gamepad getSecondGamepad() {
        return secondGamepad;
    }

    public void setSecondGamepad(Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
