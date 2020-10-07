package MOVD.model;

import java.util.Date;

public class SP500 {
  private Date date;
  private float marketValue;

  public SP500(Date date, float marketValue) {
    this.date = date;
    this.marketValue = marketValue;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public float getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(float marketValue) {
    this.marketValue = marketValue;
  }

}
