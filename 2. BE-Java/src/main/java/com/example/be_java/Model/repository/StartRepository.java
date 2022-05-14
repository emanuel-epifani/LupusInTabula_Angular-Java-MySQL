package com.example.be_java.Model.repository;

import com.example.be_java.Model.*;
import com.example.be_java.Model.Constants.DBconnection;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import static com.example.be_java.Model.Constants.DBconnection.*;


public class StartRepository {

    /**
     -	Prendo in input il nome da attribuire al personaggio.
     -	Istanzio una nuova partita (e gli assegno un nuovo id).
     -	connToDb e scrivo nella tabella “partite” del db l’id della partita e imposto “finito” a false.
     -	Creo un array di Personaggi vuoto.
     -	Istanzio 8 personaggi e li aggiungo all’array
     -	Creo un arraylisti di nomiPersonaggi e ci aggiungo 8 nomi (7 mockati nel codice e l’8 quello preso in input dall’utente)
     -	Mischio l’array di nomi e assegno ad ogni personaggio creato un nome dall’array nomiPersonaggi.
     -	connToDb e vado a riempire la tabella del db “personaggi” con i personaggi istanziati, i nomi assegnati, e setto tutti a vivi.
     -	Ritorno l’oggetto partita con (idPartita, finito, personaggioUtente)
     * @param nometizio
     * @return Partita (idPartita, finito, personaggioUtente)
     */
    public static OutputStart start(String nometizio) {



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
            if (nomiPersonaggi.get(i).equalsIgnoreCase( nometizio)) {
                personaggioUtente = personaggi.get(i).getClass().getSimpleName();
            }
        }


        PreparedStatement pstmt =null;
        try {

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

           for (int i = 0; i < personaggi.size(); i++) {
                String QUERY = "INSERT INTO personaggi ( nome, ruolo, isalive) VALUES (?,?,?)";
                pstmt = conn.prepareStatement(QUERY);

                pstmt.setString(1, personaggi.get(0).getNome());//nome personaggio
                pstmt.setString(2, personaggi.get(0).getClass().getSimpleName());//ruolo personaggio
                pstmt.setBoolean(3, true);//isAlive

                pstmt.executeUpdate(QUERY);

            }
            pstmt.close(); //chiudo lo statement
            conn.close(); //chiudo la connessione
        } catch (SQLException e) {

            //debug
            System.out.println("dentro il catch");

            e.printStackTrace();
        }

        OutputStart output =new OutputStart(personaggioUtente,personaggi);

        return output;
        //cioè mi ritornerà (idPartita, finito, ruoloUtente)
    }
}
