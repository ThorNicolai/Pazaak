package persistentie;

import domein.Speler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {
    
    
    public void voegToe(Speler speler) {

            try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
                PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_dobbel.speler (naam, voornaam, emailadres, geboortedatum, wachtwoord, beheerder, krediet)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)");
                query.setString(1, speler.getNaam());
                query.setInt(2, speler.getGeboortejaar());
                query.setInt(3, speler.getKrediet());
                query.executeUpdate();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


public List<Speler> geefSpelers() {
        List<Speler> spelers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_dobbel.speler");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    String naam = rs.getString("naam");
                    int geboortejaar = rs.getInt("geboortedatum");
                    int krediet = rs.getInt("krediet");

                    spelers.add(new Speler(naam, geboortejaar, krediet));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spelers;
    }

}
