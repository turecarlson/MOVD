package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import MOVD.model.State;


/**
 * An object that works with State pojo in the data access layer.
 */
public class StateDao {

  protected ConnectionManager connectionManager;

  private static StateDao instance = null;

  protected StateDao() {
    connectionManager = new ConnectionManager();
  }

  /**
   * Creates an instance of the StateDao
   *
   * @return an instance of the StateDao
   */
  public static StateDao getInstance() {
    if (instance == null) {
      instance = new StateDao();
    }
    return instance;
  }

  /**
   * Save the State instance by storing it in your MySQL instance. This runs a INSERT statement.
   */
  public State create(State state) throws SQLException {
    String insertState = "INSERT INTO state(StateName, Slug, Code, Nickname, Website, AdmissionDate, AdmissionNumber, CapitalCity, "
            + "CapitalUrl, Population, PopulationRank, ConstitutionUrl, StateFlagUrl, StateSealUrl, MapImageUrl, "
            + "LandscapeBackgroundUrl, SkylineBackgroundUrl, TwitterUrl, FacebookUrl) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertState);
      insertStmt.setString(1, state.getStateName());
      insertStmt.setString(2, state.getSlug());
      insertStmt.setString(3, state.getCode());
      insertStmt.setString(4, state.getNickname());
      insertStmt.setString(5, state.getWebsite());
      insertStmt.setString(6, state.getAdmissionDate());
      insertStmt.setString(7, state.getAdmissionNumber());
      insertStmt.setString(8, state.getCapitalCity());
      insertStmt.setString(9, state.getCapitalUrl());
      insertStmt.setString(10, state.getPopulation());
      insertStmt.setString(11, state.getPopulationRank());
      insertStmt.setString(12, state.getConstitutionUrl());
      insertStmt.setString(13, state.getStateFlagUrl());
      insertStmt.setString(14, state.getStateSealUrl());
      insertStmt.setString(15, state.getMapImageUrl());
      insertStmt.setString(16, state.getLandscapeBackgroundUrl());
      insertStmt.setString(17, state.getSkylineBackgroundUrl());
      insertStmt.setString(18, state.getTwitterUrl());
      insertStmt.setString(19, state.getFacebookUrl());
      insertStmt.executeUpdate();
      return state;
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
   * Get a state record using the State's name
   *
   * @param searchState the state to be searched for
   * @return State object
   * @throws SQLException
   */
  public State getRecordByStateName(String searchState) throws SQLException {
    String select = "SELECT StateName, Slug, Code, Nickname, Website, AdmissionDate, AdmissionNumber, CapitalCity, " +
            "CapitalUrl, Population, PopulationRank, ConstitutionUrl, StateFlagUrl, StateSealUrl, MapImageUrl, " +
            "LandscapeBackgroundUrl, SkylineBackgroundUrl, TwitterUrl, FacebookUrl FROM governors WHERE State=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(select);
      selectStmt.setString(1, searchState);
      results = selectStmt.executeQuery();
      if (results.next()) {
        String stateName = results.getString("StateName");
        String slug = results.getString("Slug");
        String code = results.getString("Code");
        String nickname = results.getString("Nickname");
        String website = results.getString("Website");
        String admissionDate = results.getString("AdmissionDate");
        String admissionNumber = results.getString("AdmissionNumber");
        String capitalCity = results.getString("CapitalCity");
        String capitalUrl = results.getString("CapitalUrl");
        String population = results.getString("Population");
        String populationRank = results.getString("PopulationRanke");
        String constitutionUrl = results.getString("ConstitutionUrl");
        String stateFlagUrl = results.getString("StateFlagUrl");
        String stateSealUrl = results.getString("StateSealUrl");
        String mapImageUrl = results.getString("MapImageUrl");
        String landscapeBackgroundUrl = results.getString("LandscapeBackgroundUrl");
        String skylineBackgroundUrl = results.getString("SkylineBackgroundUrl");
        String twitterUrl = results.getString("TwitterUrl");
        String facebookUrl = results.getString("FacebookUrl");

        State record = new State(stateName, slug, code, nickname, website, admissionDate, admissionNumber, capitalCity,
                capitalUrl, population, populationRank, constitutionUrl, stateFlagUrl, stateSealUrl, mapImageUrl,
                landscapeBackgroundUrl, skylineBackgroundUrl, twitterUrl, facebookUrl);

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
   * Updates the corresponding State record in the database with new information.
   *
   * @param state - The state being updated, with new values.
   * @return - The state object now represented in the database.
   * @throws SQLException
   */
  public State updateState(State state) throws SQLException {
    String updateState = "UPDATE state SET StateName=?, Slug=?, Code=?, Nickname=?, Website=?, AdmissionDate=?, AdmissionNumber=?, CapitalCity=?, "
            + "CapitalUrl=?, Population=?, PopulationRank=?, ConstitutionUrl=?, StateFlagUrl=?, StateSealUrl=?, MapImageUrl=?, "
            + "LandscapeBackgroundUrl=?, SkylineBackgroundUrl=?, TwitterUrl=?, FacebookUrl=? WHERE StateName=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateState);
      updateStmt.setString(1, state.getStateName());
      updateStmt.setString(2, state.getSlug());
      updateStmt.setString(3, state.getCode());
      updateStmt.setString(4, state.getNickname());
      updateStmt.setString(5, state.getWebsite());
      updateStmt.setString(6, state.getAdmissionDate());
      updateStmt.setString(7, state.getAdmissionNumber());
      updateStmt.setString(8, state.getCapitalCity());
      updateStmt.setString(9, state.getCapitalUrl());
      updateStmt.setString(10, state.getPopulation());
      updateStmt.setString(11, state.getPopulationRank());
      updateStmt.setString(12, state.getConstitutionUrl());
      updateStmt.setString(13, state.getStateFlagUrl());
      updateStmt.setString(14, state.getStateSealUrl());
      updateStmt.setString(15, state.getMapImageUrl());
      updateStmt.setString(16, state.getLandscapeBackgroundUrl());
      updateStmt.setString(17, state.getSkylineBackgroundUrl());
      updateStmt.setString(18, state.getTwitterUrl());
      updateStmt.setString(19, state.getFacebookUrl());
      updateStmt.executeUpdate();
      return state;
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
   * Delete the State record in the database, and returns null as to delete it in the java model.
   *
   * @param state The state record to be deleted.
   * @return null.
   * @throws SQLException
   */
  public State delete(State state) throws SQLException {
    String deleteState = "DELETE FROM state WHERE StateName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteState);
      deleteStmt.setString(1, state.getStateName());
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
