package com.example.be_java.esempioConnDB;
//  https://www.tutorialspoint.com/jdbc/index.htm
/*
Passaggi necessari per creazione di un app jdbc:

1. Importa i pacchetti:
    Richiede d'includere i pacchetti contenenti le classi JDBC necessarie per la programmazione del database.
    Molto spesso, sarà sufficiente utilizzare import java.sql.* .

2. Aprire una connessione:
    Richiede l'utilizzo del metodo DriverManager.getConnection() per creare un oggetto Connection,
    CHe rappresenta una connessione fisica con il database.

3. Eseguire una query
    Richiede l'utilizzo di un oggetto di tipo Statement per creare e inviare un'istruzione SQL al database.

4. Estrai dati dal set di risultati:
    richiede l'utilizzo del metodo ResultSet.getXXX() appropriato per recuperare i dati dal set di risultati.

5. Pulisci l'ambiente:
    Richiede la chiusura esplicita di tutte le risorse del database anziché
    fare affidamento sulla raccolta dei rifiuti della JVM.

*/
import java.sql.*;

public class CRUDrepository {

        static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
        static final String USER = "guest";
        static final String PASS = "guest123";

        /*      CRUD operations      */

        //CREATE
        public static void createInfoDB() {
    

        }

        //READ
        public static void getInfoDB() {
            
            try{
                //apro una connessione --> DriverManager.getConnection()
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //definisco la QUERY
                String QUERY = "SELECt nome FROM Studenti WHERE age = ? AND  scuola = ?";

                //creo un oggetto di tipo statement in cui immagazzinare la mia QUERY
                PreparedStatement pstmt = conn.prepareStatement(QUERY);
                int age;
                pstmt.setInt(27, age);
                String scuola;
                pstmt.setString("Engim", scuola);

                //eseguo la QUERY
                ResultSet rs = pstmt.executeQuery(QUERY);
                
                // Extract data from result set
                while (rs.next()) {

                    System.out.println(rs);//x debug -->x veder cos ho estratto
                    // faccio cose con i dati ottenuto
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", Age: " + rs.getInt("age"));
                    System.out.print(", First: " + rs.getString("first"));
                    System.out.println(", Last: " + rs.getString("last"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }

        //UPDATE
        public static void updateInfoDB() {
            
        }

        //DELETE
        public static void deleteInfoDB() {
            
        }


}
