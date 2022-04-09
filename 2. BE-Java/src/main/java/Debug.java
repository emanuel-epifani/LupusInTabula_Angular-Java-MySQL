import com.example.be_java.Model.Contadini;
import com.example.be_java.Model.Personaggio;

import java.util.ArrayList;

public class Debug {

    public static void main(String[] args) {




        //array di personaggi
        ArrayList<Personaggio> personaggi = new ArrayList<>();



        //array di nomi
        ArrayList<String> nomiPersonaggi = new ArrayList<>();
        nomiPersonaggi.add("Sergio");
        nomiPersonaggi.add("Gianluca");
        nomiPersonaggi.add("Luca");
        nomiPersonaggi.add("Raffaele");
        nomiPersonaggi.add("Edoardo");
        nomiPersonaggi.add("Emanuel");
        nomiPersonaggi.add("Pietro");
        nomiPersonaggi.add("x");


        //nomiPersonaggi [1,2,3,4,5,6,7]
        //personaggi [1,2,3,4,5,6,7,8]




        Contadini contadino = new Contadini("Erik",true, false);
        personaggi.add(contadino);








    }
}
