package com.example.be_java.Controller;

import com.example.be_java.Model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
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
        String personaggioUtente = "";
        //assegno ad ogni personaggio creato (con costruttore vuoto), un nome dall'array mescolato e setto gli altri 2 parametri finora vuoti
        for (int i = 0; i < personaggi.size(); i++) {
            personaggi.get(i).setNome(nomiPersonaggi.get(i));
            personaggi.get(i).setAlive(true);
            personaggi.get(i).setProtected(false);

            //all'iterazione in cui assegno il nome inserito dall'utente, immagazino il tipo di personaggio capitato all'utente
            if (nomiPersonaggi.get(i) == nometizio) {
                personaggioUtente = personaggi.get(i).getClass().getSimpleName();
            }
        }


        //una volta assegnato ad ogni giocatore un nome e un ruolo, prima di iniziare la partita vera e propria
        //vado a riempire la tabella del db "personaggi" con i personaggi istanziati, i nomi assegnati, e setto tutti a vivi
        final String DB_URL = "jdbc:mysql://localhost:3306/lupus";
        final String USER = "lupus";
        final String PASS = "lupus";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = null;
            for (int i = 0; i < personaggi.size(); i++) {
                String QUERY = "INSERT INTO personaggi (nome, ruolo, isAlive) VALUES (?,?,?)";
                pstmt = conn.prepareStatement(QUERY);
                pstmt.setString(1, personaggi.get(i).getNome());//nome personaggio
                pstmt.setString(2, personaggi.get(i).getClass().getSimpleName());//ruolo personaggio
                pstmt.setBoolean(3, true);//isAlive
                pstmt.executeUpdate();
            }
            pstmt.close(); //chiudo lo statement
            conn.close(); //chiudo la connessione
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return personaggioUtente;
    }



    @PostMapping ("/Guardia")
    public void proteggi(@RequestParam (value = "nome") Personaggio protetto) {
        Guardia_del_corpo.proteggi(protetto);

    }
    @GetMapping("/Lupo")
    public void uccidi(@RequestParam (value = "nome") Personaggio divorato){
        Lupo.uccide(divorato);
    }
}
