package com.example.be_java.Model;

public class Cattivi extends Personaggio{
    private static int countCattivi;

    public Cattivi() {
    }

    public Cattivi(String nome, boolean isAlive, boolean isProtected) {
        super(nome, isAlive, isProtected);
        countCattivi++;
    }

    public static int getCountCattivi() {
        return countCattivi;
    }

    public static void setCountCattivi(int countCattivi) {
        Cattivi.countCattivi = countCattivi;
    }


}
