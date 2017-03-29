package persistentie;

import domein.Speler;
import exceptions.NaamInGebruikException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {

    

    public void voegToe(Speler nieuweSpeler) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_g42.Speler(naam,geboortejaar,krediet)"
                    + "VALUES (?, ?, ?)");
            query.setString(1, nieuweSpeler.getNaam());
            query.setInt(2, nieuweSpeler.getGeboortejaar());
            query.setInt(3, nieuweSpeler.getKrediet());
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new NaamInGebruikException(ex);

        }

    }

    public Speler geefSpeler(String naam) {

        Speler speler = null;
        boolean flag = false;

        do {

            try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g42.speler WHERE naam == '?'");
                query.setString(1, naam);
                try (ResultSet rs = query.executeQuery()) {
                    if (rs.next()) {
                        int geboortejaar = rs.getInt("geboortejaar");
                        int krediet = rs.getInt("krediet");

                        speler = new Speler(naam, geboortejaar, krediet);

                        flag = true;

                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException();
            }

        } while (flag = false);

        return speler;
    }

    public List<Speler> geefSpelersLijst() {
        
        List<Speler> spelers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g42.Speler");

            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {

                    String naam = rs.getString("naam");
                    int geboortejaar = rs.getInt("geboortejaar");
                    int krediet = rs.getInt("krediet");

                    spelers.add(new Speler(naam, geboortejaar, krediet));

                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException();
        }

        return spelers;

    }
}
