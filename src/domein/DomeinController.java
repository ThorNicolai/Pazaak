package domein;

import resources.Taal;
import ui.PazaakApplicatie;

public class DomeinController {

    private SpelerRepository spelerrepo;
    private Taal taal;

    public DomeinController() {
        spelerrepo = new SpelerRepository();
    }

    public void voegSpelerToe(String naam, int geboortejaar, int krediet){
        
        Speler nieuweSpeler = new Speler(naam,geboortejaar,krediet);
        spelerrepo.voegSpelerToe(nieuweSpeler); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)
        
    }

}
