package d_and_d.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {

    //Infos de connexion à la bdd
    private String URL = "jdbc:mysql://localhost:3306/Arkenstone";
    private String USER = "root";
    private String PASSWORD = "root";


    // Méthode qui crée et retourne une connexion
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void getHeroes() {
        String query = "SELECT * FROM Character";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("=== Liste des personnages ===");

            while (rs.next()) {
                int id                   = rs.getInt("id");
                String type              = rs.getString("Type");
                String name              = rs.getString("Name");
                int lifePoints           = rs.getInt("LifePoints");
                int strength             = rs.getInt("Strength");
                String offensiveEquip    = rs.getString("OffensiveEquipment");
                String defensiveEquip    = rs.getString("DefensiveEquipment");

                System.out.println("-----------------------------");
                System.out.println("ID       : " + id);
                System.out.println("Type     : " + type);
                System.out.println("Nom      : " + name);
                System.out.println("PV       : " + lifePoints);
                System.out.println("Force    : " + strength);
                System.out.println("Attaque  : " + offensiveEquip);
                System.out.println("Défense  : " + defensiveEquip);
            }

            System.out.println("=============================");

        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

}
