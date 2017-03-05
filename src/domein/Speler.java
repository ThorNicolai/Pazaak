package domein;

import java.util.Calendar;

public class Speler {
    
    private String naam;
    private int geboortejaar;
    private int krediet;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    
    public Speler(String naam, int geboortejaar, int krediet){
        
        
        this.krediet = krediet;
        
        controleerNaam(naam);
        this.naam = naam;
        controleerLeeftijd(geboortejaar);
        this.geboortejaar = geboortejaar;
        
        
    }
    
    private void controleerNaam(String naam){
        
        if(naam.length() < 3 || Character.isDigit(naam.charAt(0)) ){
            throw new IllegalArgumentException("De naam moet minimum 3 karakters lang zijn.");
        }
        
    }
    
    private void controleerLeeftijd(int geboortejaar){
        
        if(year - geboortejaar < 6 || year - geboortejaar > 99){
            throw new IllegalArgumentException("Je bent te jong om te spelen. Je moet minstens 6 jaar zijn!");
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
