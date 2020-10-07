package MOVD.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MOVD.model.CensusRecord;

public class CensusRecordDao {

  protected ConnectionManager connectionManager;
  private static CensusRecordDao instance = null;

  protected CensusRecordDao() {
    connectionManager = new ConnectionManager();
  }

  public static CensusRecordDao getInstance() {
    if (instance == null) {
      instance = new CensusRecordDao();
    }
    return instance;
  }

  /**
   * Save the CensusRecord instance by storing it in your MySQL instance. This runs a INSERT
   * statement.
   */
  public CensusRecord create(CensusRecord censusRecord) throws SQLException {

    String insert = "INSERT INTO CensusRecord" +
            "(FipsCode," +
            "CountyName," +
            "YEAR," +
            "AGEGRP," +
            "TOT_POP," +
            "TOT_MALE," +
            "TOT_FEMALE," +
            "WA_MALE," +
            "WA_FEMALE," +
            "BA_MALE," +
            "BA_FEMALE," +
            "IA_MALE," +
            "IA_FEMALE," +
            "AA_MALE," +
            "AA_FEMALE," +
            "NA_MALE," +
            "NA_FEMALE," +
            "TOM_MALE," +
            "TOM_FEMALE," +
            "WAC_MALE," +
            "WAC_FEMALE," +
            "BAC_MALE," +
            "BAC_FEMALE," +
            "IAC_MALE," +
            "IAC_FEMALE," +
            "AAC_MALE," +
            "AAC_FEMALE," +
            "NAC_MALE," +
            "NAC_FEMALE," +
            "NH_MALE," +
            "NH_FEMALE," +
            "NHWA_MALE," +
            "NHWA_FEMALE," +
            "NHBA_MALE," +
            "NHBA_FEMALE," +
            "NHIA_MALE," +
            "NHIA_FEMALE," +
            "NHAA_MALE," +
            "NHAA_FEMALE," +
            "NHNA_MALE," +
            "NHNA_FEMALE," +
            "NHTOM_MALE," +
            "NHTOM_FEMALE," +
            "NHWAC_MALE," +
            "NHWAC_FEMALE," +
            "NHBAC_MALE," +
            "NHBAC_FEMALE," +
            "NHIAC_MALE," +
            "NHIAC_FEMALE," +
            "NHAAC_MALE," +
            "NHAAC_FEMALE," +
            "NHNAC_MALE," +
            "NHNAC_FEMALE," +
            "H_MALE," +
            "H_FEMALE," +
            "HWA_MALE," +
            "HWA_FEMALE," +
            "HBA_MALE," +
            "HBA_FEMALE," +
            "HIA_MALE," +
            "HIA_FEMALE," +
            "HAA_MALE," +
            "HAA_FEMALE," +
            "HNA_MALE," +
            "HNA_FEMALE," +
            "HTOM_MALE," +
            "HTOM_FEMALE," +
            "HWAC_MALE," +
            "HWAC_FEMALE," +
            "HBAC_MALE," +
            "HBAC_FEMALE," +
            "HIAC_MALE," +
            "HIAC_FEMALE," +
            "HAAC_MALE," +
            "HAAC_FEMALE," +
            "HNAC_MALE," +
            "HNAC_FEMALE) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert,
              Statement.RETURN_GENERATED_KEYS);
      int i = 1;
      insertStmt.setString(i++, censusRecord.getFipsCode());
      insertStmt.setString(i++, censusRecord.getCountyName());
      insertStmt.setLong(i++, censusRecord.getYear());
      insertStmt.setLong(i++, censusRecord.getAgegrp());
      insertStmt.setLong(i++, censusRecord.getTotPop());
      insertStmt.setLong(i++, censusRecord.getTotMale());
      insertStmt.setLong(i++, censusRecord.getTotFemale());
      insertStmt.setLong(i++, censusRecord.getWaMale());
      insertStmt.setLong(i++, censusRecord.getWaFemale());
      insertStmt.setLong(i++, censusRecord.getBaMale());
      insertStmt.setLong(i++, censusRecord.getBaFemale());
      insertStmt.setLong(i++, censusRecord.getIaMale());
      insertStmt.setLong(i++, censusRecord.getIaFemale());
      insertStmt.setLong(i++, censusRecord.getAaMale());
      insertStmt.setLong(i++, censusRecord.getAaFemale());
      insertStmt.setLong(i++, censusRecord.getNaMale());
      insertStmt.setLong(i++, censusRecord.getNaFemale());
      insertStmt.setLong(i++, censusRecord.getTomMale());
      insertStmt.setLong(i++, censusRecord.getTomFemale());
      insertStmt.setLong(i++, censusRecord.getWacMale());
      insertStmt.setLong(i++, censusRecord.getWacFemale());
      insertStmt.setLong(i++, censusRecord.getBacMale());
      insertStmt.setLong(i++, censusRecord.getBacFemale());
      insertStmt.setLong(i++, censusRecord.getIacMale());
      insertStmt.setLong(i++, censusRecord.getIacFemale());
      insertStmt.setLong(i++, censusRecord.getAacMale());
      insertStmt.setLong(i++, censusRecord.getAacFemale());
      insertStmt.setLong(i++, censusRecord.getNacMale());
      insertStmt.setLong(i++, censusRecord.getNacFemale());
      insertStmt.setLong(i++, censusRecord.getNhMale());
      insertStmt.setLong(i++, censusRecord.getNhFemale());
      insertStmt.setLong(i++, censusRecord.getNhwaMale());
      insertStmt.setLong(i++, censusRecord.getNhwaFemale());
      insertStmt.setLong(i++, censusRecord.getNhbaMale());
      insertStmt.setLong(i++, censusRecord.getNhbaFemale());
      insertStmt.setLong(i++, censusRecord.getNhiaMale());
      insertStmt.setLong(i++, censusRecord.getNhiaFemale());
      insertStmt.setLong(i++, censusRecord.getNhaaMale());
      insertStmt.setLong(i++, censusRecord.getNhaaFemale());
      insertStmt.setLong(i++, censusRecord.getNhnaMale());
      insertStmt.setLong(i++, censusRecord.getNhnaFemale());
      insertStmt.setLong(i++, censusRecord.getNhtomMale());
      insertStmt.setLong(i++, censusRecord.getNhtomFemale());
      insertStmt.setLong(i++, censusRecord.getNhwacMale());
      insertStmt.setLong(i++, censusRecord.getNhwacFemale());
      insertStmt.setLong(i++, censusRecord.getNhbacMale());
      insertStmt.setLong(i++, censusRecord.getNhbacFemale());
      insertStmt.setLong(i++, censusRecord.getNhiacMale());
      insertStmt.setLong(i++, censusRecord.getNhiacFemale());
      insertStmt.setLong(i++, censusRecord.getNhaacMale());
      insertStmt.setLong(i++, censusRecord.getNhaacFemale());
      insertStmt.setLong(i++, censusRecord.getNhnacMale());
      insertStmt.setLong(i++, censusRecord.getNhnacFemale());
      insertStmt.setLong(i++, censusRecord.getHMale());
      insertStmt.setLong(i++, censusRecord.getHFemale());
      insertStmt.setLong(i++, censusRecord.getHwaMale());
      insertStmt.setLong(i++, censusRecord.getHwaFemale());
      insertStmt.setLong(i++, censusRecord.getHbaMale());
      insertStmt.setLong(i++, censusRecord.getHbaFemale());
      insertStmt.setLong(i++, censusRecord.getHiaMale());
      insertStmt.setLong(i++, censusRecord.getHiaFemale());
      insertStmt.setLong(i++, censusRecord.getHaaMale());
      insertStmt.setLong(i++, censusRecord.getHaaFemale());
      insertStmt.setLong(i++, censusRecord.getHnaMale());
      insertStmt.setLong(i++, censusRecord.getHnaFemale());
      insertStmt.setLong(i++, censusRecord.getHtomMale());
      insertStmt.setLong(i++, censusRecord.getHtomFemale());
      insertStmt.setLong(i++, censusRecord.getHwacMale());
      insertStmt.setLong(i++, censusRecord.getHwacFemale());
      insertStmt.setLong(i++, censusRecord.getHbacMale());
      insertStmt.setLong(i++, censusRecord.getHbacFemale());
      insertStmt.setLong(i++, censusRecord.getHiacMale());
      insertStmt.setLong(i++, censusRecord.getHiacFemale());
      insertStmt.setLong(i++, censusRecord.getHaacMale());
      insertStmt.setLong(i++, censusRecord.getHaacFemale());
      insertStmt.setLong(i++, censusRecord.getHnacMale());
      insertStmt.setLong(i++, censusRecord.getHnacFemale());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int Id = -1;
      if (resultKey.next()) {
        Id = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      censusRecord.setCensusDataPk(Id);
      return censusRecord;
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
   * Return a list of census records by FipsCode.
   */
  public List<CensusRecord> getDataByFipsCode(String fipscode) throws SQLException {

    List<CensusRecord> records = new ArrayList<CensusRecord>();

    String select = "SELECT * FROM CensusRecord WHERE FipsCode=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(select);
      selectStmt.setString(1, fipscode);
      results = selectStmt.executeQuery();
      while (results.next()) {
        CensusRecord record = new CensusRecord(results.getLong("CensusDataPk"), results.getString("FipsCode"),
                results.getString("CountyName"),
                results.getLong("Year"),
                results.getLong("Agegrp"),
                results.getLong("TotPop"),
                results.getLong("TotMale"),
                results.getLong("TotFemale"),
                results.getLong("WaMale"),
                results.getLong("WaFemale"),
                results.getLong("BaMale"),
                results.getLong("BaFemale"),
                results.getLong("IaMale"),
                results.getLong("IaFemale"),
                results.getLong("AaMale"),
                results.getLong("AaFemale"),
                results.getLong("NaMale"),
                results.getLong("NaFemale"),
                results.getLong("TomMale"),
                results.getLong("TomFemale"),
                results.getLong("WacMale"),
                results.getLong("WacFemale"),
                results.getLong("BacMale"),
                results.getLong("BacFemale"),
                results.getLong("IacMale"),
                results.getLong("IacFemale"),
                results.getLong("AacMale"),
                results.getLong("AacFemale"),
                results.getLong("NacMale"),
                results.getLong("NacFemale"),
                results.getLong("NhMale"),
                results.getLong("NhFemale"),
                results.getLong("NhwaMale"),
                results.getLong("NhwaFemale"),
                results.getLong("NhbaMale"),
                results.getLong("NhbaFemale"),
                results.getLong("NhiaMale"),
                results.getLong("NhiaFemale"),
                results.getLong("NhaaMale"),
                results.getLong("NhaaFemale"),
                results.getLong("NhnaMale"),
                results.getLong("NhnaFemale"),
                results.getLong("NhtomMale"),
                results.getLong("NhtomFemale"),
                results.getLong("NhwacMale"),
                results.getLong("NhwacFemale"),
                results.getLong("NhbacMale"),
                results.getLong("NhbacFemale"),
                results.getLong("NhiacMale"),
                results.getLong("NhiacFemale"),
                results.getLong("NhaacMale"),
                results.getLong("NhaacFemale"),
                results.getLong("NhnacMale"),
                results.getLong("NhnacFemale"),
                results.getLong("HMale"),
                results.getLong("HFemale"),
                results.getLong("HwaMale"),
                results.getLong("HwaFemale"),
                results.getLong("HbaMale"),
                results.getLong("HbaFemale"),
                results.getLong("HiaMale"),
                results.getLong("HiaFemale"),
                results.getLong("HaaMale"),
                results.getLong("HaaFemale"),
                results.getLong("HnaMale"),
                results.getLong("HnaFemale"),
                results.getLong("HtomMale"),
                results.getLong("HtomFemale"),
                results.getLong("HwacMale"),
                results.getLong("HwacFemale"),
                results.getLong("HbacMale"),
                results.getLong("HbacFemale"),
                results.getLong("HiacMale"),
                results.getLong("HiacFemale"),
                results.getLong("HaacMale"),
                results.getLong("HaacFemale"),
                results.getLong("HnacMale"),
                results.getLong("HnacFemale"));
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


  /**
   * Save the CensusRecord instance by storing it in your MySQL instance. This runs a INSERT
   * statement.
   */
  public CensusRecord update(CensusRecord old, CensusRecord updated) throws SQLException {

    String update = "UPDATE CensusRecord SET " +
            "FipsCode=?," +
            "CountyName=?," +
            "YEAR=?," +
            "AGEGRP=?," +
            "TOT_POP=?," +
            "TOT_MALE=?," +
            "TOT_FEMALE=?," +
            "WA_MALE=?," +
            "WA_FEMALE=?," +
            "BA_MALE=?," +
            "BA_FEMALE=?," +
            "IA_MALE=?," +
            "IA_FEMALE=?," +
            "AA_MALE=?," +
            "AA_FEMALE=?," +
            "NA_MALE=?," +
            "NA_FEMALE=?," +
            "TOM_MALE=?," +
            "TOM_FEMALE=?," +
            "WAC_MALE=?," +
            "WAC_FEMALE=?," +
            "BAC_MALE=?," +
            "BAC_FEMALE=?," +
            "IAC_MALE=?," +
            "IAC_FEMALE=?," +
            "AAC_MALE=?," +
            "AAC_FEMALE=?," +
            "NAC_MALE=?," +
            "NAC_FEMALE=?," +
            "NH_MALE=?," +
            "NH_FEMALE=?," +
            "NHWA_MALE=?," +
            "NHWA_FEMALE=?," +
            "NHBA_MALE=?," +
            "NHBA_FEMALE=?," +
            "NHIA_MALE=?," +
            "NHIA_FEMALE=?," +
            "NHAA_MALE=?," +
            "NHAA_FEMALE=?," +
            "NHNA_MALE=?," +
            "NHNA_FEMALE=?," +
            "NHTOM_MALE=?," +
            "NHTOM_FEMALE=?," +
            "NHWAC_MALE=?," +
            "NHWAC_FEMALE=?," +
            "NHBAC_MALE=?," +
            "NHBAC_FEMALE=?," +
            "NHIAC_MALE=?," +
            "NHIAC_FEMALE=?," +
            "NHAAC_MALE=?," +
            "NHAAC_FEMALE=?," +
            "NHNAC_MALE=?," +
            "NHNAC_FEMALE=?," +
            "H_MALE=?," +
            "H_FEMALE=?," +
            "HWA_MALE=?," +
            "HWA_FEMALE=?," +
            "HBA_MALE=?," +
            "HBA_FEMALE=?," +
            "HIA_MALE=?," +
            "HIA_FEMALE=?," +
            "HAA_MALE=?," +
            "HAA_FEMALE=?," +
            "HNA_MALE=?," +
            "HNA_FEMALE=?," +
            "HTOM_MALE=?," +
            "HTOM_FEMALE=?," +
            "HWAC_MALE=?," +
            "HWAC_FEMALE=?," +
            "HBAC_MALE=?," +
            "HBAC_FEMALE=?," +
            "HIAC_MALE=?," +
            "HIAC_FEMALE=?," +
            "HAAC_MALE=?," +
            "HAAC_FEMALE=?," +
            "HNAC_MALE=?," +
            "HNAC_FEMALE=? " +
            "WHERE census_data_pk=?;";

    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(update);

      int i = 1;
      insertStmt.setString(i++, updated.getFipsCode());
      insertStmt.setString(i++, updated.getCountyName());
      insertStmt.setLong(i++, updated.getYear());
      insertStmt.setLong(i++, updated.getAgegrp());
      insertStmt.setLong(i++, updated.getTotPop());
      insertStmt.setLong(i++, updated.getTotMale());
      insertStmt.setLong(i++, updated.getTotFemale());
      insertStmt.setLong(i++, updated.getWaMale());
      insertStmt.setLong(i++, updated.getWaFemale());
      insertStmt.setLong(i++, updated.getBaMale());
      insertStmt.setLong(i++, updated.getBaFemale());
      insertStmt.setLong(i++, updated.getIaMale());
      insertStmt.setLong(i++, updated.getIaFemale());
      insertStmt.setLong(i++, updated.getAaMale());
      insertStmt.setLong(i++, updated.getAaFemale());
      insertStmt.setLong(i++, updated.getNaMale());
      insertStmt.setLong(i++, updated.getNaFemale());
      insertStmt.setLong(i++, updated.getTomMale());
      insertStmt.setLong(i++, updated.getTomFemale());
      insertStmt.setLong(i++, updated.getWacMale());
      insertStmt.setLong(i++, updated.getWacFemale());
      insertStmt.setLong(i++, updated.getBacMale());
      insertStmt.setLong(i++, updated.getBacFemale());
      insertStmt.setLong(i++, updated.getIacMale());
      insertStmt.setLong(i++, updated.getIacFemale());
      insertStmt.setLong(i++, updated.getAacMale());
      insertStmt.setLong(i++, updated.getAacFemale());
      insertStmt.setLong(i++, updated.getNacMale());
      insertStmt.setLong(i++, updated.getNacFemale());
      insertStmt.setLong(i++, updated.getNhMale());
      insertStmt.setLong(i++, updated.getNhFemale());
      insertStmt.setLong(i++, updated.getNhwaMale());
      insertStmt.setLong(i++, updated.getNhwaFemale());
      insertStmt.setLong(i++, updated.getNhbaMale());
      insertStmt.setLong(i++, updated.getNhbaFemale());
      insertStmt.setLong(i++, updated.getNhiaMale());
      insertStmt.setLong(i++, updated.getNhiaFemale());
      insertStmt.setLong(i++, updated.getNhaaMale());
      insertStmt.setLong(i++, updated.getNhaaFemale());
      insertStmt.setLong(i++, updated.getNhnaMale());
      insertStmt.setLong(i++, updated.getNhnaFemale());
      insertStmt.setLong(i++, updated.getNhtomMale());
      insertStmt.setLong(i++, updated.getNhtomFemale());
      insertStmt.setLong(i++, updated.getNhwacMale());
      insertStmt.setLong(i++, updated.getNhwacFemale());
      insertStmt.setLong(i++, updated.getNhbacMale());
      insertStmt.setLong(i++, updated.getNhbacFemale());
      insertStmt.setLong(i++, updated.getNhiacMale());
      insertStmt.setLong(i++, updated.getNhiacFemale());
      insertStmt.setLong(i++, updated.getNhaacMale());
      insertStmt.setLong(i++, updated.getNhaacFemale());
      insertStmt.setLong(i++, updated.getNhnacMale());
      insertStmt.setLong(i++, updated.getNhnacFemale());
      insertStmt.setLong(i++, updated.getHMale());
      insertStmt.setLong(i++, updated.getHFemale());
      insertStmt.setLong(i++, updated.getHwaMale());
      insertStmt.setLong(i++, updated.getHwaFemale());
      insertStmt.setLong(i++, updated.getHbaMale());
      insertStmt.setLong(i++, updated.getHbaFemale());
      insertStmt.setLong(i++, updated.getHiaMale());
      insertStmt.setLong(i++, updated.getHiaFemale());
      insertStmt.setLong(i++, updated.getHaaMale());
      insertStmt.setLong(i++, updated.getHaaFemale());
      insertStmt.setLong(i++, updated.getHnaMale());
      insertStmt.setLong(i++, updated.getHnaFemale());
      insertStmt.setLong(i++, updated.getHtomMale());
      insertStmt.setLong(i++, updated.getHtomFemale());
      insertStmt.setLong(i++, updated.getHwacMale());
      insertStmt.setLong(i++, updated.getHwacFemale());
      insertStmt.setLong(i++, updated.getHbacMale());
      insertStmt.setLong(i++, updated.getHbacFemale());
      insertStmt.setLong(i++, updated.getHiacMale());
      insertStmt.setLong(i++, updated.getHiacFemale());
      insertStmt.setLong(i++, updated.getHaacMale());
      insertStmt.setLong(i++, updated.getHaacFemale());
      insertStmt.setLong(i++, updated.getHnacMale());
      insertStmt.setLong(i++, updated.getHnacFemale());
      insertStmt.setLong(i++, old.getCensusDataPk());
      insertStmt.executeUpdate();

      updated.setCensusDataPk(old.getCensusDataPk());
      old = updated;
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
   * Delete the object in the model and database.
   *
   * @param censusRecord The reference to the object to be deleted.
   * @return null to the caller because the object is deleted.
   * @throws SQLException If there is an error with the SQL code.
   */
  public void delete(CensusRecord censusRecord) throws SQLException {

    String delete = "DELETE FROM CensusRecord WHERE census_data_pk=?;";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(delete);
      insertStmt.setLong(1, censusRecord.getCensusDataPk());
      insertStmt.executeUpdate();

      //Allow the data to be garbage collected
      censusRecord = null;

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



