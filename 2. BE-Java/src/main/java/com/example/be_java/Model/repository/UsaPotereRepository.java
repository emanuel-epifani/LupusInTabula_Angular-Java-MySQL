package com.example.be_java.Model.repository;

import com.example.be_java.Model.EsitoNotte;
import com.example.be_java.Model.Personaggio;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import static com.example.be_java.Model.Constants.DBconnection.*;

public class UsaPotereRepository {

    //creo un metodo per ottenere il nostro array di personaggi da richiamare nelgi altri metodi
    public static ArrayList<Personaggio> getPersonaggiVivi(int id_partita){
        ArrayList<Personaggio> personaggi = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String QUERY = "Select * from personaggi where isAlive==true and id_partita==?";
            PreparedStatement pstmt = conn.prepareStatement(QUERY);
            pstmt.setInt(1, id_partita);
            ResultSet rs =pstmt.executeQuery(QUERY);


            while (rs.next()) { // .next() fa avanzare alle righe successive, quando righe finite ritorna false
                Personaggio giocatore=new Personaggio(rs.getString("nome"),
                        rs.getString("ruolo"),
                        rs.getBoolean("isAlive"),
                        false,
                        rs.getInt("id_partita"));
                personaggi.add(giocatore);

            }

            pstmt.close(); //chiudo lo statement
            conn.close(); //chiudo la connessione
        } catch (SQLException e) {
            e.getSQLState();
        }
        return personaggi;
    }


    //----------------------------------------------------nuovo metodo----------------------------------------

    //creo un metodo per usare i poteri , gli passo il ruolo del giocatore umano e il nome di chi lui ha scelto per usare il suo potere
    public static EsitoNotte usapotere(int id_partita, String ruolo, String nome){

        //richiamo il metodo personaggi per poter integrare il metodo di usapotere che avevamo scritto in debug2
        ArrayList<Personaggio> personaggi=  getPersonaggiVivi(id_partita);
        //creo una variabile da utilizzare nel caso del veggente

        //istanzio l'oggetto esitoNotte vuoto (contenente morto="" e indagato="", per restituirlo a fine metodo una volta riempito
        EsitoNotte esitoNotte = new EsitoNotte();

        switch (ruolo){

            case "Guardia_del_corpo":
                //a quello scelto setto protected a true
                for (int i = 0; i < personaggi.size() ; i++) {
                    if (personaggi.get(i).getNome().equalsIgnoreCase(nome) ){
                        personaggi.get(i).setProtected(true);
                    }
                }
                //faccio uccidere randomicamente 1 personaggio
                Collections.shuffle(personaggi);
                if (personaggi.get(0).isAlive() && personaggi.get(0).isProtected()==false){
                    personaggi.get(0).setAlive(false);
                }
                break;
            case"Lupo":
                //faccio fare randomicamente la protezione alla guardia del corpo
                Collections.shuffle(personaggi);
                personaggi.get(0).setProtected(true);
                //faccio agire il lupo
                for (int i = 0; i < personaggi.size() ; i++) {
                    if (personaggi.get(i).getNome().equalsIgnoreCase(nome) && personaggi.get(i).isProtected()==false ){
                        personaggi.get(i).setAlive(false);
                    }
                }
                break;
            case "Veggente":
                //faccio fare randomicamente la protezione alla guardia del corpo
                Collections.shuffle(personaggi);
                    personaggi.get(0).setProtected(true);
                //faccio uccidere randomicamente
                Collections.shuffle(personaggi);
                if ( personaggi.get(0).isProtected()==false){
                    personaggi.get(0).setAlive(false);
                }
                //faccio agire il veggente
                for (int i = 0; i < personaggi.size() ; i++) {
                    if (personaggi.get(i).getNome().equalsIgnoreCase(nome) ){
                        if(personaggi.get(i).getRuolo().equalsIgnoreCase("Lupo"))
                           esitoNotte.setIndagato(nome);
                    }
                }
                break;
        }

        String morto="";
        for (int i = 0; i < personaggi.size() ; i++) {
            if(personaggi.get(i).isAlive()==false){
                morto= personaggi.get(i).getNome();
            }
        }

        //segno il morto nel database se c'è
        if(!morto.equalsIgnoreCase("")) {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = null;
                for (int i = 0; i < personaggi.size(); i++) {
                    String QUERY = "UPDATE personaggi isAlive=false where nome==? and id_partita==?";
                    pstmt = conn.prepareStatement(QUERY);
                    pstmt.setString(1, morto);//nome personaggio
                    pstmt.setInt(2, id_partita);
                    pstmt.executeUpdate();
                }
                pstmt.close(); //chiudo lo statement
                conn.close(); //chiudo la connessione
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        //l'indagato servirà al FE  (se l'utente è il veggnete) per ricordarsi chi votare/non votare al GIORNO successivo
        // l'(eventuale) morto, servirà al FE per far sapere all'utente il punto della situazione ad inizio GIORNO
        return esitoNotte;
    }
}
