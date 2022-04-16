package com.example.be_java.Controller;

import com.example.be_java.Model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
public class Controller {


    @PostMapping("/StartPartita")
    public String start(@RequestParam (value = "nome") String nometizio) {
        //Creo un array di personaggi vuoto...
        ArrayList<Personaggio> personaggi = new ArrayList<>();

        //... istanzio tutti i personaggi (con nome vuoto)
        Contadino contadino1 = new Contadino();
        Contadino contadino2 = new Contadino();
        Contadino contadino3 = new Contadino();
        Veggente veggente = new Veggente();
        Guardia_del_corpo guardia_del_corpo = new Guardia_del_corpo();
        Giudice giudice = new Giudice();
        Lupo lupo = new Lupo();
        Indemoniato indemoniato = new Indemoniato();

        //...e li aggiungo all'array
        personaggi.add(contadino1);
        personaggi.add(contadino2);
        personaggi.add(contadino3);
        personaggi.add(veggente);
        personaggi.add(guardia_del_corpo);
        personaggi.add(giudice);
        personaggi.add(lupo);
        personaggi.add(indemoniato);


        //Creo un array di nomi di personaggi vuoto, lo riempo con 7nomi a mia scelta + 1preso dall'utente
        ArrayList<String> nomiPersonaggi = new ArrayList<>();
        nomiPersonaggi.add("Sergio");
        nomiPersonaggi.add("Gianluca");
        nomiPersonaggi.add("Luca");
        nomiPersonaggi.add("Raffaele");
        nomiPersonaggi.add("Edoardo");
        nomiPersonaggi.add("Emanuel");
        nomiPersonaggi.add("Pietro");
        nomiPersonaggi.add(nometizio);

        //mischiamo l'array per garantirmi che ogni nuova volta allo stesso personaggio assegnerò un nome diverso
        Collections.shuffle(nomiPersonaggi);
        //System.out.println(nomiPersonaggi.toString());x debug

        //assegno ad ogni personaggio creato (con costruttore vuoto), un nome dall'array mescolato e setto gli altri 2 parametri finora vuoti
        for (int i = 0; i < personaggi.size(); i++) {
            personaggi.get(i).setNome(nomiPersonaggi.get(i));
            personaggi.get(i).setAlive(true);
            personaggi.get(i).setProtected(false);
            //System.out.println(personaggi.get(i).getNome());

            //all'iterazione in cui assegno il nome inserito dall'utente, ritorno che tipo di personaggio sarà capitato all'utente
            if (nomiPersonaggi.get(i) == nometizio) {
                return personaggi.get(i).getClass().getSimpleName();
            }
        }

    return "ok ";
    }

}
