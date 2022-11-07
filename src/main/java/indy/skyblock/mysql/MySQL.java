package indy.skyblock.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {
    private final String host = "localhost";
    private final String port = "3306";
    private final String database = "skyblock";
    private final String user = "root";
    private final String password = "";

    private Connection connection;

    public boolean isConnected() {
        return (connection != null);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if(!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", user, password);
        }
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createTable() {
        try {
            PreparedStatement statsTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS skyblock_player_stats " +
                    "(ID INT AUTO_INCREMENT, NAME VARCHAR(20), UUID VARCHAR(150), HEALTH INT, DEFENSE INT, STRENGTH INT, SPEED INT, " +
                    "CRIT_CHANCE INT, CRIT_DAMAGE INT, INTELLIGENCE INT, MINING_SPEED INT, ATTACK_SPEED INT, SEA_CREATURE_CHANCE INT, " +
                    "MAGIC_FIND INT, PET_LUCK INT, TRUE_DEFENSE INT, FEROCITY INT, ABILITY_DAMAGE INT, MINING_FORTUNE INT, " +
                    "FARMING_FORTUNE INT, FORAGING_FORTUNE INT, PRISTINE INT,PRIMARY KEY (ID))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
