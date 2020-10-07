package MOVD.model;


public class JhCountyStat {

  private String fipsCode;
  private String lastUpdate;
  private String state;
  private String countyName;
  private String countyNameLong;
  private String latitude;
  private String longitude;
  private String nchsUrbanization;
  private String totalPopulation;


  public JhCountyStat(String fipsCode, String lastUpdate, String state, String countyName, String countyNameLong,
                      String latitude, String longitude, String nchsUrbanization, String totalPopulation) {
    this.fipsCode = fipsCode;
    this.lastUpdate = lastUpdate;
    this.state = state;
    this.countyName = countyName;
    this.countyNameLong = countyNameLong;
    this.latitude = latitude;
    this.longitude = longitude;
    this.nchsUrbanization = nchsUrbanization;
    this.totalPopulation = totalPopulation;
  }

  public JhCountyStat(String fipsCode) {
    this.fipsCode = fipsCode;
  }

  public String getFipsCode() {
    return fipsCode;
  }

  public void setFipsCode(String fipsCode) {
    this.fipsCode = fipsCode;
  }


  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName;
  }


  public String getCountyNameLong() {
    return countyNameLong;
  }

  public void setCountyNameLong(String countyNameLong) {
    this.countyNameLong = countyNameLong;
  }


  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }


  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }


  public String getNchsUrbanization() {
    return nchsUrbanization;
  }

  public void setNchsUrbanization(String nchsUrbanization) {
    this.nchsUrbanization = nchsUrbanization;
  }


  public String getTotalPopulation() {
    return totalPopulation;
  }

  public void setTotalPopulation(String totalPopulation) {
    this.totalPopulation = totalPopulation;
  }

}
