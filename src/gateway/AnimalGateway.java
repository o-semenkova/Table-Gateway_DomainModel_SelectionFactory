package gateway;

import java.sql.*;

/**
 * Created by Admin on 4/20/2017.
 */
public class AnimalGateway {

    public ResultSet getAllAnimals() throws SQLException, ClassNotFoundException {
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
        ResultSet allAnimals = statement.executeQuery("SELECT * from zoo.animal");

        return allAnimals;
    }
}
