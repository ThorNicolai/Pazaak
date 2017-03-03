package domein;

public class Speler {
    
    private String naam;
    private int geboortejaar;
    private int krediet;
    
    public Speler(String naam, int geboortejaar, int krediet){
        this.naam = naam;
        this.geboortejaar = geboortejaar;
        this.krediet = krediet;
        
        controleerNaam(naam);
        controleerLeeftijd(geboortejaar);
        
        
    }
    
    private void controleerNaam(String naam){
        
        if(naam.length() < 3){
            throw new IllegalArgumentException("De naam moet minimum 3 karakters lang zijn.");
        }
        
    }
    
    private void controleerLeeftijd(int geboortejaar){
           
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
