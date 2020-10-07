package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import MOVD.model.SP500;


/**
 * An object that works with SP500 pojo in the data access layer.
 */
public class SP500Dao {
  protected ConnectionManager connectionManager;
  private static SP500Dao instance = null;

  protected SP500Dao() {
    connectionManager = new ConnectionManager();
  }

  /**
   * Creates an instance of the SP500Dao
   *
   * @return an instance of the SP500Dao
   */
  public static SP500Dao getInstance() {
    if (instance == null) {
      instance = new SP500Dao();
    }
    return instance;
  }


  /**
   * Save the SP500 instance by storing it in your MySQL instance. This runs a INSERT statement.
   */
  public SP500 create(SP500 sp500) throws SQLException {
    String insert = "INSERT INTO SP500 (Date, marketValue) VALUES (?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(insert);
      int i = 1;
      insertStmt.setTimestamp(i++, new Timestamp(sp500.getDate().getTime()));
      insertStmt.setFloat(i++, sp500.getMarketValue());
      insertStmt.executeUpdate();
      return sp500;
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
   * Returns the record from SP500 table in the database, corresponding to the given date.
   */
  public SP500 getSP500ByDate(Date date) throws SQLException {
    String readSP500 = "SELECT Date, marketValue FROM sp500 WHERE Date=?;";
    Connection connection = null;
    PreparedStatement readStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      readStmt = connection.prepareStatement(readSP500);
      results = readStmt.executeQuery();
      if (results.next()) {
        float marketValue = results.getFloat("marketValue");
        Date dateResult = new Date(results.getTimestamp("Date").getTime());
        SP500 sp500 = new SP500(dateResult, marketValue);
        return sp500;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (readStmt != null) {
        readStmt.close();
      }
    }
    return null;
  }

  /**
   * Update all fields of the sp500 instance.
   */
  public SP500 update(SP500 sp500) throws SQLException {
    String updateSP500 = "UPDATE SP500 SET marketValue=? WHERE Date=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateSP500);
      updateStmt.setFloat(1, sp500.getMarketValue());
      updateStmt.executeUpdate();
      return sp500;
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
   * Delete the SP500 object in the model and database.
   *
   * @param sp500 The reference to the object to be deleted.
   * @return null to the caller because the object is deleted.
   * @throws SQLException If there is an error with the SQL code.
   */
  public SP500 delete(SP500 sp500) throws SQLException {
    String deleteSP500 = "DELETE FROM SP500 WHERE Date=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteSP500);
      deleteStmt.setTimestamp(1, new Timestamp(sp500.getDate().getTime()));
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
