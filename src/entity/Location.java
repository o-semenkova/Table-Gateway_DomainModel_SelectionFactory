package entity;

import java.util.Objects;

/**
 * Created by Admin on 4/21/2017.
 */
public class Location {
    private int id;
    private String type;
    private int size;
    private int animalId;

    public Location() {
    }

    public Location(int id, String type, int size, int animalId) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return size == location.size &&
                animalId == location.animalId &&
                Objects.equals(type, location.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, animalId);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", animalId=" + animalId +
                '}';
    }
}
