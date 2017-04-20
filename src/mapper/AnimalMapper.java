package mapper;

import entity.Animal;
import exception.DataAccessException;
import gateway.AnimalGateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/20/2017.
 */
public class AnimalMapper {

    private AnimalGateway animalGateway = new AnimalGateway();

    public synchronized List<Animal> getAlAnimals() throws DataAccessException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        ResultSet rs;
        try {
            rs = animalGateway.getAllAnimals();
            while (rs.next()) {

                int id = rs.getInt("id");
                int profile_id = rs.getInt("profile_id");
                String species = rs.getString("species");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String origin = rs.getString("origin");
                String health = rs.getString("health");

                Animal animal = new Animal();
                animal.setId(id);
                animal.setProfile_id(profile_id);
                animal.setSpecies(species);
                animal.setName(name);
                animal.setAge(age);
                animal.setOrigin(origin);
                animal.setHealth(health);

                animals.add(animal);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error during getting data from db", e);
        }

        return animals;
    }
}
