package com.example.be_java.Model;

public class Partita {
    private static int id;
    private boolean finto;

    public Partita() {
        id++;
    }

    public static int getId() {
        return id;
    }

}
