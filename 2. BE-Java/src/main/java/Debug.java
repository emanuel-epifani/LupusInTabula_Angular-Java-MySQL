import com.example.be_java.Model.Contadini;
import com.example.be_java.Model.Personaggio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Debug {

    public static void main(String[] args) {

    String nometizio="pippo";


        //array di personaggi vuoto
        ArrayList<Personaggio> personaggi = new ArrayList<>();

        //array di nomi isctanziamo e inseriamo
        ArrayList<String> nomiPersonaggi = new ArrayList<>();
        nomiPersonaggi.add("Sergio");
        nomiPersonaggi.add("Gianluca");
        nomiPersonaggi.add("Luca");
        nomiPersonaggi.add("Raffaele");
        nomiPersonaggi.add("Edoardo");
        nomiPersonaggi.add("Emanuel");
        nomiPersonaggi.add("Pietro");
        nomiPersonaggi.add(nometizio);


        //mischiamo l'array dei nomi
        Collections.shuffle(nomiPersonaggi);
        System.out.println( nomiPersonaggi.toString());

       //istanziare gli 8 personaggi e inseire il nome a tutti i personaggi
        Contadini contadino = new Contadini(nomiPersonaggi.get(1),true, false);
        Contadini contadino2 = new Contadini(nomiPersonaggi.get(2),true, false);

        personaggi.add(contadino);
        personaggi.add(contadino2);
        //riempire l'array personggi






    }
}
