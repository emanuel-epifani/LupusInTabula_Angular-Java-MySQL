package com.example.be_java.Model;

import com.example.be_java.Model.Buoni;

public class Guardia_del_corpo extends Buoni {

    public Guardia_del_corpo() {
    }

    public Guardia_del_corpo(String nome, boolean isAlive, boolean isProtected) {
        super(nome, isAlive, isProtected);
    }

    public static void proteggi(Personaggio daProteggere){

        daProteggere.setProtected(true);
    }
}
