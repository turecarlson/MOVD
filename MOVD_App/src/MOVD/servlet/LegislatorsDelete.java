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
 * Servlet to delete a Legislators record.
 */
@WebServlet("/legislatorsdelete")
public class LegislatorsDelete extends HttpServlet {

  protected LegislatorsDao legislatorsDao;

  @Override
  public void init() throws ServletException {
    this.legislatorsDao = LegislatorsDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    messages.put("title", "Delete a Legislator Record");
    req.getRequestDispatcher("/LegislatorsDelete.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String stringLegislatorKey = req.getParameter("LegislatorsKey");
    if (stringLegislatorKey == null || stringLegislatorKey.trim().isEmpty()) {
      messages.put("title", "Invalid Legislator ID");
      messages.put("disableSubmit", "true");
    } else {
      long legislatorsKey = Long.parseLong(stringLegislatorKey);
      Legislators legislator = new Legislators(legislatorsKey);
      try {
        legislator = legislatorsDao.delete(legislator);
        // Update the message.
        if (legislator == null) {
          messages.put("title", "Successfully deleted Legislator with id: " + stringLegislatorKey);
          messages.put("disableSubmit", "true");
        } else {
          messages.put("title", "Failed to delete Legislator with id: " + stringLegislatorKey);
          messages.put("disableSubmit", "false");
        }
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/LegislatorsDelete.jsp").forward(req, resp);
  }

}
