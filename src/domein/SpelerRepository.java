package domein;

import exceptions.NaamInGebruikException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistentie.Connectie;
import persistentie.SpelerMapper;

public class SpelerRepository {

    SpelerMapper sm = new SpelerMapper();

    public SpelerRepository() {

    }

    public void voegSpelerToe(Speler speler) {

        if (bestaatSpeler(speler.getNaam())) {
            throw new NaamInGebruikException();

        }
    }
    

    

    private boolean bestaatSpeler(String naam) {
        
        boolean flag1 = false;
        
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g42.db.webhosting.be WHERE naam==?");
            query.setString(1, naam);
            
            flag1 = true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        
        return flag1;
    }

    public Speler geefSpeler(String naam) {
        Speler speler = sm.geefSpeler(naam);

        return speler;
    }
}

/* uit dobbelspel!!
public void voegToe(Speler speler) {
       if (bestaatSpeler(speler.getNaam()))
            throw new NaamInGebruikException();
       
       mapper.voegToe(speler);
    }

    private boolean bestaatSpeler(String naam){
        return mapper.geefSpeler(naam)!=null;
    }
    
    public Speler geefSpeler(String naam, ***){
        Speler s = mapper.geefSpeler(naam);
        
        
        return null;
    }
 */
