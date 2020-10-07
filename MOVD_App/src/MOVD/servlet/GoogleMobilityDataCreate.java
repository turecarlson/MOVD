package MOVD.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MOVD.dal.*;
import MOVD.model.*;

/**
 * Servlet to create a GoogleMobilityData record.
 */
@WebServlet("/googlemobilitydatacreate")
public class GoogleMobilityDataCreate extends HttpServlet {

  protected GoogleMobilityDataDao GoogleMobilityDao;

  @Override
  public void init() throws ServletException {
    this.GoogleMobilityDao = GoogleMobilityDataDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    req.getRequestDispatcher("/GoogleMobilityDataCreate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {

    //Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    //Check for completeness of form
    String fips = req.getParameter("JHCountyStat_FipsCode");
    if (fips == null || fips.trim().isEmpty()) {
      messages.put("success", "Invalid data, must have a FipsCode.");
    } else {
      //Parse the date, if invalid, ask the user to resubmit
      String stringDate = req.getParameter("Date");
      Date date = null;

      try {
        date = Date.valueOf(stringDate);
        // Create the record and parse to correct data types
        String country = req.getParameter("Country");
        long rec = Long.parseLong(req.getParameter("Rec"));
        long grocery = Long.parseLong(req.getParameter("Grocery"));
        long parks = Long.parseLong(req.getParameter("Parks"));
        long transit = Long.parseLong(req.getParameter("Transit_Station"));
        long work = Long.parseLong(req.getParameter("Work"));
        long residential = Long.parseLong(req.getParameter("Residential"));

        try {
          GoogleMobilityData newData = new GoogleMobilityData(date, country, rec, grocery, parks, transit, work, residential, fips);
          newData = GoogleMobilityDao.create(newData);
          messages.put("success", "Successfully created record " + newData.getSyntheticMobilityPk());
        } catch (SQLException e) {
          messages.put("success", "There was an issue with the data you submitted, please check for valid foreign key constraints");
        }
      } catch (IllegalArgumentException a) {
        messages.put("success", "Invalid date, please input in yyyy-mm-dd");
      }
      req.getRequestDispatcher("/GoogleMobilityDataCreate.jsp").forward(req, resp);
    }
  }
}
