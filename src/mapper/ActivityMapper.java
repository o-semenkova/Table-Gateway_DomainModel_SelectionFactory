package mapper;

import entity.Activity;
import entity.criteria.ActivityCriteria;
import exception.DataAccessException;
import exception.DataEmptyException;
import gateway.ActivityGateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/21/2017.
 */
public class ActivityMapper {

    private ActivityGateway activityGateway = new ActivityGateway();

    public synchronized List<Activity> getReport(ActivityCriteria criteria) throws DataAccessException, ClassNotFoundException, DataEmptyException {
        List<Activity> activities = new ArrayList<Activity>();
        ResultSet rs;
        try {
            rs = activityGateway.getReport(criteria);
            while (rs.next()) {

                int workerId = rs.getInt("worker_id");
                int locationId = rs.getInt("location_id");
                String action = rs.getString("action");
                LocalDate time = rs.getDate("time").toLocalDate();

                Activity activity = new Activity();
                activity.setWorkerId(workerId);
                activity.setLocationId(locationId);
                activity.setAction(action);
                activity.setTime(time);

                activities.add(activity);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error during getting data from db", e);
        }

        return activities;
    }
}
