package com.example.be_java.Model;

public class Lupo extends Cattivi {
    private static int countLupo;

    public Lupo() {
    }

    public Lupo(String nome, boolean isAlive, boolean isProtected) {
        super(nome, isAlive, isProtected);
        setCountCattivi(+1);
        countLupo++;
    }

    public static int getCountLupo() {
        return countLupo;
    }

    public static void setCountLupo(int countLupo) {
        Lupo.countLupo = countLupo;
    }

    public static void uccide(Personaggio divorato){
        if(divorato.isProtected()==false) {
            divorato.setAlive(false);
        }
    }
}
