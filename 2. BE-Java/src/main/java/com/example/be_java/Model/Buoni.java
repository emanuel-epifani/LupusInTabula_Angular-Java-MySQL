package com.example.be_java.Model;

public class Buoni extends Personaggio {
    private static int countBuoni;

    public Buoni() {
        countBuoni++;
    }

    public Buoni(String nome, String ruolo, boolean isAlive, boolean isProtected) {
        super(nome, ruolo, isAlive, isProtected, countBuoni);
        countBuoni++;
    }




    public static int getCountBuoni() {
        return countBuoni;
    }

    public static void setCountBuoni(int countBuoni) {
        Buoni.countBuoni = countBuoni;
    }
}
