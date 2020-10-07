package MOVD.model;


public class CensusRecord {

  private long censusDataPk;
  private String fipsCode;
  private String countyName;
  private long year;
  private long agegrp;
  private long totPop;
  private long totMale;
  private long totFemale;
  private long waMale;
  private long waFemale;
  private long baMale;
  private long baFemale;
  private long iaMale;
  private long iaFemale;
  private long aaMale;
  private long aaFemale;
  private long naMale;
  private long naFemale;
  private long tomMale;
  private long tomFemale;
  private long wacMale;
  private long wacFemale;
  private long bacMale;
  private long bacFemale;
  private long iacMale;
  private long iacFemale;
  private long aacMale;
  private long aacFemale;
  private long nacMale;
  private long nacFemale;
  private long nhMale;
  private long nhFemale;
  private long nhwaMale;
  private long nhwaFemale;
  private long nhbaMale;
  private long nhbaFemale;
  private long nhiaMale;
  private long nhiaFemale;
  private long nhaaMale;
  private long nhaaFemale;
  private long nhnaMale;
  private long nhnaFemale;
  private long nhtomMale;
  private long nhtomFemale;
  private long nhwacMale;
  private long nhwacFemale;
  private long nhbacMale;
  private long nhbacFemale;
  private long nhiacMale;
  private long nhiacFemale;
  private long nhaacMale;
  private long nhaacFemale;
  private long nhnacMale;
  private long nhnacFemale;
  private long hMale;
  private long hFemale;
  private long hwaMale;
  private long hwaFemale;
  private long hbaMale;
  private long hbaFemale;
  private long hiaMale;
  private long hiaFemale;
  private long haaMale;
  private long haaFemale;
  private long hnaMale;
  private long hnaFemale;
  private long htomMale;
  private long htomFemale;
  private long hwacMale;
  private long hwacFemale;
  private long hbacMale;
  private long hbacFemale;
  private long hiacMale;
  private long hiacFemale;
  private long haacMale;
  private long haacFemale;
  private long hnacMale;
  private long hnacFemale;

  public CensusRecord(long censusDataPk, String fipsCode, String countyName, long year, long agegrp, long totPop,
                      long totMale, long totFemale, long waMale, long waFemale, long baMale, long baFemale, long iaMale,
                      long iaFemale, long aaMale, long aaFemale, long naMale, long naFemale, long tomMale, long tomFemale,
                      long wacMale, long wacFemale, long bacMale, long bacFemale, long iacMale, long iacFemale, long aacMale,
                      long aacFemale, long nacMale, long nacFemale, long nhMale, long nhFemale, long nhwaMale, long nhwaFemale,
                      long nhbaMale, long nhbaFemale, long nhiaMale, long nhiaFemale, long nhaaMale, long nhaaFemale, long nhnaMale,
                      long nhnaFemale, long nhtomMale, long nhtomFemale, long nhwacMale, long nhwacFemale, long nhbacMale,
                      long nhbacFemale, long nhiacMale, long nhiacFemale, long nhaacMale, long nhaacFemale, long nhnacMale,
                      long nhnacFemale, long hMale, long hFemale, long hwaMale, long hwaFemale, long hbaMale, long hbaFemale,
                      long hiaMale, long hiaFemale, long haaMale, long haaFemale, long hnaMale, long hnaFemale, long htomMale,
                      long htomFemale, long hwacMale, long hwacFemale, long hbacMale, long hbacFemale, long hiacMale, long hiacFemale,
                      long haacMale, long haacFemale, long hnacMale, long hnacFemale) {
    this.censusDataPk = censusDataPk;
    this.fipsCode = fipsCode;
    this.countyName = countyName;
    this.year = year;
    this.agegrp = agegrp;
    this.totPop = totPop;
    this.totMale = totMale;
    this.totFemale = totFemale;
    this.waMale = waMale;
    this.waFemale = waFemale;
    this.baMale = baMale;
    this.baFemale = baFemale;
    this.iaMale = iaMale;
    this.iaFemale = iaFemale;
    this.aaMale = aaMale;
    this.aaFemale = aaFemale;
    this.naMale = naMale;
    this.naFemale = naFemale;
    this.tomMale = tomMale;
    this.tomFemale = tomFemale;
    this.wacMale = wacMale;
    this.wacFemale = wacFemale;
    this.bacMale = bacMale;
    this.bacFemale = bacFemale;
    this.iacMale = iacMale;
    this.iacFemale = iacFemale;
    this.aacMale = aacMale;
    this.aacFemale = aacFemale;
    this.nacMale = nacMale;
    this.nacFemale = nacFemale;
    this.nhMale = nhMale;
    this.nhFemale = nhFemale;
    this.nhwaMale = nhwaMale;
    this.nhwaFemale = nhwaFemale;
    this.nhbaMale = nhbaMale;
    this.nhbaFemale = nhbaFemale;
    this.nhiaMale = nhiaMale;
    this.nhiaFemale = nhiaFemale;
    this.nhaaMale = nhaaMale;
    this.nhaaFemale = nhaaFemale;
    this.nhnaMale = nhnaMale;
    this.nhnaFemale = nhnaFemale;
    this.nhtomMale = nhtomMale;
    this.nhtomFemale = nhtomFemale;
    this.nhwacMale = nhwacMale;
    this.nhwacFemale = nhwacFemale;
    this.nhbacMale = nhbacMale;
    this.nhbacFemale = nhbacFemale;
    this.nhiacMale = nhiacMale;
    this.nhiacFemale = nhiacFemale;
    this.nhaacMale = nhaacMale;
    this.nhaacFemale = nhaacFemale;
    this.nhnacMale = nhnacMale;
    this.nhnacFemale = nhnacFemale;
    this.hMale = hMale;
    this.hFemale = hFemale;
    this.hwaMale = hwaMale;
    this.hwaFemale = hwaFemale;
    this.hbaMale = hbaMale;
    this.hbaFemale = hbaFemale;
    this.hiaMale = hiaMale;
    this.hiaFemale = hiaFemale;
    this.haaMale = haaMale;
    this.haaFemale = haaFemale;
    this.hnaMale = hnaMale;
    this.hnaFemale = hnaFemale;
    this.htomMale = htomMale;
    this.htomFemale = htomFemale;
    this.hwacMale = hwacMale;
    this.hwacFemale = hwacFemale;
    this.hbacMale = hbacMale;
    this.hbacFemale = hbacFemale;
    this.hiacMale = hiacMale;
    this.hiacFemale = hiacFemale;
    this.haacMale = haacMale;
    this.haacFemale = haacFemale;
    this.hnacMale = hnacMale;
    this.hnacFemale = hnacFemale;
  }

  public CensusRecord(String fipsCode, String countyName, long year, long agegrp, long totPop,
                      long totMale, long totFemale, long waMale, long waFemale, long baMale,
                      long baFemale, long iaMale, long iaFemale, long aaMale, long aaFemale,
                      long naMale, long naFemale, long tomMale, long tomFemale, long wacMale,
                      long wacFemale, long bacMale, long bacFemale, long iacMale, long iacFemale,
                      long aacMale, long aacFemale, long nacMale, long nacFemale, long nhMale,
                      long nhFemale, long nhwaMale, long nhwaFemale, long nhbaMale,
                      long nhbaFemale, long nhiaMale, long nhiaFemale, long nhaaMale,
                      long nhaaFemale, long nhnaMale, long nhnaFemale, long nhtomMale,
                      long nhtomFemale, long nhwacMale, long nhwacFemale, long nhbacMale,
                      long nhbacFemale, long nhiacMale, long nhiacFemale, long nhaacMale,
                      long nhaacFemale, long nhnacMale, long nhnacFemale, long hMale,
                      long hFemale, long hwaMale, long hwaFemale, long hbaMale, long hbaFemale,
                      long hiaMale, long hiaFemale, long haaMale, long haaFemale, long hnaMale,
                      long hnaFemale, long htomMale, long htomFemale, long hwacMale,
                      long hwacFemale, long hbacMale, long hbacFemale, long hiacMale,
                      long hiacFemale, long haacMale, long haacFemale, long hnacMale,
                      long hnacFemale) {

    this.fipsCode = fipsCode;
    this.countyName = countyName;
    this.year = year;
    this.agegrp = agegrp;
    this.totPop = totPop;
    this.totMale = totMale;
    this.totFemale = totFemale;
    this.waMale = waMale;
    this.waFemale = waFemale;
    this.baMale = baMale;
    this.baFemale = baFemale;
    this.iaMale = iaMale;
    this.iaFemale = iaFemale;
    this.aaMale = aaMale;
    this.aaFemale = aaFemale;
    this.naMale = naMale;
    this.naFemale = naFemale;
    this.tomMale = tomMale;
    this.tomFemale = tomFemale;
    this.wacMale = wacMale;
    this.wacFemale = wacFemale;
    this.bacMale = bacMale;
    this.bacFemale = bacFemale;
    this.iacMale = iacMale;
    this.iacFemale = iacFemale;
    this.aacMale = aacMale;
    this.aacFemale = aacFemale;
    this.nacMale = nacMale;
    this.nacFemale = nacFemale;
    this.nhMale = nhMale;
    this.nhFemale = nhFemale;
    this.nhwaMale = nhwaMale;
    this.nhwaFemale = nhwaFemale;
    this.nhbaMale = nhbaMale;
    this.nhbaFemale = nhbaFemale;
    this.nhiaMale = nhiaMale;
    this.nhiaFemale = nhiaFemale;
    this.nhaaMale = nhaaMale;
    this.nhaaFemale = nhaaFemale;
    this.nhnaMale = nhnaMale;
    this.nhnaFemale = nhnaFemale;
    this.nhtomMale = nhtomMale;
    this.nhtomFemale = nhtomFemale;
    this.nhwacMale = nhwacMale;
    this.nhwacFemale = nhwacFemale;
    this.nhbacMale = nhbacMale;
    this.nhbacFemale = nhbacFemale;
    this.nhiacMale = nhiacMale;
    this.nhiacFemale = nhiacFemale;
    this.nhaacMale = nhaacMale;
    this.nhaacFemale = nhaacFemale;
    this.nhnacMale = nhnacMale;
    this.nhnacFemale = nhnacFemale;
    this.hMale = hMale;
    this.hFemale = hFemale;
    this.hwaMale = hwaMale;
    this.hwaFemale = hwaFemale;
    this.hbaMale = hbaMale;
    this.hbaFemale = hbaFemale;
    this.hiaMale = hiaMale;
    this.hiaFemale = hiaFemale;
    this.haaMale = haaMale;
    this.haaFemale = haaFemale;
    this.hnaMale = hnaMale;
    this.hnaFemale = hnaFemale;
    this.htomMale = htomMale;
    this.htomFemale = htomFemale;
    this.hwacMale = hwacMale;
    this.hwacFemale = hwacFemale;
    this.hbacMale = hbacMale;
    this.hbacFemale = hbacFemale;
    this.hiacMale = hiacMale;
    this.hiacFemale = hiacFemale;
    this.haacMale = haacMale;
    this.haacFemale = haacFemale;
    this.hnacMale = hnacMale;
    this.hnacFemale = hnacFemale;
  }

  public long getCensusDataPk() {
    return censusDataPk;
  }

  public void setCensusDataPk(long censusDataPk) {
    this.censusDataPk = censusDataPk;
  }


  public String getFipsCode() {
    return fipsCode;
  }

  public void setFipsCode(String fipsCode) {
    this.fipsCode = fipsCode;
  }


  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }


  public long getAgegrp() {
    return agegrp;
  }

  public void setAgegrp(long agegrp) {
    this.agegrp = agegrp;
  }


  public long getTotPop() {
    return totPop;
  }

  public void setTotPop(long totPop) {
    this.totPop = totPop;
  }


  public long getTotMale() {
    return totMale;
  }

  public void setTotMale(long totMale) {
    this.totMale = totMale;
  }


  public long getTotFemale() {
    return totFemale;
  }

  public void setTotFemale(long totFemale) {
    this.totFemale = totFemale;
  }


  public long getWaMale() {
    return waMale;
  }

  public void setWaMale(long waMale) {
    this.waMale = waMale;
  }


  public long getWaFemale() {
    return waFemale;
  }

  public void setWaFemale(long waFemale) {
    this.waFemale = waFemale;
  }


  public long getBaMale() {
    return baMale;
  }

  public void setBaMale(long baMale) {
    this.baMale = baMale;
  }


  public long getBaFemale() {
    return baFemale;
  }

  public void setBaFemale(long baFemale) {
    this.baFemale = baFemale;
  }


  public long getIaMale() {
    return iaMale;
  }

  public void setIaMale(long iaMale) {
    this.iaMale = iaMale;
  }


  public long getIaFemale() {
    return iaFemale;
  }

  public void setIaFemale(long iaFemale) {
    this.iaFemale = iaFemale;
  }


  public long getAaMale() {
    return aaMale;
  }

  public void setAaMale(long aaMale) {
    this.aaMale = aaMale;
  }


  public long getAaFemale() {
    return aaFemale;
  }

  public void setAaFemale(long aaFemale) {
    this.aaFemale = aaFemale;
  }


  public long getNaMale() {
    return naMale;
  }

  public void setNaMale(long naMale) {
    this.naMale = naMale;
  }


  public long getNaFemale() {
    return naFemale;
  }

  public void setNaFemale(long naFemale) {
    this.naFemale = naFemale;
  }


  public long getTomMale() {
    return tomMale;
  }

  public void setTomMale(long tomMale) {
    this.tomMale = tomMale;
  }


  public long getTomFemale() {
    return tomFemale;
  }

  public void setTomFemale(long tomFemale) {
    this.tomFemale = tomFemale;
  }


  public long getWacMale() {
    return wacMale;
  }

  public void setWacMale(long wacMale) {
    this.wacMale = wacMale;
  }


  public long getWacFemale() {
    return wacFemale;
  }

  public void setWacFemale(long wacFemale) {
    this.wacFemale = wacFemale;
  }


  public long getBacMale() {
    return bacMale;
  }

  public void setBacMale(long bacMale) {
    this.bacMale = bacMale;
  }


  public long getBacFemale() {
    return bacFemale;
  }

  public void setBacFemale(long bacFemale) {
    this.bacFemale = bacFemale;
  }


  public long getIacMale() {
    return iacMale;
  }

  public void setIacMale(long iacMale) {
    this.iacMale = iacMale;
  }


  public long getIacFemale() {
    return iacFemale;
  }

  public void setIacFemale(long iacFemale) {
    this.iacFemale = iacFemale;
  }


  public long getAacMale() {
    return aacMale;
  }

  public void setAacMale(long aacMale) {
    this.aacMale = aacMale;
  }


  public long getAacFemale() {
    return aacFemale;
  }

  public void setAacFemale(long aacFemale) {
    this.aacFemale = aacFemale;
  }


  public long getNacMale() {
    return nacMale;
  }

  public void setNacMale(long nacMale) {
    this.nacMale = nacMale;
  }


  public long getNacFemale() {
    return nacFemale;
  }

  public void setNacFemale(long nacFemale) {
    this.nacFemale = nacFemale;
  }


  public long getNhMale() {
    return nhMale;
  }

  public void setNhMale(long nhMale) {
    this.nhMale = nhMale;
  }


  public long getNhFemale() {
    return nhFemale;
  }

  public void setNhFemale(long nhFemale) {
    this.nhFemale = nhFemale;
  }


  public long getNhwaMale() {
    return nhwaMale;
  }

  public void setNhwaMale(long nhwaMale) {
    this.nhwaMale = nhwaMale;
  }


  public long getNhwaFemale() {
    return nhwaFemale;
  }

  public void setNhwaFemale(long nhwaFemale) {
    this.nhwaFemale = nhwaFemale;
  }


  public long getNhbaMale() {
    return nhbaMale;
  }

  public void setNhbaMale(long nhbaMale) {
    this.nhbaMale = nhbaMale;
  }


  public long getNhbaFemale() {
    return nhbaFemale;
  }

  public void setNhbaFemale(long nhbaFemale) {
    this.nhbaFemale = nhbaFemale;
  }


  public long getNhiaMale() {
    return nhiaMale;
  }

  public void setNhiaMale(long nhiaMale) {
    this.nhiaMale = nhiaMale;
  }


  public long getNhiaFemale() {
    return nhiaFemale;
  }

  public void setNhiaFemale(long nhiaFemale) {
    this.nhiaFemale = nhiaFemale;
  }


  public long getNhaaMale() {
    return nhaaMale;
  }

  public void setNhaaMale(long nhaaMale) {
    this.nhaaMale = nhaaMale;
  }


  public long getNhaaFemale() {
    return nhaaFemale;
  }

  public void setNhaaFemale(long nhaaFemale) {
    this.nhaaFemale = nhaaFemale;
  }


  public long getNhnaMale() {
    return nhnaMale;
  }

  public void setNhnaMale(long nhnaMale) {
    this.nhnaMale = nhnaMale;
  }


  public long getNhnaFemale() {
    return nhnaFemale;
  }

  public void setNhnaFemale(long nhnaFemale) {
    this.nhnaFemale = nhnaFemale;
  }


  public long getNhtomMale() {
    return nhtomMale;
  }

  public void setNhtomMale(long nhtomMale) {
    this.nhtomMale = nhtomMale;
  }


  public long getNhtomFemale() {
    return nhtomFemale;
  }

  public void setNhtomFemale(long nhtomFemale) {
    this.nhtomFemale = nhtomFemale;
  }


  public long getNhwacMale() {
    return nhwacMale;
  }

  public void setNhwacMale(long nhwacMale) {
    this.nhwacMale = nhwacMale;
  }


  public long getNhwacFemale() {
    return nhwacFemale;
  }

  public void setNhwacFemale(long nhwacFemale) {
    this.nhwacFemale = nhwacFemale;
  }


  public long getNhbacMale() {
    return nhbacMale;
  }

  public void setNhbacMale(long nhbacMale) {
    this.nhbacMale = nhbacMale;
  }


  public long getNhbacFemale() {
    return nhbacFemale;
  }

  public void setNhbacFemale(long nhbacFemale) {
    this.nhbacFemale = nhbacFemale;
  }


  public long getNhiacMale() {
    return nhiacMale;
  }

  public void setNhiacMale(long nhiacMale) {
    this.nhiacMale = nhiacMale;
  }


  public long getNhiacFemale() {
    return nhiacFemale;
  }

  public void setNhiacFemale(long nhiacFemale) {
    this.nhiacFemale = nhiacFemale;
  }


  public long getNhaacMale() {
    return nhaacMale;
  }

  public void setNhaacMale(long nhaacMale) {
    this.nhaacMale = nhaacMale;
  }


  public long getNhaacFemale() {
    return nhaacFemale;
  }

  public void setNhaacFemale(long nhaacFemale) {
    this.nhaacFemale = nhaacFemale;
  }


  public long getNhnacMale() {
    return nhnacMale;
  }

  public void setNhnacMale(long nhnacMale) {
    this.nhnacMale = nhnacMale;
  }


  public long getNhnacFemale() {
    return nhnacFemale;
  }

  public void setNhnacFemale(long nhnacFemale) {
    this.nhnacFemale = nhnacFemale;
  }


  public long getHMale() {
    return hMale;
  }

  public void setHMale(long hMale) {
    this.hMale = hMale;
  }


  public long getHFemale() {
    return hFemale;
  }

  public void setHFemale(long hFemale) {
    this.hFemale = hFemale;
  }


  public long getHwaMale() {
    return hwaMale;
  }

  public void setHwaMale(long hwaMale) {
    this.hwaMale = hwaMale;
  }


  public long getHwaFemale() {
    return hwaFemale;
  }

  public void setHwaFemale(long hwaFemale) {
    this.hwaFemale = hwaFemale;
  }


  public long getHbaMale() {
    return hbaMale;
  }

  public void setHbaMale(long hbaMale) {
    this.hbaMale = hbaMale;
  }


  public long getHbaFemale() {
    return hbaFemale;
  }

  public void setHbaFemale(long hbaFemale) {
    this.hbaFemale = hbaFemale;
  }


  public long getHiaMale() {
    return hiaMale;
  }

  public void setHiaMale(long hiaMale) {
    this.hiaMale = hiaMale;
  }


  public long getHiaFemale() {
    return hiaFemale;
  }

  public void setHiaFemale(long hiaFemale) {
    this.hiaFemale = hiaFemale;
  }


  public long getHaaMale() {
    return haaMale;
  }

  public void setHaaMale(long haaMale) {
    this.haaMale = haaMale;
  }


  public long getHaaFemale() {
    return haaFemale;
  }

  public void setHaaFemale(long haaFemale) {
    this.haaFemale = haaFemale;
  }


  public long getHnaMale() {
    return hnaMale;
  }

  public void setHnaMale(long hnaMale) {
    this.hnaMale = hnaMale;
  }


  public long getHnaFemale() {
    return hnaFemale;
  }

  public void setHnaFemale(long hnaFemale) {
    this.hnaFemale = hnaFemale;
  }


  public long getHtomMale() {
    return htomMale;
  }

  public void setHtomMale(long htomMale) {
    this.htomMale = htomMale;
  }


  public long getHtomFemale() {
    return htomFemale;
  }

  public void setHtomFemale(long htomFemale) {
    this.htomFemale = htomFemale;
  }


  public long getHwacMale() {
    return hwacMale;
  }

  public void setHwacMale(long hwacMale) {
    this.hwacMale = hwacMale;
  }


  public long getHwacFemale() {
    return hwacFemale;
  }

  public void setHwacFemale(long hwacFemale) {
    this.hwacFemale = hwacFemale;
  }


  public long getHbacMale() {
    return hbacMale;
  }

  public void setHbacMale(long hbacMale) {
    this.hbacMale = hbacMale;
  }


  public long getHbacFemale() {
    return hbacFemale;
  }

  public void setHbacFemale(long hbacFemale) {
    this.hbacFemale = hbacFemale;
  }


  public long getHiacMale() {
    return hiacMale;
  }

  public void setHiacMale(long hiacMale) {
    this.hiacMale = hiacMale;
  }


  public long getHiacFemale() {
    return hiacFemale;
  }

  public void setHiacFemale(long hiacFemale) {
    this.hiacFemale = hiacFemale;
  }


  public long getHaacMale() {
    return haacMale;
  }

  public void setHaacMale(long haacMale) {
    this.haacMale = haacMale;
  }


  public long getHaacFemale() {
    return haacFemale;
  }

  public void setHaacFemale(long haacFemale) {
    this.haacFemale = haacFemale;
  }


  public long getHnacMale() {
    return hnacMale;
  }

  public void setHnacMale(long hnacMale) {
    this.hnacMale = hnacMale;
  }


  public long getHnacFemale() {
    return hnacFemale;
  }

  public void setHnacFemale(long hnacFemale) {
    this.hnacFemale = hnacFemale;
  }

}
