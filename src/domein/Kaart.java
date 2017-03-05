package domein;

public class Kaart {

    private String kaarttype;
    private int waarde;

    public Kaart(String kaarttype, int waarde) {
        controleerKaartType(kaarttype);
        this.kaarttype = kaarttype;

        controleerWaarde(waarde);
        this.waarde = waarde;
    }

    private void controleerKaartType(String kaartType) {

        if (kaartType != "+" && kaartType != "-" && kaartType != "+/-") {
            throw new IllegalArgumentException("Het kaarttype bestaat niet!");
        }

    }

    private void controleerWaarde(int waarde) {

        if (waarde < 1 || waarde > 6) {
            throw new IllegalArgumentException("De waarde van de kaart is te laag of te hoog");
        }

    }

}
