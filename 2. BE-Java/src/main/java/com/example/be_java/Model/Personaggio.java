package com.example.be_java.Model;

public class Personaggio {
    private String nome;
    private String ruolo;
    private boolean isAlive;
    private boolean isProtected;
    private int id_partita;
    private int votiRicevuti;

    public Personaggio(String nome, String ruolo, boolean isAlive, boolean isProtected, int id_partita) {
        this.id_partita=id_partita;
        this.ruolo=ruolo;
        this.nome = nome;
        this.isAlive = isAlive;
        this.isProtected = isProtected;
    }

    public Personaggio() {

    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public int getVotiRicevuti() {
        return votiRicevuti;
    }

    public void setVotiRicevuti(int votiRicevuti) {
        this.votiRicevuti = votiRicevuti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public void vota(){

    }
}
