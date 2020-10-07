package MOVD.model;

import java.sql.Date;

public class UnemploymentStat {

  private long unemploymentPk;
  private String fipsCode;
  private java.sql.Date period;
  private long laborForce;
  private long employed;
  private long unemployed;
  private double unemploymentRatePercentage;


  public UnemploymentStat(long unemploymentPk, String fipsCode, Date period, long laborForce, long employed, long unemployed,
                          double unemploymentRatePercentage) {
    this.unemploymentPk = unemploymentPk;
    this.fipsCode = fipsCode;
    this.period = period;
    this.laborForce = laborForce;
    this.employed = employed;
    this.unemployed = unemployed;
    this.unemploymentRatePercentage = unemploymentRatePercentage;
  }

  public UnemploymentStat(String fipsCode, Date period, long laborForce, long employed, long unemployed,
                          double unemploymentRatePercentage) {
    this.fipsCode = fipsCode;
    this.period = period;
    this.laborForce = laborForce;
    this.employed = employed;
    this.unemployed = unemployed;
    this.unemploymentRatePercentage = unemploymentRatePercentage;
  }

  public long getUnemploymentPk() {
    return unemploymentPk;
  }

  public void setUnemploymentPk(long unemploymentPk) {
    this.unemploymentPk = unemploymentPk;
  }


  public String getFipsCode() {
    return fipsCode;
  }

  public void setFipsCode(String fipsCode) {
    this.fipsCode = fipsCode;
  }


  public java.sql.Date getPeriod() {
    return period;
  }

  public void setPeriod(java.sql.Date period) {
    this.period = period;
  }


  public long getLaborForce() {
    return laborForce;
  }

  public void setLaborForce(long laborForce) {
    this.laborForce = laborForce;
  }


  public long getEmployed() {
    return employed;
  }

  public void setEmployed(long employed) {
    this.employed = employed;
  }


  public long getUnemployed() {
    return unemployed;
  }

  public void setUnemployed(long unemployed) {
    this.unemployed = unemployed;
  }


  public double getUnemploymentRatePercentage() {
    return unemploymentRatePercentage;
  }

  public void setUnemploymentRatePercentage(double unemploymentRatePercentage) {
    this.unemploymentRatePercentage = unemploymentRatePercentage;
  }

}
