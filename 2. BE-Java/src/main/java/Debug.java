import com.example.be_java.Model.*;

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
        Contadini contadino1 = new Contadini();
        Contadini contadino2 = new Contadini();
        Contadini contadino3 = new Contadini();
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

    }
}
