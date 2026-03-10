package d_and_d.db;

import d_and_d.character.Character;
import java.sql.*;
import java.sql.PreparedStatement;


public class DatabaseConnection {

    //Infos de connexion à la bdd
    private String URL = "jdbc:mysql://localhost:3306/Arkenstone";
    private String USER = "root";
    private String PASSWORD = "root";


    // Méthode qui crée et retourne une connexion
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // RÉCUPÈRE LA LISTE DES HÉROS DE LA BDD

    public void getHeroes() {
        String query = "SELECT * FROM Heros";

        try (Connection connection = connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("=== HEROES ===");

            while (rs.next()) {
                int id                   = rs.getInt("id");
                String type              = rs.getString("Type");
                String name              = rs.getString("Name");
                int lifePoints           = rs.getInt("LifePoints");
                int strength             = rs.getInt("Strength");
                String offensiveEquip    = rs.getString("OffensiveEquipment");
                String defensiveEquip    = rs.getString("DefensiveEquipment");

                System.out.println("-----------------------------");
                System.out.println(id + " " +
                                   type + " " +
                                    name + " " +
                                    lifePoints + "❤️" + " " +
                                    strength + "💪🏼" + " " +
                                    offensiveEquip +
                                    defensiveEquip );

            }

            System.out.println("=============================");

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

    //SAUVEGARDE LE HERO CRÉÉ PAR LE JOUEUR DANS LA BDD

    public void createHero(Character character) {
        String query = "INSERT INTO Heros (Type, Name, LifePoints, Strength, OffensiveEquipment) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = connect()){
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getHp());
            pstmt.setInt(4, character.getAttack());
            pstmt.setString(5, character.getOffensiveEquipment() == null ? "none" : character.getOffensiveEquipment().toString());
            pstmt.executeUpdate();

        }   catch (SQLException e) {
            System.err.println("Error save : " + e.getMessage());
        }

    }

    //MODIFIE UN HERO EXISTANT

    public void editHero(int id, Character character) {
        String query = "UPDATE Heros SET Type = ?, Name = ?, LifePoints = ?, Strength = ?, OffensiveEquipment = ? WHERE id = ?";

        try (Connection connection = connect()) {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getHp());
            pstmt.setInt(4, character.getAttack());
            pstmt.setString(5, character.getOffensiveEquipment() == null ? "none" : character.getOffensiveEquipment().toString()
            );
            pstmt.setInt(6, id); // ← le WHERE id = ?, toujours en dernier

            pstmt.executeUpdate();
            System.out.println("Hero updated !");

        } catch (SQLException e) {
            System.err.println("Error update : " + e.getMessage());
        }
    }

    //MODIFIER HP HERO

//    public void changeHp(int id, Character character) {
//        String query = "UPDATE heros SET LifePoints = ? WHERE id = ?";
//
//        try (Connection connection = connect()) {
//            PreparedStatement pstmt = connection.prepareStatement(query);
//
//            pstmt.setInt()
//        }
//
//    }

}
