package MOVD.model;

import java.sql.Date;

public class GoogleMobilityData {

  private long syntheticMobilityPk;
  private java.sql.Date date;
  private String country;
  private long rec;
  private long grocery;
  private long parks;
  private long transitStation;
  private long work;
  private long residential;
  private String jhCountyStatFipsCode;


  public GoogleMobilityData(long syntheticMobilityPk, Date date, String country, long rec, long grocery, long parks,
                            long transitStation, long work, long residential, String jhCountyStatFipsCode) {
    this.syntheticMobilityPk = syntheticMobilityPk;
    this.date = date;
    this.country = country;
    this.rec = rec;
    this.grocery = grocery;
    this.parks = parks;
    this.transitStation = transitStation;
    this.work = work;
    this.residential = residential;
    this.jhCountyStatFipsCode = jhCountyStatFipsCode;
  }

  public GoogleMobilityData(Date date, String country, long rec, long grocery, long parks,
                            long transitStation, long work, long residential, String jhCountyStatFipsCode) {
    this.date = date;
    this.country = country;
    this.rec = rec;
    this.grocery = grocery;
    this.parks = parks;
    this.transitStation = transitStation;
    this.work = work;
    this.residential = residential;
    this.jhCountyStatFipsCode = jhCountyStatFipsCode;
  }

  public GoogleMobilityData(long syntheticMobilityPk) {
    this.syntheticMobilityPk = syntheticMobilityPk;
  }

  public long getSyntheticMobilityPk() {
    return syntheticMobilityPk;
  }

  public void setSyntheticMobilityPk(long syntheticMobilityPk) {
    this.syntheticMobilityPk = syntheticMobilityPk;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public long getRec() {
    return rec;
  }

  public void setRec(long rec) {
    this.rec = rec;
  }


  public long getGrocery() {
    return grocery;
  }

  public void setGrocery(long grocery) {
    this.grocery = grocery;
  }


  public long getParks() {
    return parks;
  }

  public void setParks(long parks) {
    this.parks = parks;
  }


  public long getTransitStation() {
    return transitStation;
  }

  public void setTransitStation(long transitStation) {
    this.transitStation = transitStation;
  }


  public long getWork() {
    return work;
  }

  public void setWork(long work) {
    this.work = work;
  }


  public long getResidential() {
    return residential;
  }

  public void setResidential(long residential) {
    this.residential = residential;
  }


  public String getJhCountyStatFipsCode() {
    return jhCountyStatFipsCode;
  }

  public void setJhCountyStatFipsCode(String jhCountyStatFipsCode) {
    this.jhCountyStatFipsCode = jhCountyStatFipsCode;
  }

}
