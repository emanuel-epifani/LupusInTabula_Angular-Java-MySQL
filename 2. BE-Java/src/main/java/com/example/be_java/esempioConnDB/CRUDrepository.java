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

    /* CRUD operations */

    // CREATE
    public static void createInfoDB() {

    }

    // READ

    public static void getInfoDB() {

        try {
            // 1. apro una connessione col db--> DriverManager.getConnection()
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 2. definisco la QUERY, con preparedStatement, quindi senza concatenazione
            // stringhe, ma con segnaposto ? al posto delle variabili
            String QUERY = "SELECT nome FROM Studenti WHERE age = ? AND  scuola = ?";

            // 3. creo un oggetto di tipo prepareStatement in cui inserisco la mia QUERY, e
            // definisco i valori da inserire al posto dei ?
            PreparedStatement pstmt = conn.prepareStatement(QUERY);
            pstmt.setInt(1, 27);
            pstmt.setString(2, "Engim");

            // 4. eseguo la QUERY e immagazzino il valore nell'oggetto di tipo ResultSet
            // se query di R (SELECT) - pstmt.executeQuery();
            // se query CUD (CREATE,UPDATE;DELETE) - pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery(QUERY);

            // 5. Estraggo i dati immagazzinati nel ResultSet e ci faccio qcosa mi serve
            while (rs.next()) { // .next() fa avanzare alle righe successive, quando righe finite ritorna false

                // faccio cose con i dati ottenuto (si accede agi attributi con il metodo
                // "getTIPO()" ) getInt, getString, getBoolean ecc
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));

                pstmt.close(); // chiudo lo statement
                conn.close(); // chiudo la connessione
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateInfoDB() {

    }

    // DELETE
    public static void deleteInfoDB() {

    }

}
