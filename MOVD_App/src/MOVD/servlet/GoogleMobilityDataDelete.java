package MOVD.servlet;

import java.io.IOException;
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
 * Servlet to delete a GoogleMobilityData record.
 */
@WebServlet("/googlemobilitydatadelete")
public class GoogleMobilityDataDelete extends HttpServlet {

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
    messages.put("title", "Delete Google Mobility Record");
    req.getRequestDispatcher("/GoogleMobilityDataDelete.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String primaryKey = req.getParameter("Synthetic_Mobility_PK");
    if (primaryKey == null || primaryKey.trim().isEmpty()) {
      messages.put("title", "Invalid primary key");
      messages.put("disableSubmit", "true");
    } else {
      // Delete the record.
      long GoogleMobilityDataKey = Long.parseLong(primaryKey);
      GoogleMobilityData googleMobilityData = new GoogleMobilityData(GoogleMobilityDataKey);
      try {
        googleMobilityData = GoogleMobilityDao.delete(googleMobilityData);
        // Update the message.
        if (googleMobilityData == null) {
          messages.put("title", "Successfully deleted GoogleMobilityData with id: " + primaryKey);
          messages.put("disableSubmit", "true");
        } else {
          messages.put("title", "Failed to delete GoogleMobilityData with id: " + primaryKey);
          messages.put("disableSubmit", "false");
        }
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/GoogleMobilityDataDelete.jsp").forward(req, resp);
  }

}


