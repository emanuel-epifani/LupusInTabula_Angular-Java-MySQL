package com.example.be_java.Model;

public class Lupo extends Cattivi{
    private static int countCattivi;

    public Lupo() {
    }

    public Lupo(String nome, boolean isAlive, boolean isProtected) {
        super(nome, isAlive, isProtected);
    }

    public static int getCountCattivi() {
        return countCattivi;
    }

    public static void setCountCattivi(int countCattivi) {
        Lupo.countCattivi = countCattivi;
    }

    public void uccide(){

    }
}
