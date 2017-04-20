package entity;

import exception.DataAccessException;
import mapper.ProfileMapper;

import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 4/21/2017.
 */
public class Profile {
    private int id ;
    private String nutrition;
    private String wayoflife;
    private ProfileMapper profileMapper;

    public Profile() {
        this.profileMapper = new ProfileMapper();
    }

    public Profile(int id, String nutrition, String wayoflife) {
        this.id = id;
        this.nutrition = nutrition;
        this.wayoflife = wayoflife;
    }

    public Profile getFullInfo(int animalId) throws DataAccessException, ClassNotFoundException {
        return profileMapper.getFullProfile(animalId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getWayoflife() {
        return wayoflife;
    }

    public void setWayoflife(String wayoflife) {
        this.wayoflife = wayoflife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(nutrition, profile.nutrition) &&
                Objects.equals(wayoflife, profile.wayoflife);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", nutrition='" + nutrition + '\'' +
                ", wayoflife='" + wayoflife + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nutrition, wayoflife);
    }
}
