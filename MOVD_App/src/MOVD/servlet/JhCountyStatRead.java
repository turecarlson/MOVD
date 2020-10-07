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

import MOVD.dal.*;
import MOVD.model.*;

/**
 * Servlet to Find a JhCountyStat record.
 */
@WebServlet("/jhcountystatread")
public class JhCountyStatRead extends HttpServlet {
  protected JhCountyStatDao jhCountyStatDao;

  @Override
  public void init() throws ServletException {
    jhCountyStatDao = JhCountyStatDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<JhCountyStat> jhCountyStat = new ArrayList<JhCountyStat>();

    String state = req.getParameter("State");
    if (state == null || state.trim().isEmpty()) {
      messages.put("success", "Please enter a valid state's name.");
    } else {
      try {
        jhCountyStat = jhCountyStatDao.getJhCountyStatsFromState(state);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for " + state);
      messages.put("previousState", state);
    }
    req.setAttribute("JhCountyStat", jhCountyStat);
    req.getRequestDispatcher("/JhCountyStatRead.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<JhCountyStat> jhCountyStat = new ArrayList<JhCountyStat>();

    String state = req.getParameter("State");
    if (state == null || state.trim().isEmpty()) {
      messages.put("success", "Invalid State.");
    } else {
      try {
        jhCountyStat = jhCountyStatDao.getJhCountyStatsFromState(state);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for " + state);
    }
    req.setAttribute("JhCountyStat", jhCountyStat);
    req.getRequestDispatcher("/JhCountyStatRead.jsp").forward(req, resp);
  }
}
