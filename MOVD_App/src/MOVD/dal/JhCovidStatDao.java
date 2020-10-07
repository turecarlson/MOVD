package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MOVD.model.*;

public class JhCovidStatDao {
  protected ConnectionManager connectionManager;

  private static JhCovidStatDao instance = null;

  protected JhCovidStatDao() {
    connectionManager = new ConnectionManager();
  }

  public static JhCovidStatDao getInstance() {
    if (instance == null) {
      instance = new JhCovidStatDao();
    }
    return instance;
  }

  /**
   * Create a record in the JHCovidStat MySQL table.
   */
  public JhCovidStat create(JhCovidStat jhCovidStat) throws SQLException {
    String createJhCovidStat = "INSERT INTO jhcovidstat(countyuid, countyname, state, date, totalcountypopulation, " +
            "cumulativecases, cumulativecasesper100000, cumulativedeaths, cumulativedeathsper100000, newcases, " +
            "newdeaths, newcasesper100000, newdeathsper100000, newcases7dayrollingaverage, " +
            "newdeaths7dayrollingaverage, jhcountystat_fipscode)" +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    Connection connection = null;
    PreparedStatement createStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      createStmt = connection.prepareStatement(createJhCovidStat, Statement.RETURN_GENERATED_KEYS);

      int i = 1;
      createStmt.setString(i++, jhCovidStat.getCountyUid());
      createStmt.setString(i++, jhCovidStat.getCountyName());
      createStmt.setString(i++, jhCovidStat.getState());
      createStmt.setString(i++, jhCovidStat.getDate());
      createStmt.setDouble(i++, jhCovidStat.getTotalCountyPopulation());
      createStmt.setDouble(i++, jhCovidStat.getCumulativeCases());
      createStmt.setDouble(i++, jhCovidStat.getCumulativeCasesPer100000());
      createStmt.setDouble(i++, jhCovidStat.getCumulativeDeaths());
      createStmt.setDouble(i++, jhCovidStat.getCumulativeDeathsPer100000());
      createStmt.setDouble(i++, jhCovidStat.getNewCases());
      createStmt.setDouble(i++, jhCovidStat.getNewDeaths());
      createStmt.setDouble(i++, jhCovidStat.getNewCasesPer100000());
      createStmt.setString(i++, jhCovidStat.getNewDeathsPer100000());
      createStmt.setDouble(i++, jhCovidStat.getNewCases7DayRollingAverage());
      createStmt.setDouble(i++, jhCovidStat.getNewDeaths7DayRollingAverage());
      createStmt.setString(i, jhCovidStat.getJhCountyStatFipsCode());
      createStmt.executeUpdate();


      resultKey = createStmt.getGeneratedKeys();
      int covidStatKey = -1;
      if (resultKey.next()) {
        covidStatKey = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve generated covidStatKey");
      }
      jhCovidStat.setCovidStatKeyPk(covidStatKey);
      return jhCovidStat;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (createStmt != null) {
        createStmt.close();
      }
    }
  }

  /**
   * Return a list of records from the JHCovidStat MySQL table by state.
   */
  public List<JhCovidStat> getJhCovidStatBy(String state) throws SQLException {
    List<JhCovidStat> jhCovidStatList = new ArrayList<JhCovidStat>();
    String createJhCovidStat = "SELECT countyuid, countyname, state, date, totalcountypopulation, " +
            "cumulativecases, cumulativecasesper100000, cumulativedeaths, cumulativedeathsper100000, newcases, " +
            "newdeaths, newcasesper100000, newdeathsper100000, newcases7dayrollingaverage, " +
            "newdeaths7dayrollingaverage, jhcountystat_fipscode " +
            "FROM jhcovidstat " +
            "WHERE state=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(createJhCovidStat, Statement.RETURN_GENERATED_KEYS);
      selectStmt.setString(1, state);
      results = selectStmt.executeQuery();
      while (results.next()) {
        String countyUID = results.getString("countyuid");
        String countyName = results.getString("countyname");
        String stateResult = results.getString("state");
        String date = results.getString("date");
        double totalCountyPopulation = results.getDouble("totalcountypopulation");
        long cumulativeCases = results.getLong("cumulativecases");
        double cumulativeCasesPer100000 = results.getDouble("cumulativecasesper100000");
        long cumulativeDeaths = results.getLong("cumulativedeaths");
        double cumulativeDeathsPer100000 = results.getDouble("cumulativedeathsper100000");
        long newCases = results.getLong("newcases");
        long newDeaths = results.getLong("newdeaths");
        long newCasesPer100000 = results.getLong("newcasesper100000");
        String newDeathsPer100000 = results.getString("newdeathsper100000");
        double newCases7DayRollingAverage = results.getDouble("newcases7dayrollingaverage");
        double newDeaths7DayRollingAverage = results.getDouble("newdeaths7dayrollingaverage");
        String jhCountyStatFipsCode = results.getNString("jhcountystat_fipscode");
        JhCovidStat jhCovidStat = new JhCovidStat(countyUID, countyName, stateResult, date,
                totalCountyPopulation, cumulativeCases, cumulativeCasesPer100000, cumulativeDeaths,
                cumulativeDeathsPer100000, newCases, newDeaths, newCasesPer100000, newDeathsPer100000,
                newCases7DayRollingAverage, newDeaths7DayRollingAverage, jhCountyStatFipsCode);
        jhCovidStatList.add(jhCovidStat);
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
    return jhCovidStatList;
  }

  /**
   * Update a record in the JHCovidStat MySQL table by using all of the values from a provided
   * pojo.
   */
  public JhCovidStat update(JhCovidStat jhCovidStat, JhCovidStat newValues) throws SQLException {
    String updateJhCovidStat = "UPDATE JhCovidStat " +
            "SET countyuid=?, countyname=?, state=?, date=?, totalcountypopulation=?, cumulativecases=?, " +
            "cumulativecasesper100000=?, cumulativedeaths=?, cumulativedeathsper100000=?, newcases=?, newdeaths=?, " +
            "newcasesper100000=?, newdeathsper100000=?, newcases7dayrollingaverage=?, newdeaths7dayrollingaverage=?, " +
            "jhcountystat_fipscode=? " +
            "WHERE CovidStatKey_pk=?; ";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateJhCovidStat, Statement.RETURN_GENERATED_KEYS);

      int i = 1;
      updateStmt.setString(i++, jhCovidStat.getCountyUid());
      updateStmt.setString(i++, jhCovidStat.getCountyName());
      updateStmt.setString(i++, jhCovidStat.getState());
      updateStmt.setString(i++, jhCovidStat.getDate());
      updateStmt.setDouble(i++, jhCovidStat.getTotalCountyPopulation());
      updateStmt.setDouble(i++, jhCovidStat.getCumulativeCases());
      updateStmt.setDouble(i++, jhCovidStat.getCumulativeCasesPer100000());
      updateStmt.setDouble(i++, jhCovidStat.getCumulativeDeaths());
      updateStmt.setDouble(i++, jhCovidStat.getCumulativeDeathsPer100000());
      updateStmt.setDouble(i++, jhCovidStat.getNewCases());
      updateStmt.setDouble(i++, jhCovidStat.getNewDeaths());
      updateStmt.setDouble(i++, jhCovidStat.getNewCasesPer100000());
      updateStmt.setString(i++, jhCovidStat.getNewDeathsPer100000());
      updateStmt.setDouble(i++, jhCovidStat.getNewCases7DayRollingAverage());
      updateStmt.setDouble(i++, jhCovidStat.getNewDeaths7DayRollingAverage());
      updateStmt.setString(i, jhCovidStat.getJhCountyStatFipsCode());
      updateStmt.setLong(i, jhCovidStat.getCovidStatKeyPk());
      updateStmt.executeUpdate();

      newValues.setCovidStatKeyPk(jhCovidStat.getCovidStatKeyPk());
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
   * Delete a record in the JHCovidStat MySQL table.
   */
  public JhCovidStat delete(JhCovidStat jhCovidStat) throws SQLException {
    String deleteJhCovidStat = "DELETE FROM JhCovidStat WHERE CovidStatKey_pk=?";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteJhCovidStat);
      deleteStmt.setString(1, Long.toString(jhCovidStat.getCovidStatKeyPk()));
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
