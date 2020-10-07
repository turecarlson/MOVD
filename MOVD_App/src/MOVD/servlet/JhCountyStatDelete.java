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
 * Servlet to delete a JhCountyStat record.
 */
@WebServlet("/jhcountystatdelete")
public class JhCountyStatDelete extends HttpServlet {

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
    // Provide a title and render the JSP.
    messages.put("title", "Delete County");
    req.getRequestDispatcher("/JhCountyStatDelete.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String fipsCode = req.getParameter("fipscode");
    if (fipsCode == null || fipsCode.trim().isEmpty()) {
      messages.put("title", "Invalid FipsCode");
      messages.put("disableSubmit", "true");
    } else {
      // Ensure fipsCode is a valid numeric
      try {
        int n = Integer.parseInt(fipsCode);
      } catch (NumberFormatException e) {
        messages.put("success", "Invalid FipsCode");
        req.getRequestDispatcher("/JhCountyStatDelete.jsp").forward(req, resp);
        return;
      }
      // Delete the BlogUser.
      JhCountyStat jhCountyStat = new JhCountyStat(fipsCode);
      try {
        jhCountyStat = jhCountyStatDao.delete(jhCountyStat);
        // Update the message.
        if (jhCountyStat == null) {
          messages.put("title", "Successfully deleted County: " + fipsCode);
          messages.put("disableSubmit", "true");
        } else {
          messages.put("title", "Failed to delete County: " + fipsCode);
          messages.put("disableSubmit", "false");
        }
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/JhCountyStatDelete.jsp").forward(req, resp);
  }
}
