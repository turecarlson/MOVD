package MOVD.model;


public class JhCovidStat {

  private long covidStatKeyPk;
  private String countyUid;
  private String countyName;
  private String state;
  private String date;
  private double totalCountyPopulation;
  private long cumulativeCases;
  private double cumulativeCasesPer100000;
  private long cumulativeDeaths;
  private double cumulativeDeathsPer100000;
  private long newCases;
  private long newDeaths;
  private double newCasesPer100000;
  private String newDeathsPer100000;
  private double newCases7DayRollingAverage;
  private double newDeaths7DayRollingAverage;
  private String jhCountyStatFipsCode;


  public JhCovidStat(long covidStatKeyPk, String countyUid, String countyName, String state, String date,
                     double totalCountyPopulation, long cumulativeCases, double cumulativeCasesPer100000, long cumulativeDeaths,
                     double cumulativeDeathsPer100000, long newCases, long newDeaths, double newCasesPer100000,
                     String newDeathsPer100000, double newCases7DayRollingAverage, double newDeaths7DayRollingAverage,
                     String jhCountyStatFipsCode) {
    this.covidStatKeyPk = covidStatKeyPk;
    this.countyUid = countyUid;
    this.countyName = countyName;
    this.state = state;
    this.date = date;
    this.totalCountyPopulation = totalCountyPopulation;
    this.cumulativeCases = cumulativeCases;
    this.cumulativeCasesPer100000 = cumulativeCasesPer100000;
    this.cumulativeDeaths = cumulativeDeaths;
    this.cumulativeDeathsPer100000 = cumulativeDeathsPer100000;
    this.newCases = newCases;
    this.newDeaths = newDeaths;
    this.newCasesPer100000 = newCasesPer100000;
    this.newDeathsPer100000 = newDeathsPer100000;
    this.newCases7DayRollingAverage = newCases7DayRollingAverage;
    this.newDeaths7DayRollingAverage = newDeaths7DayRollingAverage;
    this.jhCountyStatFipsCode = jhCountyStatFipsCode;
  }

  public JhCovidStat(String countyUid, String countyName, String state, String date,
                     double totalCountyPopulation, long cumulativeCases, double cumulativeCasesPer100000, long cumulativeDeaths,
                     double cumulativeDeathsPer100000, long newCases, long newDeaths, double newCasesPer100000,
                     String newDeathsPer100000, double newCases7DayRollingAverage, double newDeaths7DayRollingAverage,
                     String jhCountyStatFipsCode) {
    this.countyUid = countyUid;
    this.countyName = countyName;
    this.state = state;
    this.date = date;
    this.totalCountyPopulation = totalCountyPopulation;
    this.cumulativeCases = cumulativeCases;
    this.cumulativeCasesPer100000 = cumulativeCasesPer100000;
    this.cumulativeDeaths = cumulativeDeaths;
    this.cumulativeDeathsPer100000 = cumulativeDeathsPer100000;
    this.newCases = newCases;
    this.newDeaths = newDeaths;
    this.newCasesPer100000 = newCasesPer100000;
    this.newDeathsPer100000 = newDeathsPer100000;
    this.newCases7DayRollingAverage = newCases7DayRollingAverage;
    this.newDeaths7DayRollingAverage = newDeaths7DayRollingAverage;
    this.jhCountyStatFipsCode = jhCountyStatFipsCode;
  }

  public JhCovidStat(long covidStatKeyPk) {
    this.covidStatKeyPk = covidStatKeyPk;
  }


  public long getCovidStatKeyPk() {
    return covidStatKeyPk;
  }

  public void setCovidStatKeyPk(long covidStatKeyPk) {
    this.covidStatKeyPk = covidStatKeyPk;
  }


  public String getCountyUid() {
    return countyUid;
  }

  public void setCountyUid(String countyUid) {
    this.countyUid = countyUid;
  }


  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  public double getTotalCountyPopulation() {
    return totalCountyPopulation;
  }

  public void setTotalCountyPopulation(double totalCountyPopulation) {
    this.totalCountyPopulation = totalCountyPopulation;
  }


  public long getCumulativeCases() {
    return cumulativeCases;
  }

  public void setCumulativeCases(long cumulativeCases) {
    this.cumulativeCases = cumulativeCases;
  }


  public double getCumulativeCasesPer100000() {
    return cumulativeCasesPer100000;
  }

  public void setCumulativeCasesPer100000(double cumulativeCasesPer100000) {
    this.cumulativeCasesPer100000 = cumulativeCasesPer100000;
  }


  public long getCumulativeDeaths() {
    return cumulativeDeaths;
  }

  public void setCumulativeDeaths(long cumulativeDeaths) {
    this.cumulativeDeaths = cumulativeDeaths;
  }


  public double getCumulativeDeathsPer100000() {
    return cumulativeDeathsPer100000;
  }

  public void setCumulativeDeathsPer100000(double cumulativeDeathsPer100000) {
    this.cumulativeDeathsPer100000 = cumulativeDeathsPer100000;
  }


  public long getNewCases() {
    return newCases;
  }

  public void setNewCases(long newCases) {
    this.newCases = newCases;
  }


  public long getNewDeaths() {
    return newDeaths;
  }

  public void setNewDeaths(long newDeaths) {
    this.newDeaths = newDeaths;
  }


  public double getNewCasesPer100000() {
    return newCasesPer100000;
  }

  public void setNewCasesPer100000(double newCasesPer100000) {
    this.newCasesPer100000 = newCasesPer100000;
  }


  public String getNewDeathsPer100000() {
    return newDeathsPer100000;
  }

  public void setNewDeathsPer100000(String newDeathsPer100000) {
    this.newDeathsPer100000 = newDeathsPer100000;
  }


  public double getNewCases7DayRollingAverage() {
    return newCases7DayRollingAverage;
  }

  public void setNewCases7DayRollingAverage(double newCases7DayRollingAverage) {
    this.newCases7DayRollingAverage = newCases7DayRollingAverage;
  }


  public double getNewDeaths7DayRollingAverage() {
    return newDeaths7DayRollingAverage;
  }

  public void setNewDeaths7DayRollingAverage(double newDeaths7DayRollingAverage) {
    this.newDeaths7DayRollingAverage = newDeaths7DayRollingAverage;
  }


  public String getJhCountyStatFipsCode() {
    return jhCountyStatFipsCode;
  }

  public void setJhCountyStatFipsCode(String jhCountyStatFipsCode) {
    this.jhCountyStatFipsCode = jhCountyStatFipsCode;
  }

}
