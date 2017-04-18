package domein;

public class Kaart {

    private String kaarttype;
    private int waarde;

    public Kaart(String kaarttype, int waarde) {
        this.kaarttype = kaarttype;
        this.waarde = waarde;
    }

    public String getKaarttype() {
        return kaarttype;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setKaarttype(String kaarttype) {
        this.kaarttype = kaarttype;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

}
