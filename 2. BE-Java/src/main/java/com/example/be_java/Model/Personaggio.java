package com.example.be_java.Model;

public class Personaggio {
    private String nome;
    private boolean isAlive;
    private boolean isProtected;

    public Personaggio(String nome, boolean isAlive, boolean isProtected) {
        this.nome = nome;
        this.isAlive = isAlive;
        this.isProtected = isProtected;
    }

    public Personaggio() {

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
