package servlet;

import entity.Activity;
import entity.Animal;
import entity.Profile;
import entity.criteria.ActivityCriteria;
import exception.DataAccessException;
import exception.DataEmptyException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/20/2017.
 */
public class ZooServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String workerId = request.getParameter("workerId");
        String locationId = request.getParameter("locationId");
        String action = request.getParameter("action");
        String from = request.getParameter("from");
        String to = request.getParameter("to");

        ActivityCriteria activityCriteria = new ActivityCriteria();
        if(workerId != ""){
            activityCriteria.setWorkerId(Integer.parseInt(workerId));
        }

        if(locationId != ""){
            activityCriteria.setLocationId(Integer.parseInt(locationId));
        }
        activityCriteria.setAction(action);

        if(from != "" && to != ""){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
            activityCriteria.setFrom(LocalDate.parse(from, formatter));
            activityCriteria.setFrom(LocalDate.parse(to, formatter));
        }

        List<Activity> found = new ArrayList<Activity>();
        try {
            found = activityCriteria.getReport();
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DataEmptyException e) {
            e.printStackTrace();
        }

        request.setAttribute("found", found);
        request.getRequestDispatcher("/report.jsp").forward(request, response);
    }

}
