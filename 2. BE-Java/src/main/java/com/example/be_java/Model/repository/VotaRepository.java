package com.example.be_java.Model.repository;

import com.example.be_java.Model.Personaggio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static com.example.be_java.Model.Constants.DBconnection.*;
import static com.example.be_java.Model.repository.UsaPotereRepository.getPersonaggiVivi;

public class VotaRepository {
    public static String vota(String bersaglio){
        String piuvotato="";

        ArrayList<Personaggio> personaggi=  getPersonaggiVivi();

        for (int i = 0; i < personaggi.size() ; i++) {
            if (personaggi.get(i).getNome().equalsIgnoreCase(bersaglio) ){
                personaggi.get(i).setVotiRicevuti(personaggi.get(i).getVotiRicevuti()+1);
            }
        }


        for (int i=0;i<personaggi.size()-1;i++) {
            Collections.shuffle(personaggi);
            personaggi.get(0).setVotiRicevuti(personaggi.get(0).getVotiRicevuti() + 1);
        }

        ArrayList<Integer> arrayVoti=new ArrayList<>();

        for (int i=0; i<personaggi.size();i++ ){
            arrayVoti.add( personaggi.get(i).getVotiRicevuti());
        }
    int max = Collections.max(arrayVoti);
        for (int i=0; i<personaggi.size();i++ ){
          if(personaggi.get(i).getVotiRicevuti()== max){
              personaggi.get(i).setAlive(false);
             piuvotato= personaggi.get(i).getNome();
          };

        }
        if(!piuvotato.equalsIgnoreCase("")) {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = null;
                for (int i = 0; i < personaggi.size(); i++) {
                    String QUERY = "UPDATE personaggi isAlive=false where nome==? ";
                    pstmt = conn.prepareStatement(QUERY);
                    pstmt.setString(1, piuvotato);//nome personaggio

                    pstmt.executeUpdate();
                }
                pstmt.close(); //chiudo lo statement
                conn.close(); //chiudo la connessione
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    return piuvotato;
    }


}
