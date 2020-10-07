package MOVD.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import MOVD.model.UnemploymentStat;

/**
 * An object that works with UnemploymentStat pojo in the data access layer.
 */
public class UnemploymentStatDao {

  protected ConnectionManager connectionManager;
  private static UnemploymentStatDao instance = null;

  protected UnemploymentStatDao() {
    connectionManager = new ConnectionManager();
  }

  /**
   * Creates an instance of the UnemploymentStatDao
   *
   * @return an instance of the UnemploymentStatDao
   */
  public static UnemploymentStatDao getInstance() {
    if (instance == null) {
      instance = new UnemploymentStatDao();
    }
    return instance;
  }

  /**
   * Save the UnemploymentStat instance by storing it in your MySQL instance. This runs a INSERT
   * statement.
   */
  public UnemploymentStat create(UnemploymentStat unemploymentStat) throws SQLException {

    String insert = "INSERT INTO UnemploymentStat" +
            "(FipsCode," +
            "Period," +
            "LaborForce," +
            "Employed," +
            "Unemployed," +
            "UnemploymentRatePercentage) VALUES(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(insert,
              Statement.RETURN_GENERATED_KEYS);
      int i = 1;
      insertStmt.setString(i++, unemploymentStat.getFipsCode());
      insertStmt.setDate(i++, unemploymentStat.getPeriod());
      insertStmt.setLong(i++, unemploymentStat.getLaborForce());
      insertStmt.setLong(i++, unemploymentStat.getEmployed());
      insertStmt.setLong(i++, unemploymentStat.getUnemployed());
      insertStmt.setDouble(i++, unemploymentStat.getUnemploymentRatePercentage());

      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int Id = -1;
      if (resultKey.next()) {
        Id = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      unemploymentStat.setUnemploymentPk(Id);
      return unemploymentStat;
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
      if (resultKey != null) {
        resultKey.close();
      }

    }
  }

  /**
   * Get a list of UnemploymentStats by period
   */
  public List<UnemploymentStat> getUnemploymentByPeriod(Date period) throws SQLException {
    List<UnemploymentStat> unemploymentList = new ArrayList<UnemploymentStat>();
    String selectUnemployment = "SELECT UnemploymentStat.FipsCode, UnemploymentStat.Period, UnemploymentStat.LaborForce, UnemploymentStat.Employed, "
            + "UnemploymentStat.Unemployed, UnemploymentStat.UnemploymentRatePercentage "
            + "FROM UnemploymentStat "
            + "WHERE Period=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUnemployment);
      selectStmt.setTimestamp(1, new Timestamp(period.getTime()));
      results = selectStmt.executeQuery();
      while (results.next()) {
        long unemploymentPk = results.getLong("UnemploymentPk");
        String fipsCode = results.getString("FipsCode");
        Date resultPeriod = new Date(results.getTimestamp("Period").getTime());
        long laborForce = results.getLong("LaborForce");
        long employed = results.getLong("Employed");
        long unemployed = results.getLong("Unemployed");
        double unemploymentRatePercentage = results.getDouble("UnemploymentRatePercentage");


        UnemploymentStat unemployment = new UnemploymentStat(unemploymentPk, fipsCode, resultPeriod, laborForce, employed, unemployed, unemploymentRatePercentage);
        unemploymentList.add(unemployment);
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
    return unemploymentList;
  }


  /**
   * Update all fields of the unemploymentstat instance.
   */

  public UnemploymentStat update(UnemploymentStat old, UnemploymentStat updated) throws SQLException {

    String update = "Update UnemploymentStat SET FipsCode=?, Period=?, LaborForce=?, " +
            " Employed=?, Unemployed=?, UnemploymentRatePercentage=?";

    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(update);

      int i = 1;
      insertStmt.setString(i++, updated.getFipsCode());
      insertStmt.setDate(i++, updated.getPeriod());
      insertStmt.setLong(i++, updated.getLaborForce());
      insertStmt.setLong(i++, updated.getEmployed());
      insertStmt.setLong(i++, updated.getUnemployed());
      insertStmt.setDouble(i++, updated.getUnemploymentRatePercentage());

      insertStmt.executeUpdate();

      old = null;

      return updated;
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
   * Delete the UnemploymentStat object in the model and database.
   *
   * @param unemploymentStat The reference to the object to be deleted.
   * @return null to the caller because the object is deleted.
   * @throws SQLException If there is an error with the SQL code.
   */
  public UnemploymentStat delete(UnemploymentStat unemploymentStat) throws SQLException {

    String insert = "DELETE FROM UnemploymentStat WHERE UnemploymentPK=?;";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert);
      insertStmt.setLong(1, unemploymentStat.getUnemploymentPk());
      insertStmt.executeUpdate();

      //Allow the data to be garbage collected
      unemploymentStat = null;
      return null;

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

}



