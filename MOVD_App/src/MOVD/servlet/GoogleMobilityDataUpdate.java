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
 * Servlet to update a GoogleMobilityData record.
 */
@WebServlet("/googlemobilitydataupdate")
public class GoogleMobilityDataUpdate extends HttpServlet {

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
    req.getRequestDispatcher("/GoogleMobilityDataUpdate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {

    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    //Check for existing record
    GoogleMobilityData record = null;
    long pk = Long.parseLong(req.getParameter("PrimaryKey"));
    try {
      record = GoogleMobilityDao.getRecordByKey(pk);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    //Check for completeness
    String fips = req.getParameter("JHCountyStat_FipsCode");
    if (fips == null || fips.trim().isEmpty()) {
      messages.put("success", "Invalid data, must have a FipsCode.");
    } else if (record == null) {
      messages.put("success", "Record does not exist, please input an existing record");
    } else {
      //Parse the date
      String stringDate = req.getParameter("Date");
      Date date = null;
      try {
        date = Date.valueOf(stringDate);
        // Update the record and parse to correct data types
        String country = req.getParameter("Country");
        long rec = Long.parseLong(req.getParameter("Rec"));
        long grocery = Long.parseLong(req.getParameter("Grocery"));
        long parks = Long.parseLong(req.getParameter("Parks"));
        long transit = Long.parseLong(req.getParameter("Transit_Station"));
        long work = Long.parseLong(req.getParameter("Work"));
        long residential = Long.parseLong(req.getParameter("Residential"));

        try {
          GoogleMobilityData old = new GoogleMobilityData(pk);
          GoogleMobilityData newData = new GoogleMobilityData(date, country, rec, grocery, parks, transit, work, residential, fips);
          newData = GoogleMobilityDao.update(old, newData);
          messages.put("success", "Successfully updated record " + old.getSyntheticMobilityPk());
        } catch (SQLException e) {
          messages.put("success", "There was an issue with the data you submitted, please check for valid foreign key constraints");
        }
      } catch (IllegalArgumentException a) {
        messages.put("success", "Invalid date, please input in yyyy-mm-dd");
      }
    }
    req.getRequestDispatcher("/GoogleMobilityDataUpdate.jsp").forward(req, resp);
  }

}
