import com.example.be_java.Model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Debug {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.println("Benvenuto, scrivi un nome da assegnare al tuo giocatore");
        String nometizio = tastiera.nextLine();

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
        System.out.println( nomiPersonaggi.toString());//x debug

        //assegno ad ogni personaggio creato (con costruttore vuoto), un nome dall'array mescolato e setto gli altri 2 parametri finora vuoti
        for (int i = 0; i < personaggi.size() ; i++) {
            personaggi.get(i).setNome( nomiPersonaggi.get(i) ) ;
            personaggi.get(i).setAlive(true);
            personaggi.get(i).setProtected(false);
            //System.out.println(personaggi.get(i).getNome());

            //all'iterazione in cui assegno il nome inserito dall'utente, ritorno che tipo di personaggio sarà capitato all'utente
            if (nomiPersonaggi.get(i) == nometizio){
                System.out.println("Il personaggio a te assegnato è: "+  personaggi.get(i).getClass().getSimpleName());
            }
        }

        //vado a riempire la tabella del db "personaggi" con i personaggi istanziati, i nomi assegnati, setto tutti vivi
        final String DB_URL = "jdbc:mysql://localhost:3306/lupus";
        final String USER = "lupus";
        final String PASS = "lupus";

        try {
            //1. apro una connessione col db--> DriverManager.getConnection()
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = null;
            for (int i = 0; i < personaggi.size(); i++) {
                String QUERY = "INSERT INTO personaggi (nome, ruolo, isAlive) VALUE (?, ?, ?)";
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


        // -----------------------------------prova megamain-----------------------------------
        boolean finito = false;

        while (!finito) {
            if (Lupo.getCountLupo()>0 && Cattivi.getCountCattivi() < Buoni.getCountBuoni()){

                System.out.println("----------------E' notte---------");

                //la gdc vota chi vuole proteggere casualmente
                    //se la gda è il mio utente, faccio il metodo @PostMapping

                    //se la gda è il pc, faccio questo
                        Collections.shuffle(personaggi);
                        for (Personaggio i : personaggi) {
                            if (i.isAlive() == true) {
                                i.setProtected(true);
                                break;
                            }
                        }




                //i lupi scelgono chi uccidere

                //il veggente sceglie chi indagare (se è un lupo)


                System.out.println("----------------E' giorno---------");
                //printo chi (se) è stato ucciso di notte
                System.out.println("----------------Votiamo---------");
                //tutti votano chi uccidere,
                //ballotaggio se 2 persone = voti, decide il giudice)
                            //si attiva il metodo del giudice
                //muore chi è stato deciso

                //countLupo--/countBuoni--

            } else {
                System.out.println("Il gioco è finito");
                finito = true;
                if(Lupo.getCountLupo()==0){
                    System.out.println("Hanno vinto i buoni");
                }else if (Buoni.getCountBuoni()==Cattivi.getCountCattivi()){
                    System.out.println("Hanno vinto i cattivi");
                }
            }
        }





    }
}
