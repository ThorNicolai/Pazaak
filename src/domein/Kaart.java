package domein;

public class Kaart {

    private String type;
    private int waarde;

    public Kaart(String kaarttype, int waarde) {
        this.type = kaarttype;
        this.waarde = waarde;
    }

    public String getKaarttype() {
        return type;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setKaarttype(String kaarttype) {
        this.type = kaarttype;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
    
    @Override
    public String toString(){
        
        return String.format("%s%d",type, waarde);
        
    }
    
    

}
