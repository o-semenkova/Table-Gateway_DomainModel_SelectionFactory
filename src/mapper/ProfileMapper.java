package mapper;

import entity.Profile;
import exception.DataAccessException;
import gateway.ProfileGateway;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/21/2017.
 */
public class ProfileMapper {

    private ProfileGateway profileGateway = new ProfileGateway();

    public synchronized Profile getFullProfile(int animalId) throws DataAccessException, ClassNotFoundException {
        Profile fullProfile = new Profile();
        ResultSet rs;
        try {
            rs = profileGateway.getFullInfo(animalId);
            while (rs.next()) {

                String nutrition = rs.getString("nutrition");
                String wayOfLife = rs.getString("wayOfLife");
                int id = rs.getInt("id");

                fullProfile.setId(id);
                fullProfile.setNutrition(nutrition);
                fullProfile.setWayoflife(wayOfLife);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error during getting data from db", e);
        }

        return fullProfile;
    }
}
