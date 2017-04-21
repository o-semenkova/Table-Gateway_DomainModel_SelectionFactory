package entity.criteria;

import entity.Activity;
import exception.DataAccessException;
import exception.DataEmptyException;
import mapper.ActivityMapper;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Admin on 4/21/2017.
 */
public class ActivityCriteria {

    private int workerId;
    private int locationId;
    private String action;
    private LocalDate from;
    private LocalDate to;
    private ActivityMapper activityMapper;

    public ActivityCriteria() {
        this.activityMapper = new ActivityMapper();
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public List<Activity> getReport() throws DataAccessException, ClassNotFoundException, DataEmptyException {
        return activityMapper.getReport(this);
    }
}
