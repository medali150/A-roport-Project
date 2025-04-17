package airport;

import java.sql.*;
import java.util.*;

public class VolDAO {
    String url = "jdbc:mysql://localhost:3306/aeroport";
    String user = "root";
    String password = "";

    // Affiche tous les vols
    public List<Vol> getAllVols() {
        List<Vol> vols = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM vol")) {

            while (rs.next()) {
                String num = rs.getString("numero_vol");
                String dep = rs.getString("ville_depart");
                String arr = rs.getString("ville_arrivee");

                vols.add(new Vol(num, dep, arr));
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        return vols;
    }

    // Ajoute un vol
    public void ajouterVol(Vol v) {
        String sql = "INSERT INTO vol (numero_vol, ville_depart, ville_arrivee) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getNumeroVol());
            ps.setString(2, v.getVilleDepart());
            ps.setString(3, v.getVilleArrivee());
            ps.executeUpdate();

            System.out.println("Vol ajouté ✅");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Modifie la destination
    public void modifierDestination(String numero, String nouvelleVille) {
        String sql = "UPDATE vol SET ville_arrivee = ? WHERE numero_vol = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nouvelleVille);
            ps.setString(2, numero);
            ps.executeUpdate();

            System.out.println("Destination mise à jour ✅");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}