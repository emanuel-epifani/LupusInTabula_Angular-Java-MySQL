package com.example.be_java.Model;

public class Partita {
    private static int id;
    private boolean finito;
    private String personaggioUtente;

    public Partita() {
        id++;
        finito = false;
        personaggioUtente ="";
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Partita.id = id;
    }

    public boolean isFinito() {
        return finito;
    }

    public void setFinito(boolean finito) {
        this.finito = finito;
    }

    public String getPersonaggioUtente() {
        return personaggioUtente;
    }

    public void setPersonaggioUtente(String personaggioUtente) {
        this.personaggioUtente = personaggioUtente;
    }
}
