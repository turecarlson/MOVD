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

import MOVD.model.TrumpApproval;

/**
 * An object that works with TrumpApproval pojo in the data access layer.
 */
public class TrumpApprovalDao {
  protected ConnectionManager connectionManager;
  private static TrumpApprovalDao instance = null;

  protected TrumpApprovalDao() {
    connectionManager = new ConnectionManager();
  }

  /**
   * Creates an instance of the TrumpApprovalDao
   *
   * @return an instance of the TrumpApprovalDao
   */
  public static TrumpApprovalDao getInstance() {
    if (instance == null) {
      instance = new TrumpApprovalDao();
    }
    return instance;
  }

  /**
   * Save the TrumpApproval instance by storing it in your MySQL instance. This runs a INSERT
   * statement.
   */
  public TrumpApproval create(TrumpApproval trumpApproval) throws SQLException {

    String insert = "INSERT INTO trump_approval " +
            "(President, " +
            "StartDate, " +
            "EndDate, " +
            "Pollster, " +
            "Grade, " +
            "SampleSize, " +
            "Weight, " +
            "Influence, " +
            "Approve, " +
            "Disapprove, " +
            "AdjustedApprove, " +
            "AdjustedDisapprove, " +
            "URL, " +
            "PollId, " +
            "QuestionID, " +
            "CreateDate, " +
            "TimeStamp) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(insert,
              Statement.RETURN_GENERATED_KEYS);
      int i = 1;
      insertStmt.setString(i++, trumpApproval.getPresident());
      insertStmt.setTimestamp(i++, new Timestamp(trumpApproval.getStartDate().getTime()));
      insertStmt.setTimestamp(i++, new Timestamp(trumpApproval.getEndDate().getTime()));
      insertStmt.setString(i++, trumpApproval.getPollster());
      insertStmt.setString(i++, trumpApproval.getGrade());
      insertStmt.setInt(i++, trumpApproval.getSampleSize());
      insertStmt.setDouble(i++, trumpApproval.getWeight());
      insertStmt.setDouble(i++, trumpApproval.getInfluence());
      insertStmt.setFloat(i++, trumpApproval.getApprove());
      insertStmt.setFloat(i++, trumpApproval.getDisapprove());
      insertStmt.setFloat(i++, trumpApproval.getAdjustedApprove());
      insertStmt.setFloat(i++, trumpApproval.getAdjustedDisapprove());
      insertStmt.setString(i++, trumpApproval.getURL());
      insertStmt.setString(i++, trumpApproval.getPollId());
      insertStmt.setString(i++, trumpApproval.getQuestionId());
      insertStmt.setTimestamp(i++, new Timestamp(trumpApproval.getCreateDate().getTime()));
      insertStmt.setTimestamp(i++, new Timestamp(trumpApproval.getTimestamp().getTime()));

      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int Id = -1;
      if (resultKey.next()) {
        Id = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      trumpApproval.setTrumpApprovalPk(Id);
      return trumpApproval;
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
   * Returns a list of TrumpApproval records, given a createDate.
   *
   * @param createDate - The date of the record[s] being fetched.
   * @return - a list of TrumpApproval records that correspond to the given date.
   * @throws SQLException - If an error communicating with the sql server occurs.
   */
  public List<TrumpApproval> getTrumpApprovalByCreateDate(Date createDate) throws SQLException {
    List<TrumpApproval> trumpApprovalList = new ArrayList<TrumpApproval>();
    String selectTrumpApproval = "SELECT Trump_Approval_PK, President, StartDate, EndDate, Pollster, Grade, "
            + "SampleSize, Weight, Influence, Approve, Disapprove, AdjustedApprove, AdjustedDisapprove, "
            + "URL, PollId, QuestionID, CreateDate, TimeStamp "
            + "FROM trump_approval "
            + "WHERE CreateDate=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectTrumpApproval);
      selectStmt.setTimestamp(1, new Timestamp(createDate.getTime()));
      results = selectStmt.executeQuery();
      while (results.next()) {
        int trumpApprovalPk = results.getInt("Trump_Approval_PK");
        String president = results.getString("President");
        Date startDate = new Date(results.getTimestamp("StartDate").getTime());
        Date endDate = new Date(results.getTimestamp("endDate").getTime());
        String pollster = results.getString("Pollster");
        String grade = results.getString("Grade");
        int sampleSize = results.getInt("SampleSize");
        double weight = results.getDouble("Weight");
        double influence = results.getDouble("Influence");
        float approve = results.getFloat("Approve");
        float disapprove = results.getFloat("Disappove");
        float adjustedApprove = results.getFloat("adjustedApprove");
        float adjustedDisapprove = results.getFloat("adjustedDisapprove");
        String URL = results.getString("URL");
        String pollId = results.getString("PollId");
        String questionId = results.getString("QuestionId");
        Date resultCreateDate = new Date(results.getTimestamp("CreateDate").getTime());
        Date timestamp = new Date(results.getTimestamp("TimeStamp").getTime());
        TrumpApproval trumpApproval = new TrumpApproval(trumpApprovalPk, president, startDate, endDate, pollster,
                grade, sampleSize, weight, influence, approve, disapprove, adjustedApprove,
                adjustedDisapprove, URL, pollId, questionId, resultCreateDate, timestamp);
        trumpApprovalList.add(trumpApproval);
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
    return trumpApprovalList;
  }

  /**
   * Update all fields of the TrumpApproval instance.
   */

  public TrumpApproval update(TrumpApproval old, TrumpApproval updated) throws SQLException {


    String update = "Update trump_approval SET President=?, StartDate=?, EndDate=?, " +
            " Pollster=?, Grade=?, SampleSize=?, Weight=?, Influence=?, Approve=?, Disapprove=?,"
            + " AdjustedApprove=?, AdjustedDisapprove=?, URL=?, PollId=?, QuestionID=?, "
            + "CreateDate=?, TimeStamp=? ";

    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      // Companies has an auto-generated key. So we want to retrieve that key.
      insertStmt = connection.prepareStatement(update);

      int i = 1;
      insertStmt.setString(i++, updated.getPresident());
      insertStmt.setTimestamp(i++, new Timestamp(updated.getStartDate().getTime()));
      insertStmt.setTimestamp(i++, new Timestamp(updated.getEndDate().getTime()));
      insertStmt.setString(i++, updated.getPollster());
      insertStmt.setString(i++, updated.getGrade());
      insertStmt.setInt(i++, updated.getSampleSize());
      insertStmt.setDouble(i++, updated.getWeight());
      insertStmt.setDouble(i++, updated.getInfluence());
      insertStmt.setFloat(i++, updated.getApprove());
      insertStmt.setFloat(i++, updated.getDisapprove());
      insertStmt.setFloat(i++, updated.getAdjustedApprove());
      insertStmt.setFloat(i++, updated.getAdjustedDisapprove());
      insertStmt.setString(i++, updated.getURL());
      insertStmt.setString(i++, updated.getPollId());
      insertStmt.setString(i++, updated.getQuestionId());
      insertStmt.setTimestamp(i++, new Timestamp(updated.getCreateDate().getTime()));
      insertStmt.setTimestamp(i, new Timestamp(updated.getTimestamp().getTime()));

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
   * Delete the TrumpApproval object in the model and database.
   *
   * @param trumpApproval The reference to the object to be deleted.
   * @return null to the caller because the object is deleted.
   * @throws SQLException If there is an error with the SQL code.
   */
  public TrumpApproval delete(TrumpApproval trumpApproval) throws SQLException {

    String insert = "DELETE FROM trump_approval WHERE Trump_Approval_PK=?;";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert);
      insertStmt.setLong(1, trumpApproval.getTrumpApprovalPk());
      insertStmt.executeUpdate();

      //Allow the data to be garbage collected
      trumpApproval = null;
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
