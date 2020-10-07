package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MOVD.model.Hospitals20;

public class Hospitals20Dao {

  protected ConnectionManager connectionManager;

  private static Hospitals20Dao instance = null;

  protected Hospitals20Dao() {
    connectionManager = new ConnectionManager();
  }

  public static Hospitals20Dao getInstance() {
    if (instance == null) {
      instance = new Hospitals20Dao();
    }
    return instance;
  }

  /**
   * Add a record into the hospitals20 MySQL table.
   */
  public Hospitals20 create(Hospitals20 hospital20) throws SQLException {
    String insertHospitals20 = "INSERT INTO hospitals20(State, TotalHospitalBeds, TotalICUBeds, "
            + "HospitalBedOccupancyRate, ICUBedOccupancyRate, AvailableHospitalBeds, "
            + "PotentiallyAvailableHospitalBeds, AvailableICUBeds, PotentiallyAvailableICUBeds, "
            + "AdultPopulation, PopulationOver65, ProjectedInfectedIndividuals, "
            + "ProjectedHospitalizedIndividuals, ProjectedIndividualsNeedingICUCare, "
            + "HospitalBedsNeeded6Months, PctAvailableBedsNeeded6Months, "
            + "PctPotentiallyAvailableBedsNeeded6Months, PctTotalBedsNeeded6Months, "
            + "HospitalBedsNeeded12Months, PctAvailableBedsNeeded12Months, "
            + "PctPotentiallyAvailableBedsNeeded12Months, PctTotalBedsNeeded12Months, "
            + "HospitalBedsNeeded18Months, PctAvailableBedsNeeded18Months, "
            + "PctPotentiallyAvailableBedsNeeded18Months, PctTotalBedsNeeded18Months, ICUBedsNeeded6Months, "
            + "PctAvailableICUBedsNeeded6Months, PctPotentiallyAvailableICUBedsNeeded6Months, "
            + "PctTotalICUBedsNeeded6Months, ICUBedsNeeded12Months, PctAvailableICUBedsNeeded12Months, "
            + "PctPotentiallyAvailableICUBedsNeeded12Months, PctTotalICUBedsNeeded12Months, "
            + "ICUBedsNeeded18Months, PctAvailableICUBedsNeeded18Months, "
            + "PctPotentiallyAvailableICUBedsNeeded18Months, PctTotalICUBedsNeeded18Months) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertHospitals20, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, hospital20.getState());
      insertStmt.setLong(2, hospital20.getTotalHospitalBeds());
      insertStmt.setLong(3, hospital20.getTotalIcuBeds());
      insertStmt.setDouble(4, hospital20.getHospitalBedOccupancyRate());
      insertStmt.setDouble(5, hospital20.getIcuBedOccupancyRate());
      insertStmt.setLong(6, hospital20.getAvailableHospitalBeds());
      insertStmt.setLong(7, hospital20.getPotentiallyAvailableHospitalBeds());
      insertStmt.setLong(8, hospital20.getAvailableIcuBeds());
      insertStmt.setLong(9, hospital20.getPotentiallyAvailableIcuBeds());
      insertStmt.setLong(10, hospital20.getAdultPopulation());
      insertStmt.setLong(11, hospital20.getPopulationOver65());
      insertStmt.setLong(12, hospital20.getProjectedInfectedIndividuals());
      insertStmt.setLong(13, hospital20.getProjectedHospitalizedIndividuals());
      insertStmt.setLong(14, hospital20.getProjectedIndividualsNeedingIcuCare());
      insertStmt.setLong(15, hospital20.getHospitalBedsNeeded6Months());
      insertStmt.setLong(16, hospital20.getPctAvailableBedsNeeded6Months());
      insertStmt.setLong(17, hospital20.getPctPotentiallyAvailableBedsNeeded6Months());
      insertStmt.setLong(18, hospital20.getPctTotalBedsNeeded6Months());
      insertStmt.setLong(19, hospital20.getHospitalBedsNeeded12Months());
      insertStmt.setLong(20, hospital20.getPctAvailableBedsNeeded12Months());
      insertStmt.setLong(21, hospital20.getPctPotentiallyAvailableBedsNeeded12Months());
      insertStmt.setLong(22, hospital20.getPctTotalBedsNeeded12Months());
      insertStmt.setLong(23, hospital20.getHospitalBedsNeeded18Months());
      insertStmt.setLong(24, hospital20.getPctAvailableBedsNeeded18Months());
      insertStmt.setLong(25, hospital20.getPctPotentiallyAvailableBedsNeeded18Months());
      insertStmt.setLong(26, hospital20.getPctTotalBedsNeeded18Months());
      insertStmt.setLong(27, hospital20.getIcuBedsNeeded6Months());
      insertStmt.setLong(28, hospital20.getPctAvailableIcuBedsNeeded6Months());
      insertStmt.setLong(29, hospital20.getPctPotentiallyAvailableIcuBedsNeeded6Months());
      insertStmt.setLong(30, hospital20.getPctTotalIcuBedsNeeded6Months());
      insertStmt.setLong(31, hospital20.getIcuBedsNeeded12Months());
      insertStmt.setLong(32, hospital20.getPctAvailableIcuBedsNeeded12Months());
      insertStmt.setLong(33, hospital20.getPctPotentiallyAvailableIcuBedsNeeded12Months());
      insertStmt.setLong(34, hospital20.getPctTotalIcuBedsNeeded12Months());
      insertStmt.setLong(35, hospital20.getIcuBedsNeeded18Months());
      insertStmt.setLong(36, hospital20.getPctAvailableIcuBedsNeeded18Months());
      insertStmt.setLong(37, hospital20.getPctPotentiallyAvailableIcuBedsNeeded18Months());
      insertStmt.setLong(38, hospital20.getPctTotalIcuBedsNeeded18Months());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int hospitals20Pk = -1;
      if (resultKey.next()) {
        hospitals20Pk = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      hospital20.setHospitals20Pk(hospitals20Pk);
      return hospital20;
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
   * Retreive a record by primary key.
   */
  public Hospitals20 getRecordByPK(int pk) throws SQLException {
    String select = "SELECT * FROM hospitals20 WHERE Hospitals20_PK=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(select);
      selectStmt.setInt(1, pk);
      results = selectStmt.executeQuery();
      if (results.next()) {
        long hospitals20Pk = results.getLong("Hospitals20_PK");
        String state = results.getString("State");
        long totalHospitalBeds = results.getLong("TotalHospitalBeds");
        long totalIcuBeds = results.getLong("TotalICUBeds");
        double hospitalBedOccupancyRate = results.getDouble("HospitalBedOccupancyRate");
        double icuBedOccupancyRate = results.getDouble("ICUBedOccupancyRate");
        long availableHospitalBeds = results.getLong("AvailableHospitalBeds");
        long potentiallyAvailableHospitalBeds = results.getLong("PotentiallyAvailableHospitalBeds");
        long availableIcuBeds = results.getLong("AvailableICUBeds");
        long potentiallyAvailableIcuBeds = results.getLong("PotentiallyAvailableICUBeds");
        long adultPopulation = results.getLong("AdultPopulation");
        long populationOver65 = results.getLong("PopulationOver65");
        long projectedInfectedIndividuals = results.getLong("ProjectedInfectedIndividuals");
        long projectedHospitalizedIndividuals = results.getLong("ProjectedHospitalizedIndividuals");
        long projectedIndividualsNeedingIcuCare = results.getLong("ProjectedIndividualsNeedingICUCare");
        long hospitalBedsNeeded6Months = results.getLong("HospitalBedsNeeded6Months");
        long pctAvailableBedsNeeded6Months = results.getLong("PctAvailableBedsNeeded6Months");
        long pctPotentiallyAvailableBedsNeeded6Months = results.getLong("PctPotentiallyAvailableBedsNeeded6Months");
        long pctTotalBedsNeeded6Months = results.getLong("PctTotalBedsNeeded6Months");
        long hospitalBedsNeeded12Months = results.getLong("HospitalBedsNeeded12Months");
        long pctAvailableBedsNeeded12Months = results.getLong("PctAvailableBedsNeeded12Months");
        long pctPotentiallyAvailableBedsNeeded12Months = results.getLong("PctPotentiallyAvailableBedsNeeded12Months");
        long pctTotalBedsNeeded12Months = results.getLong("PctTotalBedsNeeded12Months");
        long hospitalBedsNeeded18Months = results.getLong("HospitalBedsNeeded18Months");
        long pctAvailableBedsNeeded18Months = results.getLong("PctAvailableBedsNeeded18Months");
        long pctPotentiallyAvailableBedsNeeded18Months = results.getLong("PctPotentiallyAvailableBedsNeeded18Months");
        long pctTotalBedsNeeded18Months = results.getLong("PctTotalBedsNeeded18Months");
        long icuBedsNeeded6Months = results.getLong("ICUBedsNeeded6Months");
        long pctAvailableIcuBedsNeeded6Months = results.getLong("PctAvailableICUBedsNeeded6Months");
        long pctPotentiallyAvailableIcuBedsNeeded6Months = results.getLong("PctPotentiallyAvailableICUBedsNeeded6Months");
        long pctTotalIcuBedsNeeded6Months = results.getLong("PctTotalICUBedsNeeded6Months");
        long icuBedsNeeded12Months = results.getLong("ICUBedsNeeded12Months");
        long pctAvailableIcuBedsNeeded12Months = results.getLong("PctAvailableICUBedsNeeded12Months");
        long pctPotentiallyAvailableIcuBedsNeeded12Months = results.getLong("PctPotentiallyAvailableICUBedsNeeded12Months");
        long pctTotalIcuBedsNeeded12Months = results.getLong("PctTotalICUBedsNeeded12Months");
        long icuBedsNeeded18Months = results.getLong("ICUBedsNeeded18Months");
        long pctAvailableIcuBedsNeeded18Months = results.getLong("PctAvailableICUBedsNeeded18Months");
        long pctPotentiallyAvailableIcuBedsNeeded18Months = results.getLong("PctPotentiallyAvailableICUBedsNeeded18Months");
        long pctTotalIcuBedsNeeded18Months = results.getLong("PctTotalICUBedsNeeded18Months");


        Hospitals20 record = new Hospitals20(hospitals20Pk, state, totalHospitalBeds, totalIcuBeds,
                hospitalBedOccupancyRate, icuBedOccupancyRate, availableHospitalBeds,
                potentiallyAvailableHospitalBeds, availableIcuBeds, potentiallyAvailableIcuBeds,
                adultPopulation, populationOver65, projectedInfectedIndividuals,
                projectedHospitalizedIndividuals, projectedIndividualsNeedingIcuCare,
                hospitalBedsNeeded6Months, pctAvailableBedsNeeded6Months,
                pctPotentiallyAvailableBedsNeeded6Months, pctTotalBedsNeeded6Months,
                hospitalBedsNeeded12Months, pctAvailableBedsNeeded12Months,
                pctPotentiallyAvailableBedsNeeded12Months, pctTotalBedsNeeded12Months,
                hospitalBedsNeeded18Months, pctAvailableBedsNeeded18Months,
                pctPotentiallyAvailableBedsNeeded18Months, pctTotalBedsNeeded18Months, icuBedsNeeded6Months,
                pctAvailableIcuBedsNeeded6Months, pctPotentiallyAvailableIcuBedsNeeded6Months,
                pctTotalIcuBedsNeeded6Months, icuBedsNeeded12Months, pctAvailableIcuBedsNeeded12Months,
                pctPotentiallyAvailableIcuBedsNeeded12Months, pctTotalIcuBedsNeeded12Months,
                icuBedsNeeded18Months, pctAvailableIcuBedsNeeded18Months,
                pctPotentiallyAvailableIcuBedsNeeded18Months, pctTotalIcuBedsNeeded18Months);

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
   * Update a record in the hospitals20 MySQL table with values from a different pojo.
   */
  public Hospitals20 updateHospitals20(Hospitals20 originalHospital20, Hospitals20 updateHospital20) throws SQLException {
    String updateHospital20SQL = "UPDATE hospitals20 SET State=?, TotalHospitalBeds=?, TotalICUBeds=?, "
            + "HospitalBedOccupancyRate=?, ICUBedOccupancyRate=?=?, AvailableHospitalBeds=?=?, "
            + "PotentiallyAvailableHospitalBeds=?, AvailableICUBeds=?, PotentiallyAvailableICUBeds=?, "
            + "AdultPopulation=?, PopulationOver65=?, ProjectedInfectedIndividuals=?, "
            + "ProjectedHospitalizedIndividuals=?, ProjectedIndividualsNeedingICUCare=?, "
            + "HospitalBedsNeeded6Months=?, PctAvailableBedsNeeded6Months=?, "
            + "PctPotentiallyAvailableBedsNeeded6Months=?, PctTotalBedsNeeded6Months=?, "
            + "HospitalBedsNeeded12Months=?, PctAvailableBedsNeeded12Months=?, "
            + "PctPotentiallyAvailableBedsNeeded12Months=?, PctTotalBedsNeeded12Months=?, "
            + "HospitalBedsNeeded18Months=?, PctAvailableBedsNeeded18Months=?, "
            + "PctPotentiallyAvailableBedsNeeded18Months=?, PctTotalBedsNeeded18Months=?, ICUBedsNeeded6Months=?, "
            + "PctAvailableICUBedsNeeded6Months=?, PctPotentiallyAvailableICUBedsNeeded6Months=?, "
            + "PctTotalICUBedsNeeded6Months=?, ICUBedsNeeded12Months=?, PctAvailableICUBedsNeeded12Months=?, "
            + "PctPotentiallyAvailableICUBedsNeeded12Months=?, PctTotalICUBedsNeeded12Months=?, "
            + "ICUBedsNeeded18Months=?, PctAvailableICUBedsNeeded18Months=?, "
            + "PctPotentiallyAvailableICUBedsNeeded18Months=?, PctTotalICUBedsNeeded18Months=? WHERE Hospitals20_PK=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateHospital20SQL);
      updateStmt.setString(1, updateHospital20.getState());
      updateStmt.setLong(2, updateHospital20.getTotalHospitalBeds());
      updateStmt.setLong(3, updateHospital20.getTotalIcuBeds());
      updateStmt.setDouble(4, updateHospital20.getHospitalBedOccupancyRate());
      updateStmt.setDouble(5, updateHospital20.getIcuBedOccupancyRate());
      updateStmt.setLong(6, updateHospital20.getAvailableHospitalBeds());
      updateStmt.setLong(7, updateHospital20.getPotentiallyAvailableHospitalBeds());
      updateStmt.setLong(8, updateHospital20.getAvailableIcuBeds());
      updateStmt.setLong(9, updateHospital20.getPotentiallyAvailableIcuBeds());
      updateStmt.setLong(10, updateHospital20.getAdultPopulation());
      updateStmt.setLong(11, updateHospital20.getPopulationOver65());
      updateStmt.setLong(12, updateHospital20.getProjectedInfectedIndividuals());
      updateStmt.setLong(13, updateHospital20.getProjectedHospitalizedIndividuals());
      updateStmt.setLong(14, updateHospital20.getProjectedIndividualsNeedingIcuCare());
      updateStmt.setLong(15, updateHospital20.getHospitalBedsNeeded6Months());
      updateStmt.setLong(16, updateHospital20.getPctAvailableBedsNeeded6Months());
      updateStmt.setLong(17, updateHospital20.getPctPotentiallyAvailableBedsNeeded6Months());
      updateStmt.setLong(18, updateHospital20.getPctTotalBedsNeeded6Months());
      updateStmt.setLong(19, updateHospital20.getHospitalBedsNeeded12Months());
      updateStmt.setLong(20, updateHospital20.getPctAvailableBedsNeeded12Months());
      updateStmt.setLong(21, updateHospital20.getPctPotentiallyAvailableBedsNeeded12Months());
      updateStmt.setLong(22, updateHospital20.getPctTotalBedsNeeded12Months());
      updateStmt.setLong(23, updateHospital20.getHospitalBedsNeeded18Months());
      updateStmt.setLong(24, updateHospital20.getPctAvailableBedsNeeded18Months());
      updateStmt.setLong(25, updateHospital20.getPctPotentiallyAvailableBedsNeeded18Months());
      updateStmt.setLong(26, updateHospital20.getPctTotalBedsNeeded18Months());
      updateStmt.setLong(27, updateHospital20.getIcuBedsNeeded6Months());
      updateStmt.setLong(28, updateHospital20.getPctAvailableIcuBedsNeeded6Months());
      updateStmt.setLong(29, updateHospital20.getPctPotentiallyAvailableIcuBedsNeeded6Months());
      updateStmt.setLong(30, updateHospital20.getPctTotalIcuBedsNeeded6Months());
      updateStmt.setLong(31, updateHospital20.getIcuBedsNeeded12Months());
      updateStmt.setLong(32, updateHospital20.getPctAvailableIcuBedsNeeded12Months());
      updateStmt.setLong(33, updateHospital20.getPctPotentiallyAvailableIcuBedsNeeded12Months());
      updateStmt.setLong(34, updateHospital20.getPctTotalIcuBedsNeeded12Months());
      updateStmt.setLong(35, updateHospital20.getIcuBedsNeeded18Months());
      updateStmt.setLong(36, updateHospital20.getPctAvailableIcuBedsNeeded18Months());
      updateStmt.setLong(37, updateHospital20.getPctPotentiallyAvailableIcuBedsNeeded18Months());
      updateStmt.setLong(38, updateHospital20.getPctTotalIcuBedsNeeded18Months());
      updateStmt.executeUpdate();
      updateHospital20.setHospitals20Pk(originalHospital20.getHospitals20Pk());
      return updateHospital20;
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
   * Delete a record from the hospitals20 MySQL table.
   */
  public Hospitals20 delete(Hospitals20 hospital20) throws SQLException {
    String deleteHospitals20 = "DELETE FROM hospitals20 WHERE Hospitals20_PK=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteHospitals20);
      deleteStmt.setLong(1, hospital20.getHospitals20Pk());
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
