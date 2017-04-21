package gateway;

import entity.criteria.ActivityCriteria;
import exception.DataEmptyException;
import selectionfactory.ActivitySelectionFactory;
import selectionfactory.SelectionFactory;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by Admin on 4/21/2017.
 */
public class ActivityGateway {

    public ResultSet getReport(ActivityCriteria criteria) throws SQLException, ClassNotFoundException, DataEmptyException {
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

        SelectionFactory activityCriteria = new ActivitySelectionFactory();
        String where = activityCriteria.search(criteria);

        String searchQuery = "select * from zoo.activity where " + where;

        ResultSet foundData = statement.executeQuery(searchQuery);

        return foundData;
    }
}
