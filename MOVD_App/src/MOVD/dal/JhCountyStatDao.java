package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MOVD.model.*;

public class JhCountyStatDao {
  protected ConnectionManager connectionManager;

  private static JhCountyStatDao instance = null;

  protected JhCountyStatDao() {
    connectionManager = new ConnectionManager();
  }

  public static JhCountyStatDao getInstance() {
    if (instance == null) {
      instance = new JhCountyStatDao();
    }
    return instance;
  }

  /**
   * Create a record in the JHCountyStat MySQL table.
   */
  public JhCountyStat create(JhCountyStat jhCountyStat) throws SQLException {
    String insertJhCountyStat = "INSERT INTO jhcountystat(FipsCode, LastUpdate, State, " +
            "CountyName, CountyNameLong, " +
            "Latitude, Longitude, NCHSUrbanization, TotalPopulation)" +
            "VALUES(?,?,?,?,?,?,?,?,?)";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertJhCountyStat, Statement.RETURN_GENERATED_KEYS);

      int i = 1;
      insertStmt.setString(i++, jhCountyStat.getFipsCode());
      insertStmt.setString(i++, jhCountyStat.getLastUpdate());
      insertStmt.setString(i++, jhCountyStat.getState());
      insertStmt.setString(i++, jhCountyStat.getCountyName());
      insertStmt.setString(i++, jhCountyStat.getCountyNameLong());
      insertStmt.setString(i++, jhCountyStat.getLatitude());
      insertStmt.setString(i++, jhCountyStat.getLongitude());
      insertStmt.setString(i++, jhCountyStat.getNchsUrbanization());
      insertStmt.setString(i, jhCountyStat.getTotalPopulation());
      insertStmt.executeUpdate();

      return jhCountyStat;

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
   * UPdate a record in the JHCountyStat MySQL table using the values from a different pojo.
   */
  public JhCountyStat update(JhCountyStat jhCountyStat, JhCountyStat newValues) throws SQLException {
    String updateJhCountyStat = "UPDATE JhCountyStat " +
            "SET LastUpdate=?, State=?, CountyName=?, CountyNameLong=?, Latitude=?, Longitude=?, " +
            "NCHSUrbanization=?, TotalPopulation=? " +
            "WHERE FipsCode=?; ";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateJhCountyStat, Statement.RETURN_GENERATED_KEYS);

      int i = 1;
      updateStmt.setString(i++, newValues.getLastUpdate());
      updateStmt.setString(i++, newValues.getState());
      updateStmt.setString(i++, newValues.getCountyName());
      updateStmt.setString(i++, newValues.getCountyNameLong());
      updateStmt.setString(i++, newValues.getLatitude());
      updateStmt.setString(i++, newValues.getLongitude());
      updateStmt.setString(i++, newValues.getNchsUrbanization());
      updateStmt.setString(i++, newValues.getTotalPopulation());
      updateStmt.setString(i, jhCountyStat.getFipsCode());

      updateStmt.executeUpdate();

      newValues.setFipsCode(jhCountyStat.getFipsCode());
      return newValues;
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
   * Delete a record from the JHCountyStat MySQL table.
   */
  public JhCountyStat delete(JhCountyStat jhCountyStat) throws SQLException {
    String deleteJhCountyStat = "DELETE FROM JhCountyStat WHERE FipsCode=?";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteJhCountyStat);
      deleteStmt.setString(1, jhCountyStat.getFipsCode());
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

  /**
   * Return a record from the JHCountyStat MySQL table by FipsCode.
   */
  public JhCountyStat getFromFipsCode(String fipsCode) throws SQLException {
    JhCountyStat newJhCountyStat = null;
    String queryJhCountyStat = "SELECT FipsCode, LastUpdate, State, CountyName, CountyNameLong, " +
            "Latitude, Longitude, NCHSUrbanization, TotalPopulation " +
            "FROM movd.JhCountyStat " +
            "WHERE FipsCode=?";
    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      queryStmt = connection.prepareStatement(queryJhCountyStat);
      queryStmt.setString(1, fipsCode);
      results = queryStmt.executeQuery();
      while (results.next()) {
        String lastUpdate = results.getString("LastUpdate");
        String state = results.getString("State");
        String countyName = results.getString("CountyName");
        String countyNameLong = results.getString("CountyNameLong");
        String latitude = results.getString("Latitude");
        String longitude = results.getString("Longitude");
        String nchsUrbanization = results.getString("NCHSUrbanization");
        String totalPopulation = results.getString("TotalPopulation");

        newJhCountyStat = new JhCountyStat(fipsCode, lastUpdate, state, countyName,
                countyNameLong, latitude, longitude, nchsUrbanization, totalPopulation);
      }
      return newJhCountyStat;


    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (queryStmt != null) {
        queryStmt.close();
      }
    }
  }

  /**
   * Return a list record from the JHCountyStat MySQL table by date.
   */
  public List<JhCountyStat> getJhCountyStatsFromState(String state)
          throws SQLException {
    List<JhCountyStat> jhCountyStats = new ArrayList<JhCountyStat>();
    String selectJhCountyStat =
            "SELECT FipsCode, LastUpdate, State, CountyName, CountyNameLong, Latitude, " +
                    "Longitude, NCHSUrbanization, " +
                    "TotalPopulation " +
                    "FROM jhcountystat " +
                    "WHERE State=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectJhCountyStat);
      selectStmt.setString(1, state);
      results = selectStmt.executeQuery();
      while (results.next()) {
        String fipsCode = results.getString("FipsCode");
        String lastUpdate = results.getString("LastUpdate");
        String result_state = results.getString("State");
        String countyName = results.getString("CountyName");
        String countyNameLong = results.getString("CountyNameLong");
        String latitude = results.getString("Latitude");
        String longitude = results.getString("Longitude");
        String nchsUrbanization = results.getString("NCHSUrbanization");
        String totalPopulation = results.getString("TotalPopulation");
        JhCountyStat jhCountyStat = new JhCountyStat(fipsCode, lastUpdate, result_state, countyName,
                countyNameLong, latitude, longitude, nchsUrbanization, totalPopulation);
        jhCountyStats.add(jhCountyStat);
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
    return jhCountyStats;
  }

}
