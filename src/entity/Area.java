package entity;

import java.util.Objects;

/**
 * Created by Admin on 4/21/2017.
 */
public class Area {
    private int id;
    private String name;
    private int size;
    private int locationId;

    public Area() {
    }

    public Area(int id, String name, int size, int locationId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.locationId = locationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return size == area.size &&
                locationId == area.locationId &&
                Objects.equals(name, area.name);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", locationId=" + locationId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, locationId);
    }
}
