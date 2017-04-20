package servlet;

import entity.Animal;
import entity.Profile;
import exception.DataAccessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/20/2017.
 */
public class ZooServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Animal animal = new Animal();
        List<Animal> animals = new ArrayList<Animal>();
        try {
            animals = animal.getAllAnimals();
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Profile profile = new Profile();
        Profile found = new Profile();
        try {
            found = profile.getFullInfo(2);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("animalsList", animals);
        request.setAttribute("profile", found);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
