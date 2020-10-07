package MOVD.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MOVD.model.GoogleMobilityData;

public class GoogleMobilityDataDao {

  protected ConnectionManager connectionManager;
  private static GoogleMobilityDataDao instance = null;

  protected GoogleMobilityDataDao() {
    connectionManager = new ConnectionManager();
  }

  public static GoogleMobilityDataDao getInstance() {
    if (instance == null) {
      instance = new GoogleMobilityDataDao();
    }
    return instance;
  }

  /**
   * Save the GoogleMobilityData instance by storing it in your MySQL instance. This runs a INSERT
   * statement.
   */
  public GoogleMobilityData create(GoogleMobilityData googleMobilityData) throws SQLException {

    String insert = "INSERT INTO GoogleMobilityData(Date,Country,Rec," +
            "Grocery,Parks,Transit_Station,Work,Residential,JHCountyStat_FipsCode) VALUES(?,?," +
            "?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(insert,
              Statement.RETURN_GENERATED_KEYS);
      int i = 1;
      insertStmt.setDate(i++, googleMobilityData.getDate());
      insertStmt.setString(i++, googleMobilityData.getCountry());
      insertStmt.setLong(i++, googleMobilityData.getRec());
      insertStmt.setLong(i++, googleMobilityData.getGrocery());
      insertStmt.setLong(i++, googleMobilityData.getParks());
      insertStmt.setLong(i++, googleMobilityData.getTransitStation());
      insertStmt.setLong(i++, googleMobilityData.getWork());
      insertStmt.setLong(i++, googleMobilityData.getResidential());
      insertStmt.setString(i++, googleMobilityData.getJhCountyStatFipsCode());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int Id = -1;
      if (resultKey.next()) {
        Id = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      googleMobilityData.setSyntheticMobilityPk(Id);
      return googleMobilityData;
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
   * Update the LastName of the GoogleMobilityData instance. This runs a UPDATE statement. "UPDATE
   * GoogleMobilityData SET LastName=? WHERE UserName=?;"
   */

  public GoogleMobilityData update(GoogleMobilityData old, GoogleMobilityData updated) throws SQLException {

    String update = "Update GoogleMobilityData SET Date=?, Country=?, Rec=?, " +
            " Grocery=?, Parks=?, Transit_Station=?, Work=?, Residential=?, " +
            " JHCountyStat_FipsCode=? WHERE Synthetic_Mobility_PK=?";

    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(update);

      int i = 1;
      insertStmt.setDate(i++, updated.getDate());
      insertStmt.setString(i++, updated.getCountry());
      insertStmt.setLong(i++, updated.getRec());
      insertStmt.setLong(i++, updated.getGrocery());
      insertStmt.setLong(i++, updated.getParks());
      insertStmt.setLong(i++, updated.getTransitStation());
      insertStmt.setLong(i++, updated.getWork());
      insertStmt.setLong(i++, updated.getResidential());
      insertStmt.setString(i++, updated.getJhCountyStatFipsCode());
      insertStmt.setLong(i++, old.getSyntheticMobilityPk());
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
   * Delete the mobility data object in the model and database.
   *
   * @param googleMobilityData The reference to the object to be deleted.
   * @return null to the caller because the object is deleted.
   * @throws SQLException If there is an error with the SQL code.
   */
  public GoogleMobilityData delete(GoogleMobilityData googleMobilityData) throws SQLException {

    String insert = "DELETE FROM GoogleMobilityData WHERE Synthetic_Mobility_PK=?;";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert);
      insertStmt.setLong(1, googleMobilityData.getSyntheticMobilityPk());
      insertStmt.executeUpdate();

      //Allow the data to be garbage collected
      googleMobilityData = null;
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

  /**
   * Return a record by primary key.
   */
  public GoogleMobilityData getRecordByKey(Long pk) throws SQLException {

    String select = "SELECT * FROM GoogleMobilityData WHERE Synthetic_Mobility_PK=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(select);
      selectStmt.setLong(1, pk);
      results = selectStmt.executeQuery();
      if (results.next()) {
        Date date = results.getDate("Date");
        String country = results.getString("Country");
        Long rec = results.getLong("Rec");
        Long grocery = results.getLong("Grocery");
        Long parks = results.getLong("Parks");
        Long transit = results.getLong("Transit_Station");
        Long work = results.getLong("Work");
        Long residential = results.getLong("Residential");
        String fips = results.getString("JHCountyStat_FipsCode");

        GoogleMobilityData record = new GoogleMobilityData(date, country, rec, grocery, parks, transit, work, residential, fips);
        return record;
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
    return null;
  }

  /**
   * Return a list of records by fipscode.
   */
  public List<GoogleMobilityData> getDataByFipsCode(String fipscode) throws SQLException {

    List<GoogleMobilityData> records = new ArrayList<GoogleMobilityData>();

    String select = "SELECT * FROM GoogleMobilityData WHERE JHCountyStat_FipsCode=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(select);
      selectStmt.setString(1, fipscode);
      results = selectStmt.executeQuery();
      while (results.next()) {
        Long pk = results.getLong("Synthetic_Mobility_PK");
        Date date = results.getDate("Date");
        String country = results.getString("Country");
        Long rec = results.getLong("Rec");
        Long grocery = results.getLong("Grocery");
        Long parks = results.getLong("Parks");
        Long transit = results.getLong("Transit_Station");
        Long work = results.getLong("Work");
        Long residential = results.getLong("Residential");
        String fips = results.getString("JHCountyStat_FipsCode");

        GoogleMobilityData record = new GoogleMobilityData(pk, date, country, rec, grocery, parks, transit, work, residential, fips);
        records.add(record);
      }
      return records;
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
  }
}



