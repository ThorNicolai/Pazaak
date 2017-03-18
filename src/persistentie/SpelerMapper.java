package persistentie;

import domein.Speler;
//import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {
    
    
    public void voegToe(Speler speler) {

            try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
                PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_dobbel.speler (naam, voornaam, emailadres, geboortedatum, wachtwoord, beheerder, krediet)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)");
                query.setString(1, speler.getNaam());
//                query.setString(2, speler.getVoornaam());
//                query.setString(3, speler.getEmailadres());
                query.setInt(4, speler.getGeboortejaar());
//                query.setString(5, speler.getWachtwoord());
//                query.setBoolean(6, speler.isAdminrechten());
                query.setInt(7, speler.getKrediet());
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
//                    String voornaam = rs.getString("voornaam");
//                    String emailadres = rs.getString("emailadres");
                    int geboortejaar = rs.getInt("geboortedatum");
//                    String wachtwoord = rs.getString("wachtwoord");
//                    boolean beheerder = rs.getBoolean("beheerder");
                    int krediet = rs.getInt("krediet");

                    spelers.add(new Speler(naam, /*voornaam, emailadres,*/ geboortejaar, /*wachtwoord, beheerder,*/ krediet));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spelers;
    }

}
