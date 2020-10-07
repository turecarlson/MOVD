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

import MOVD.dal.LegislatorsDao;
import MOVD.model.Legislators;


/**
 * Servlet to update a Legislators record.
 */
@WebServlet("/legislatorsupdate")
public class LegislatorsUpdate extends HttpServlet {

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
    String legislatorsPK = req.getParameter("LegislatorsKey");
    if (legislatorsPK == null || legislatorsPK.trim().isEmpty()) {
      messages.put("success", "Please enter a valid ID.");
    } else {
      String lastName = req.getParameter("LastName");
      String firstName = req.getParameter("FirstName");
      String middleName = req.getParameter("MiddleName");
      String suffix = req.getParameter("Suffix");
      String nickname = req.getParameter("NickName");
      String fullName = req.getParameter("FullName");
      String gender = req.getParameter("Gender");
      String state = req.getParameter("State");
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
      if (state == null || state.isEmpty()) {
        messages.put("success", "You must enter a valid State.");

      } else {
        Legislators legislator = new Legislators(lastName, firstName, middleName, suffix,
                nickname, fullName, birthday, gender, type, state, district,
                senateClass, party);
        req.setAttribute("legislator", legislator);
      }
    }

    req.getRequestDispatcher("/LegislatorsUpdate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve user and validate.
    String legislatorsPK = req.getParameter("LegislatorsKey");
    if (legislatorsPK == null || legislatorsPK.trim().isEmpty()) {
      messages.put("success", "Please enter a valid ID.");
    } else {
      String lastName = req.getParameter("LastName");
      String firstName = req.getParameter("FirstName");
      String middleName = req.getParameter("MiddleName");
      String suffix = req.getParameter("Suffix");
      String nickname = req.getParameter("NickName");
      String fullName = req.getParameter("FullName");
      String gender = req.getParameter("Gender");
      String state = req.getParameter("State");
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
      if (state == null || state.isEmpty()) {
        messages.put("success", "You must enter a valid State.");

      } else {
        long legislatorsKey = Long.parseLong(legislatorsPK);
        Legislators legislator = new Legislators(lastName, firstName, middleName, suffix,
                nickname, fullName, birthday, gender, type, state, district,
                senateClass, party);
        try {
          legislator = legislatorsDao.updateLegislator(legislatorsKey, legislator);
          if (legislator == null) {
            messages.put("success", "Legislator does not exist.");
          } else {
            messages.put("success", "Successfully updated Legislator with Id: " + legislatorsPK);
          }
          req.setAttribute("legislator", legislator);
        } catch (SQLException e) {
          e.printStackTrace();
          throw new IOException(e);
        }
      }

    }

    req.getRequestDispatcher("/LegislatorsUpdate.jsp").forward(req, resp);
  }

}
