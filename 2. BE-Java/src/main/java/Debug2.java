import com.example.be_java.Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Debug2 {
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
        String ruoloMioPersonaggio="";
        //assegno ad ogni personaggio creato (con costruttore vuoto), un nome dall'array mescolato e setto gli altri 2 parametri finora vuoti
        for (int i = 0; i < personaggi.size() ; i++) {
            personaggi.get(i).setNome( nomiPersonaggi.get(i) ) ;
            personaggi.get(i).setAlive(true);
            personaggi.get(i).setProtected(false);
            //System.out.println(personaggi.get(i).getNome());

            //all'iterazione in cui assegno il nome inserito dall'utente, ritorno che tipo di personaggio sarà capitato all'utente
            if (nomiPersonaggi.get(i) == nometizio){
                System.out.println("Il personaggio a te assegnato è: "+  personaggi.get(i).getClass().getSimpleName());
                ruoloMioPersonaggio= personaggi.get(i).getClass().getSimpleName();
            }
        }


        //inizia la notte
        System.out.println("-------------------------------------è notte !!--------------------------------------");

        switch (ruoloMioPersonaggio){

            case "Guardia_del_corpo":
                    System.out.println("Scegli chi proteggere");

                    String a= tastiera.nextLine();
                    for (int i = 0; i < personaggi.size() ; i++) {
                        if (personaggi.get(i).getNome().equalsIgnoreCase(a) && personaggi.get(i).isAlive()){
                            System.out.println("Il personaggio  "+  personaggi.get(i).getNome() +" è protetto");
                            personaggi.get(i).setProtected(true);
                        }
                    }
                    //faccio uccidere randomicamente
                    Collections.shuffle(personaggi); //nel vero codice tanto ci sarà una select dal DB
                    if (personaggi.get(0).isAlive() && personaggi.get(0).isProtected()==false){
                        System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" è Morto");
                        personaggi.get(0).setAlive(false);
                    }
                    //random Veggente
                    Collections.shuffle(personaggi); //nel vero codice tanto ci sarà una select dal DB
                    if ( personaggi.get(0).isAlive()){
                        if(personaggi.get(0).getClass().getSimpleName().equalsIgnoreCase("Lupo"))
                            System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" è Il lupo");
                        else {
                            System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" NON è Il lupo");
                        }
                    }

                    break;
            case"Lupo":

                    //faccio fare randomicamente la protezione alla guardia del corpo
                    Collections.shuffle(personaggi); //nel vero codice tanto ci sarà una select dal DB

                    if (personaggi.get(0).isAlive()){
                        System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" è protetto");
                        personaggi.get(0).setProtected(true);
                    }


                    //faccio agire il lupo
                    System.out.println("Scegli chi uccidere");

                    String b= tastiera.nextLine();
                    for (int i = 0; i < personaggi.size() ; i++) {

                        if (personaggi.get(i).getNome().equalsIgnoreCase(b) && personaggi.get(i).isAlive()==true){
                            System.out.println("Il personaggio  "+  personaggi.get(i).getNome() +" è stato scelto");
                            if (personaggi.get(i).isProtected()){
                                System.out.println("Il personaggio  "+  personaggi.get(i).getNome() +" non può essere ucciso");

                            }
                            else{
                                personaggi.get(i).setAlive(false);
                                System.out.println("Il personaggio  "+  personaggi.get(i).getNome() +" è stato ucciso");

                            };
                        }

                    }

                    //metodo veggente random
                    Collections.shuffle(personaggi); //nel vero codice tanto ci sarà una select dal DB
                    if ( personaggi.get(0).isAlive()){
                        if(personaggi.get(0).getClass().getSimpleName().equalsIgnoreCase("Lupo"))
                            System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" è Il lupo");
                        else {
                            System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" NON è Il lupo");
                        }
                    }

                    break;

            case "Veggente":
                    //faccio fare randomicamente la protezione alla guardia del corpo
                    Collections.shuffle(personaggi); //nel vero codice tanto ci sarà una select dal DB
                    if (personaggi.get(0).isAlive()){
                        System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" è protetto");
                        personaggi.get(0).setProtected(true);
                    }

                    //faccio uccidere randomicamente
                    Collections.shuffle(personaggi); //nel vero codice tanto ci sarà una select dal DB
                    if (personaggi.get(0).isAlive() && personaggi.get(0).isProtected()==false){
                        System.out.println("Il personaggio  "+  personaggi.get(0).getNome() +" è Morto");
                        personaggi.get(0).setAlive(false);
                    }

                    //faccio agire il veggente
                    System.out.println("Scegli su chi indagare");

                    String c= tastiera.nextLine();
                    for (int i = 0; i < personaggi.size() ; i++) {
                        System.out.println("prova");

                        if (personaggi.get(i).getNome().equalsIgnoreCase(c) ){
                            System.out.println("prova");
                            if(personaggi.get(i).getClass().getSimpleName().equalsIgnoreCase("Lupo"))
                            System.out.println("Il personaggio  "+  personaggi.get(i).getNome() +" è Il lupo");
                            else {
                                System.out.println("Il personaggio  "+  personaggi.get(i).getNome() +" NON è Il lupo");
                            }
                        }
                    }

                    break;

            }
        }



}
