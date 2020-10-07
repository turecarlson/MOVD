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
 * Servlet to create a JhCountyStat record.
 */
@WebServlet("/jhcountystatcreate")
public class JhCountyStatCreate extends HttpServlet {

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
    //Just render the JSP.
    req.getRequestDispatcher("/JhCountyStatCreate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String fipsCode = req.getParameter("fipscode");
    //Method for checking a str is a num found using Grepper Chrome Extension. User attributed: Plimpton

    if (fipsCode == null || fipsCode.trim().isEmpty()) {
      messages.put("success", "Invalid FipsCode");
    } else {
      //Check that fipscode is numeric
      try {
        int n = Integer.parseInt(fipsCode);
      } catch (NumberFormatException e) {
        messages.put("success", "Invalid FipsCode");
        req.getRequestDispatcher("/JhCountyStatCreate.jsp").forward(req, resp);
        return;
      }

      // Create the JhCountyStat
      fipsCode = req.getParameter("fipscode");
      String lastUpdate = req.getParameter("lastupdate");
      String state = req.getParameter("state");
      String countyName = req.getParameter("countyname");
      String countyNameLong = req.getParameter("countynamelong");
      String latitude = req.getParameter("latitude");
      String longitude = req.getParameter("longitude");
      String nchsUrbanization = req.getParameter("nchsurbanization");
      String totalPopulation = req.getParameter("totalpopulation");
      try {
        JhCountyStat jhCountyStat = new JhCountyStat(fipsCode, lastUpdate, state, countyName, countyNameLong,
                latitude, longitude, nchsUrbanization, totalPopulation);
        jhCountyStat = jhCountyStatDao.create(jhCountyStat);
        messages.put("success", "Successfully created " + fipsCode);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/JhCountyStatCreate.jsp").forward(req, resp);
  }
}
