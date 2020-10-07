package MOVD.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MOVD.dal.GoogleMobilityDataDao;
import MOVD.model.*;


/**
 * Servlet to Find a GoogleMobilityData record.
 */
@WebServlet("/googlemobilitydatafind")
public class GoogleMobilityDataFind extends HttpServlet {

  protected GoogleMobilityDataDao googleMobilityDataDao;

  @Override
  public void init() throws ServletException {
    googleMobilityDataDao = GoogleMobilityDataDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<GoogleMobilityData> records = new ArrayList<GoogleMobilityData>();

    // Retrieve and validate fipscode.
    // fipscode is retrieved from the URL query string.
    String FipsCode = req.getParameter("fipscode");
    if (FipsCode == null || FipsCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid name.");
    } else {
      // Retrieve records, and store as a message.
      try {
        records = googleMobilityDataDao.getDataByFipsCode(FipsCode);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for " + FipsCode);
      // Save the previous search term, so it can be used as the default
      // in the input box when rendering FindUsers.jsp.
      messages.put("previousSearch", FipsCode);
    }
    req.setAttribute("FipsCode", records);

    req.getRequestDispatcher("/GoogleMobilityDataFind.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<GoogleMobilityData> records = new ArrayList<GoogleMobilityData>();

    // Retrieve and validate fipscode.
    // fipscode is retrieved from the URL query string.
    String FipsCode = req.getParameter("fipscode");
    if (FipsCode == null || FipsCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid name.");
    } else {
      // Retrieve records, and store as a message.
      try {
        records = googleMobilityDataDao.getDataByFipsCode(FipsCode);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for " + FipsCode);
      // Save the previous search term, so it can be used as the default
      // in the input box when rendering FindUsers.jsp.
      messages.put("previousSearch", FipsCode);
    }
    req.setAttribute("FipsCode", records);

    req.getRequestDispatcher("/GoogleMobilityDataFind.jsp").forward(req, resp);
  }
}
