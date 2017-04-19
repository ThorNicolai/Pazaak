package persistentie;

import domein.Kaart;
import domein.Speler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KaartMapper {

    public List<Kaart> geefKaarten() {

        List<Kaart> kaarten = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g42.Kaart");
            try (ResultSet rs = query.executeQuery()) {
                
                while (rs.next()) {
                    String type = rs.getString("type");
                    int waarde = rs.getInt("waarde");

                    kaarten.add(new Kaart(type,waarde));
                        
                }
                
                

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return kaarten;
    }

}
