package MOVD.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet to create a Legislators record.
 */
@WebServlet("/legislatorscreate")
public class LegislatorsCreate extends HttpServlet {

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
    req.getRequestDispatcher("/LegislatorsCreate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    String state = req.getParameter("State");
    if (state == null || state.trim().isEmpty()) {
      messages.put("success", "Invalid Legislator, must have a State.");
    } else {
      // Create the Legislator
      String lastName = req.getParameter("LastName");
      String firstName = req.getParameter("FirstName");
      String middleName = req.getParameter("MiddleName");
      String suffix = req.getParameter("Suffix");
      String nickname = req.getParameter("NickName");
      String fullName = req.getParameter("FullName");
      String gender = req.getParameter("Gender");
      String type = req.getParameter("Type");
      String district = req.getParameter("District");
      String senateClass = req.getParameter("SenateClass");
      String party = req.getParameter("Party");
      DateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
      String stringBirthday = req.getParameter("Birthday");
      Date birthday = new Date();
      try {
        birthday = birthdayFormat.parse(stringBirthday);
      } catch (ParseException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      try {
        Legislators legislator = new Legislators(lastName, firstName, middleName, suffix,
                nickname, fullName, birthday, gender, type, state, district,
                senateClass, party);
        legislator = legislatorsDao.create(legislator);
        messages.put("success", "Successfully created " + fullName);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/LegislatorsCreate.jsp").forward(req, resp);
  }


}
