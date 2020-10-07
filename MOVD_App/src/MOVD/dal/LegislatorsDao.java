package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import MOVD.model.Legislators;

public class LegislatorsDao {
  protected ConnectionManager connectionManager;

  private static LegislatorsDao instance = null;

  protected LegislatorsDao() {
    connectionManager = new ConnectionManager();
  }

  public static LegislatorsDao getInstance() {
    if (instance == null) {
      instance = new LegislatorsDao();
    }
    return instance;
  }

  /**
   * Create a record in the Legislators MySQL table.
   */
  public Legislators create(Legislators legislator) throws SQLException {
    String insertLegislators = "INSERT INTO legislators(LastName, FirstName, MiddleName, Suffix, " +
            "Nickname, FullName, Birthday, "
            + "Gender, Type, State, District, Senate_class, Party) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertLegislators, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, legislator.getLastName());
      insertStmt.setString(2, legislator.getFirstName());
      insertStmt.setString(3, legislator.getMiddleName());
      insertStmt.setString(4, legislator.getSuffix());
      insertStmt.setString(5, legislator.getNickname());
      insertStmt.setString(6, legislator.getFullName());
      insertStmt.setTimestamp(7, new Timestamp(legislator.getBirthday().getTime()));
      insertStmt.setString(8, legislator.getGender());
      insertStmt.setString(9, legislator.getType());
      insertStmt.setString(10, legislator.getState());
      insertStmt.setString(11, legislator.getDistrict());
      insertStmt.setString(12, legislator.getSenateClass());
      insertStmt.setString(13, legislator.getParty());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int legislatorsPK = -1;
      if (resultKey.next()) {
        legislatorsPK = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      legislator.setLegislatorsKey(legislatorsPK);
      return legislator;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  /**
   * Return a list of records from the Legislators MySQL table.
   */
  public List<Legislators> getLegislatorByState(String state) throws SQLException {
    List<Legislators> legislators = new ArrayList<Legislators>();
    String selectLegislator = "SELECT Legislators.LastName, Legislators.FirstName, Legislators.MiddleName, Legislators.Suffix, Legislators.Nickname, Legislators.FullName, Legislators.Birthday, "
            + "Legislators.Gender, Legislators.Type, Legislators.State, Legislators.District, Legislators.Senate_class, Legislators.Party FROM Legislators "
            + " JOIN State on State.StateName = Legislators.State "
            + "WHERE State =?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectLegislator);
      selectStmt.setString(1, state);
      results = selectStmt.executeQuery();
      while (results.next()) {
        String resultState = results.getString("State");
        String lastName = results.getString("LastName");
        String firstName = results.getString("FirstName");
        String middleName = results.getString("MiddleName");
        String suffix = results.getString("Suffix");
        String nickname = results.getString("Nickname");
        String fullName = results.getString("FullName");
        Date birthday = new Date(results.getTimestamp("Birthday").getTime());
        String gender = results.getString("Gender");
        String type = results.getString("Type");
        String district = results.getString("District");
        String senateClass = results.getString("Senate_class");
        String party = results.getString("Party");
        Legislators legislator = new Legislators(lastName, firstName, middleName, suffix, nickname,
                fullName, birthday, gender, type, resultState, district, senateClass, party);
        legislators.add(legislator);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return legislators;
  }


  /**
   * Update a Legislator record in the MySQL table with the values from a new pojo.
   */
  public Legislators updateLegislator(long legislatorPK, Legislators newLegislator) throws SQLException {
    String updateLegislator = "UPDATE legislators SET LastName=?, FirstName=?, MiddleName=?, Suffix=?, Nickname=?, FullName=?, Birthday=?, "
            + "Gender=?, Type=?, State=?, District=?, Senate_class=?, Party=? WHERE LegislatorsKey=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateLegislator);
      updateStmt.setString(1, newLegislator.getLastName());
      updateStmt.setString(2, newLegislator.getFirstName());
      updateStmt.setString(3, newLegislator.getMiddleName());
      updateStmt.setString(4, newLegislator.getSuffix());
      updateStmt.setString(5, newLegislator.getNickname());
      updateStmt.setString(6, newLegislator.getFullName());
      updateStmt.setTimestamp(7, new Timestamp(newLegislator.getBirthday().getTime()));
      updateStmt.setString(8, newLegislator.getGender());
      updateStmt.setString(9, newLegislator.getType());
      updateStmt.setString(10, newLegislator.getState());
      updateStmt.setString(11, newLegislator.getDistrict());
      updateStmt.setString(12, newLegislator.getSenateClass());
      updateStmt.setString(13, newLegislator.getParty());
      updateStmt.setLong(14, legislatorPK);
      updateStmt.executeUpdate();
      newLegislator.setLegislatorsKey(legislatorPK);
      return newLegislator;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  /**
   * Delete a legislator from the MySql table.
   */
  public Legislators delete(Legislators legislator) throws SQLException {
    String deleteLegislators = "DELETE FROM legislators WHERE LegislatorsKey=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteLegislators);
      deleteStmt.setLong(1, legislator.getLegislatorsKey());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}
