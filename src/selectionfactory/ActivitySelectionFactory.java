package selectionfactory;

import entity.criteria.ActivityCriteria;
import exception.DataEmptyException;

import java.time.LocalDate;

/**
 * Created by Admin on 4/21/2017.
 */
public class ActivitySelectionFactory implements SelectionFactory {

    public String search(Object searchCriteria) throws DataEmptyException {

        ActivityCriteria findActivitiesBy = (ActivityCriteria) searchCriteria;

        int workerId = findActivitiesBy.getWorkerId();
        int locationId = findActivitiesBy.getLocationId();
        String action = findActivitiesBy.getAction();
        LocalDate from = findActivitiesBy.getFrom();
        LocalDate to = findActivitiesBy.getTo();

        String formattedString;

        if (workerId != 0 && locationId != 0 && action != null && from != null && to != null) {
            formattedString = String.format("worker_id = %d and location_id = %d and action = '%s' and time between %tD and &tD",
                    workerId,
                    locationId,
                    action,
                    from,
                    to);
        }else if(workerId != 0){
            formattedString = null;
            formattedString = String.format("worker_id = %d",
                    workerId);
        }else if(locationId != 0){
            formattedString = null;
            formattedString = String.format("location_id = %d",
                    locationId);
        }else if(action != null){
            formattedString = null;
            formattedString = String.format("action = %s",
                    action);
        }else if(from != null && to != null){
            formattedString = null;
            formattedString = String.format("time between %tD and &tD",
                    from, to);
        }else{
            throw new DataEmptyException("Data is empty!");
        }

        return formattedString;
    }
}
