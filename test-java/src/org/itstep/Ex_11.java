package org.itstep;

public class Ex_11 {
    public static void method(int length, boolean isHorizontal, char symbol){
        if(isHorizontal){
            for (int i = 0; i < length; i++){
                System.out.print(symbol);
            }
        }
        else {
            for (int i = 0; i < length; i++){
                System.out.println(symbol);
            }
        }
    }

    public static void main(String[] args) {
        method(5, false, 'a');
    }
}
