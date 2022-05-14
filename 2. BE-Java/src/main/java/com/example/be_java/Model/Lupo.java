package com.example.be_java.Model;

public class Lupo extends Cattivi {
    private static int countLupo;

    public Lupo() {
    }

    public Lupo(String nome, boolean isAlive, boolean isProtected) {
        super(nome,"Lupo", isAlive, isProtected);
        setCountCattivi(+1);
        countLupo++;
    }

    public static int getCountLupo() {
        return countLupo;
    }

}
