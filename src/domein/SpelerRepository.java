package domein;

import exceptions.NaamInGebruikException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistentie.Connectie;
import persistentie.SpelerMapper;
import domein.Speler;
import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

    private SpelerMapper sm;
    private List<Speler> spelerslijst;

    public SpelerRepository() {

        sm = new SpelerMapper();
        spelerslijst = new ArrayList<>();
    }

    public void voegSpelerToe(Speler nieuweSpeler) {

        /* if (bestaatSpeler(speler.getNaam())) {
            throw new NaamInGebruikException();

        } else {
            sm.voegToe(speler);
        }*/
        sm.voegToe(nieuweSpeler);

    }

    private boolean bestaatSpeler(String naam) {

        return sm.geefSpeler(naam) != null;

    }

    public Speler geefSpeler(String naam) {
        Speler speler = sm.geefSpeler(naam);

        return null;
    }

    public String geefSpelersLijst() {

        String overzicht ="";
        int teller = 1;
        
        for(Speler overloper : spelerslijst){
            overzicht += String.format("%d) %s%n",teller,overloper.getNaam());
            teller++;
        }
        
        return overzicht;

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
