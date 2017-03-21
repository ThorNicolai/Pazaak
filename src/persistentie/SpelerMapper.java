package persistentie;

import domein.Speler;
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

    public void voegToe(Speler speler) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_g42.db.webhosting.be (naam, geboortedatum, krediet)"
                    + "VALUES (?, ?, ?)");
            query.setString(1, speler.getNaam());
            query.setInt(2, speler.getGeboortejaar());
            query.setInt(3, speler.getKrediet());
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public Speler geefSpeler(String naam) {

        Speler speler = null;

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g42.db.webhosting.be WHERE naam = ?");
            query.setString(1, naam);
            try (ResultSet rs = query.executeQuery()) {
                if (rs.next()) {
                    int geboortejaar = rs.getInt("geboortejaar");
                    int krediet = rs.getInt("krediet");

                    speler = new Speler(naam, geboortejaar, krediet);

                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return speler;
    }
}
