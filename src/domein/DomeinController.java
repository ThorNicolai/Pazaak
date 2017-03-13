package domein;

import java.util.ResourceBundle;
import resources.Taal;

public class DomeinController {

    private SpelerRepository spelerrepo;
    private Taal taal;

    public DomeinController() {
        spelerrepo = new SpelerRepository();
    }

    public void voegSpelerToe(String naam, int geboortejaar) {

        spelerrepo.voegSpelerToe(naam, geboortejaar); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)

    }

    public void kiesTaal(int keuze) {
        taal = new Taal(keuze);
    }

    
 
}
