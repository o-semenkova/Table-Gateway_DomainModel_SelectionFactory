package gateway;

import java.sql.*;

/**
 * Created by Admin on 4/21/2017.
 */
public class ProfileGateway {

    public ResultSet getFullInfo(int animalId) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        Statement statement = con.createStatement();
        ResultSet fullProfile = statement.executeQuery("select zoo.profile.id,zoo.profile.nutrition,zoo.profile.wayoflife\n" +
                "from zoo.profile\n" +
                "join zoo.animal on zoo.profile.id = zoo.animal.profile_id\n" +
                "where zoo.animal.id=" + animalId);

        return fullProfile;
    }
}
