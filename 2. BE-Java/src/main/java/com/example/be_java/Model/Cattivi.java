package com.example.be_java.Model;

public class Cattivi extends Personaggio {
    private static int countCattivi;

    public Cattivi() {
        countCattivi++;
    }

    public Cattivi(String nome, String ruolo, boolean isAlive, boolean isProtected) {
        super(nome, ruolo, isAlive, isProtected);
        countCattivi++;
    }

    public static int getCountCattivi() {
        return countCattivi;
    }

    public static void setCountCattivi(int countCattivi) {
        Cattivi.countCattivi = countCattivi;
    }


}
