package domein;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import persistentie.KaartMapper;

public class Speler {

    List<Speler> deSpelers = new ArrayList<>();

    private String naam;
    private int geboortejaar, krediet;
    private Kaart[] wedstrijdStapel;

    int year = Calendar.getInstance().get(Calendar.YEAR);

    Taal taal = null;
    private KaartMapper km;

    public Speler(String naam, int geboortejaar, int krediet, Kaart[] wedstrijdStapel) {

        this.krediet = krediet;

        controleerNaam(naam);
        this.naam = naam;

        controleerLeeftijd(geboortejaar);
        this.geboortejaar = geboortejaar;

        this.wedstrijdStapel = wedstrijdStapel;

    }

    private void controleerNaam(String naam) throws IllegalArgumentException {

        String[] leestekens = {",", ".", "!", "?", "'", ";", "-"};

        if (naam.length() < 3 || Character.isDigit(naam.charAt(0))) {
            throw new IllegalArgumentException(Taal.geefVertaling("drNaam"));
        }

        for (int i = 0; i < naam.length(); i++) {
            char c = naam.charAt(i);

            if (c == ' ') {
                throw new IllegalArgumentException(Taal.geefVertaling("naamSpatie"));

            }
        }

        for (int i = 0; i < leestekens.length; i++) {
            if (naam.contains(leestekens[i])) {
                throw new IllegalArgumentException(Taal.geefVertaling("naamLeesteken"));
            }
        }

    }

    private void controleerLeeftijd(int geboortejaar) {

        if (year - geboortejaar < 6 || year - geboortejaar > 99) {
            throw new IllegalArgumentException(Taal.geefVertaling("controleerGeboortejaar"));
        }

    }

    public String getNaam() {
        return naam;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public int getKrediet() {
        return krediet;
    }

    public void setNaam(String naam) {
        controleerNaam(naam);
        this.naam = naam;
    }

    public void setGeboortejaar(int geboortejaar) {
        controleerLeeftijd(geboortejaar);
        this.geboortejaar = geboortejaar;
    }

    public void setKrediet(int krediet) {
        this.krediet = krediet;
    }

    public Kaart[] getWedstrijdStapel() {
        return wedstrijdStapel;
    }

    public void setWedstrijdStapel(Kaart[] wedstrijdStapel) {

        this.wedstrijdStapel = wedstrijdStapel;
        
    }

    @Override
    public String toString() {

        return String.format("%s", naam);

    }

    public void voegWedstrijdStapelToe() {

    }

}
