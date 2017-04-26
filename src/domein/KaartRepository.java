package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.KaartMapper;

public class KaartRepository {

    private DomeinController dc;
    private KaartMapper km;

    public KaartRepository(DomeinController dc) {
        this.dc = dc;
    }

    public List<Kaart> geefKaarten() {

        return km.geefKaarten();

    }

}
