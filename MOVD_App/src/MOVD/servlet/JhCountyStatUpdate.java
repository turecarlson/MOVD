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
 * Servlet to update a JhCountyStat record.
 */
@WebServlet("/jhcountystatupdate")
public class JhCountyStatUpdate extends HttpServlet {

  protected JhCountyStatDao jhCountyStatDao;

  @Override
  public void init() throws ServletException {
    jhCountyStatDao = JhCountyStatDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve user and validate.
    String fipsCode = req.getParameter("fipscode");
    if (fipsCode == null || fipsCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid FipsCode.");
    } else {
      //Check that fipscode is numeric
      try {
        int n = Integer.parseInt(fipsCode);
      } catch (NumberFormatException e) {
        messages.put("success", "Invalid FipsCode");
        req.getRequestDispatcher("/JhCountyStatUpdate.jsp").forward(req, resp);
        return;
      }
      try {
        JhCountyStat jhCountyStat = jhCountyStatDao.getFromFipsCode(fipsCode);
        if (jhCountyStat == null) {
          messages.put("success", "County does not exist.");
        }
        req.setAttribute("jhCountyStat", jhCountyStatDao);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/JhCountyStatUpdate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve user and validate.
    String fipsCode = req.getParameter("fipscode");
    if (fipsCode == null || fipsCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid FipsCode.");
    } else {
      try {
        JhCountyStat jhCountyStat = jhCountyStatDao.getFromFipsCode(fipsCode);
        if (jhCountyStat == null) {
          messages.put("success", "County does not exist. No update to perform.");
        } else {
          String newLastUpdate = req.getParameter("lastupdate");
          String newState = req.getParameter("state");
          String newCountyName = req.getParameter("countyname");
          String newCountyNameLong = req.getParameter("countynamelong");
          String newLatitude = req.getParameter("latitude");
          String newLongitude = req.getParameter("longitude");
          String newNCHSUrbanization = req.getParameter("nchsurbanization");
          String newTotalPopulation = req.getParameter("totalpopulation");

          JhCountyStat newJhCountyStat = new JhCountyStat(fipsCode);
          int count = 0;
          if (!(newLastUpdate == null || newLastUpdate.trim().isEmpty())) {
            newJhCountyStat.setLastUpdate(newLastUpdate);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated LastUpdate");
            count++;
          }
          if (!(newState == null || newState.trim().isEmpty())) {
            newJhCountyStat.setState(newState);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated State");
            count++;
          }
          if (!(newCountyName == null || newCountyName.trim().isEmpty())) {
            newJhCountyStat.setCountyName(newCountyName);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated CountyName");
            count++;
          }
          if (!(newCountyNameLong == null || newCountyNameLong.trim().isEmpty())) {
            newJhCountyStat.setCountyNameLong(newCountyNameLong);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated CountyNameLong");
            count++;
          }
          if (!(newLatitude == null || newLatitude.trim().isEmpty())) {
            newJhCountyStat.setLatitude(newLatitude);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated Latitude");
            count++;
          }
          if (!(newLongitude == null || newLongitude.trim().isEmpty())) {
            newJhCountyStat.setLongitude(newLongitude);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated Longitude");
            count++;
          }
          if (!(newNCHSUrbanization == null || newNCHSUrbanization.trim().isEmpty())) {
            newJhCountyStat.setNchsUrbanization(newNCHSUrbanization);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated NCHSUrbanization");
            count++;
          }
          if (!(newTotalPopulation == null || newTotalPopulation.trim().isEmpty())) {
            newJhCountyStat.setTotalPopulation(newTotalPopulation);
            messages.put("success", messages.get("successs") + "\nSuccessfully updated TotalPopulation");
            count++;
          }

          newJhCountyStat = jhCountyStatDao.update(jhCountyStat, newJhCountyStat);

          if (count > 0) {
            messages.put("successs", "\nSuccessfully updated County: " + fipsCode);
          }
        }
        req.setAttribute("jhCountyStat", jhCountyStat);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/JhCountyStatUpdate.jsp").forward(req, resp);
  }
}
