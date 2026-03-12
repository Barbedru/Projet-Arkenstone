package d_and_d.db;

import d_and_d.character.Character;
import java.sql.*;

/**
 * Gère toutes les interactions avec la base de données MySQL.
 * <p>
 * Fournit les opérations CRUD sur la table {@code Heros} :
 * lecture, création et modification de héros.
 * Chaque méthode ouvre et ferme sa propre connexion via try-with-resources
 * pour garantir la libération des ressources même en cas d'erreur.
 * </p>
 */
public class DatabaseConnection {

    // Paramètres de connexion — à externaliser dans un fichier de config en production
    private static final String URL      = "jdbc:mysql://localhost:3306/Arkenstone";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";

    /**
     * Crée et retourne une connexion à la base de données.
     *
     * @return une connexion JDBC active
     * @throws SQLException si la connexion échoue
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Récupère et affiche tous les héros enregistrés en base de données.
     * Utilisé pour choisir un héros à modifier via son ID.
     */
    public void getHeroes() {
        String query = "SELECT * FROM Heros";

        // try-with-resources : connexion, statement et resultSet fermés automatiquement
        try (Connection connection = connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("=== HEROES ===");

            while (rs.next()) {
                int id                = rs.getInt("id");
                String type           = rs.getString("Type");
                String name           = rs.getString("Name");
                int lifePoints        = rs.getInt("LifePoints");
                int strength          = rs.getInt("Strength");
                String offensiveEquip = rs.getString("OffensiveEquipment");
                String defensiveEquip = rs.getString("DefensiveEquipment");

                System.out.println("-----------------------------");
                System.out.println(id + " " + type + " " + name + " "
                        + lifePoints + "❤️ " + strength + "💪🏼 "
                        + offensiveEquip + " " + defensiveEquip);
            }

            System.out.println("=============================");

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

    /**
     * Insère un nouveau héros en base de données après sa création.
     * Utilise un PreparedStatement pour éviter les injections SQL.
     *
     * @param character le héros à sauvegarder
     */
    public void createHero(Character character) {
        String query = "INSERT INTO Heros (Type, Name, LifePoints, Strength, OffensiveEquipment) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getHp());
            pstmt.setInt(4, character.getAttack());
            // Si le héros n'a pas d'équipement, on stocke "none"
            pstmt.setString(5, character.getOffensiveEquipment() == null ? "none" : character.getOffensiveEquipment().toString());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error save : " + e.getMessage());
        }
    }

    /**
     * Met à jour un héros existant en base de données.
     *
     * @param id        l'identifiant du héros à modifier
     * @param character le personnage contenant les nouvelles valeurs
     */
    public void editHero(int id, Character character) {
        String query = "UPDATE Heros SET Type = ?, Name = ?, LifePoints = ?, Strength = ?, OffensiveEquipment = ? WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getHp());
            pstmt.setInt(4, character.getAttack());
            pstmt.setString(5, character.getOffensiveEquipment() == null ? "none" : character.getOffensiveEquipment().toString());
            pstmt.setInt(6, id); // le WHERE id = ? doit toujours être le dernier paramètre
            pstmt.executeUpdate();
            System.out.println("Hero updated !");

        } catch (SQLException e) {
            System.err.println("Error update : " + e.getMessage());
        }
    }
}