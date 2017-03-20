package domein;

import resources.Taal;
import ui.PazaakApplicatie;

public class DomeinController {

    private SpelerRepository spelerrepo;
    private Taal taal;

    public DomeinController() {
        spelerrepo = new SpelerRepository();
    }

    public void voegSpelerToe(String naam, int geboortejaar) throws IllegalArgumentException {

        spelerrepo.voegSpelerToe(naam, geboortejaar); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)

    }

}
