package entity;

import java.sql.*;
import java.util.Objects;

/**
 * Created by Admin on 4/19/2017.
 */
public class Animal {
    private int id;
    private int profile_id;
    private String species;
    private String name;
    private int age;
    private String origin;
    private String health;

    public Animal(){}

    public Animal(int profile_id, String species, String name, int age, String origin, String health) {
        this.profile_id = profile_id;
        this.species = species;
        this.name = name;
        this.age = age;
        this.origin = origin;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(species, animal.species) &&
                Objects.equals(name, animal.name) &&
                Objects.equals(origin, animal.origin) &&
                Objects.equals(health, animal.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, name, age, origin, health);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", profile_id=" + profile_id +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", origin='" + origin + '\'' +
                ", health='" + health + '\'' +
                '}';
    }

    public void getAllAnimals() throws SQLException {
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from zoo.animal");
    }
}
