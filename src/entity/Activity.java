package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Admin on 4/21/2017.
 */
public class Activity {
    private int workerId;
    private int locationId;
    private String action;
    private LocalDate time;

    public Activity() {
    }

    public Activity(int workerId, int locationId, String action, LocalDate time) {
        this.workerId = workerId;
        this.locationId = locationId;
        this.action = action;
        this.time = time;
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

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(action, activity.action) &&
                Objects.equals(time, activity.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, time);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "workerId=" + workerId +
                ", locationId=" + locationId +
                ", action='" + action + '\'' +
                ", time=" + time +
                '}';
    }
}
