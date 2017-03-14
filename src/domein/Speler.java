package domein;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import persistentie.SpelerMapper;

public class Speler {

    private List<Speler> lijstSpelers = new ArrayList<Speler>();

    private String naam;
    private int geboortejaar, krediet;
    
    int year = Calendar.getInstance().get(Calendar.YEAR);

    public Speler(String naam, int geboortejaar, int krediet) {

        this.krediet = krediet;

        controleerNaam(naam);
        this.naam = naam;
        controleerLeeftijd(geboortejaar);
        this.geboortejaar = geboortejaar;

    }

    private void controleerNaam(String naam) throws IllegalArgumentException
    {

        String[] leestekens = {",", ".", "!", "?", "'", ";", "-"};

        if (naam.length() < 3 || Character.isDigit(naam.charAt(0))) {
            throw new IllegalArgumentException("De naam moet minimum 3 karakters lang zijn en mag niet beginnen met een cijfer");
        }

        for(int i=0;i<naam.length();i++){ // werkt niet
            char c = naam.charAt(i);
            if(c==' '){
                throw new IllegalArgumentException("De naam bevat een spatie");
            }
        }
        
//        if(naam.contains(" ")){ //werkt ook niet
//            throw new IllegalArgumentException("bevat spatie");
//        }

        for (int i = 0; i < leestekens.length; i++) {
            if (naam.contains(leestekens[i])) {
                throw new IllegalArgumentException("De naam bevat een leesteken");
            }
        }

        
            
        

    }

    private void controleerLeeftijd(int geboortejaar) {

        if (year - geboortejaar < 6 || year - geboortejaar > 99) {
            throw new IllegalArgumentException("Een speler moet dit jaar minstens 6 "
                    + "jaar en maximaal 99 zijn/worden.");
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
        this.naam = naam;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }

    public void setKrediet(int krediet) {
        this.krediet = krediet;
    }

}
