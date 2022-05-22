package com.example.be_java.Model;

import java.util.ArrayList;

public class OutputStart {
    private String ruolo;
    private ArrayList<Personaggio> arrayPersonaggi;

    public OutputStart(String ruolo, ArrayList<Personaggio> arrayPersonaggi) {
        this.ruolo = ruolo;
        this.arrayPersonaggi = arrayPersonaggi;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public ArrayList<Personaggio> getArrayPersonaggi() {
        return arrayPersonaggi;
    }

    public void setArrayPersonaggi(ArrayList<Personaggio> arrayPersonaggi) {
        this.arrayPersonaggi = arrayPersonaggi;
    }
}
