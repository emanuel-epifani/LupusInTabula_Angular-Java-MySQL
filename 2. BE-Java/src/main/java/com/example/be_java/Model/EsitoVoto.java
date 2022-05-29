package com.example.be_java.Model;

public class EsitoVoto {
    private String piùvotato = "";

    public EsitoVoto() {
    }

    public EsitoVoto(String piùvotato) {
        this.piùvotato = piùvotato;
    }

    public String getPiùvotato() {
        return piùvotato;
    }

    public void setPiùvotato(String piùvotato) {
        this.piùvotato = piùvotato;
    }
}
