package com.example.be_java.Model;

public class EsitoNotte {
    private String morto="";
    private  String indagato="";

    public EsitoNotte() {
    }

    public EsitoNotte(String morto, String indagato) {
        this.morto = morto;
        this.indagato = indagato;
    }

    public String getMorto() {
        return morto;
    }

    public void setMorto(String morto) {
        this.morto = morto;
    }

    public String getIndagato() {
        return indagato;
    }

    public void setIndagato(String indagato) {
        this.indagato = indagato;
    }
}
