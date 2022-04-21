package com.example.be_java.Model;

public class Partita {
    private static int id;

    public Partita() {
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Partita.id = id;
    }
}
