package MOVD.model;


public class State {

  private String stateName;
  private String slug;
  private String code;
  private String nickname;
  private String website;
  private String admissionDate;
  private String admissionNumber;
  private String capitalCity;
  private String capitalUrl;
  private String population;
  private String populationRank;
  private String constitutionUrl;
  private String stateFlagUrl;
  private String stateSealUrl;
  private String mapImageUrl;
  private String landscapeBackgroundUrl;
  private String skylineBackgroundUrl;
  private String twitterUrl;
  private String facebookUrl;

  public State(String stateName, String slug, String code, String nickname, String website, String admissionDate,
               String admissionNumber, String capitalCity, String capitalUrl, String population, String populationRank,
               String constitutionUrl, String stateFlagUrl, String stateSealUrl, String mapImageUrl,
               String landscapeBackgroundUrl, String skylineBackgroundUrl, String twitterUrl, String facebookUrl) {
    this.stateName = stateName;
    this.slug = slug;
    this.code = code;
    this.nickname = nickname;
    this.website = website;
    this.admissionDate = admissionDate;
    this.admissionNumber = admissionNumber;
    this.capitalCity = capitalCity;
    this.capitalUrl = capitalUrl;
    this.population = population;
    this.populationRank = populationRank;
    this.constitutionUrl = constitutionUrl;
    this.stateFlagUrl = stateFlagUrl;
    this.stateSealUrl = stateSealUrl;
    this.mapImageUrl = mapImageUrl;
    this.landscapeBackgroundUrl = landscapeBackgroundUrl;
    this.skylineBackgroundUrl = skylineBackgroundUrl;
    this.twitterUrl = twitterUrl;
    this.facebookUrl = facebookUrl;
  }


  public State(String stateName) {
    this.stateName = stateName;
  }


  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }


  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }


  public String getAdmissionDate() {
    return admissionDate;
  }

  public void setAdmissionDate(String admissionDate) {
    this.admissionDate = admissionDate;
  }


  public String getAdmissionNumber() {
    return admissionNumber;
  }

  public void setAdmissionNumber(String admissionNumber) {
    this.admissionNumber = admissionNumber;
  }


  public String getCapitalCity() {
    return capitalCity;
  }

  public void setCapitalCity(String capitalCity) {
    this.capitalCity = capitalCity;
  }


  public String getCapitalUrl() {
    return capitalUrl;
  }

  public void setCapitalUrl(String capitalUrl) {
    this.capitalUrl = capitalUrl;
  }


  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }


  public String getPopulationRank() {
    return populationRank;
  }

  public void setPopulationRank(String populationRank) {
    this.populationRank = populationRank;
  }


  public String getConstitutionUrl() {
    return constitutionUrl;
  }

  public void setConstitutionUrl(String constitutionUrl) {
    this.constitutionUrl = constitutionUrl;
  }


  public String getStateFlagUrl() {
    return stateFlagUrl;
  }

  public void setStateFlagUrl(String stateFlagUrl) {
    this.stateFlagUrl = stateFlagUrl;
  }


  public String getStateSealUrl() {
    return stateSealUrl;
  }

  public void setStateSealUrl(String stateSealUrl) {
    this.stateSealUrl = stateSealUrl;
  }


  public String getMapImageUrl() {
    return mapImageUrl;
  }

  public void setMapImageUrl(String mapImageUrl) {
    this.mapImageUrl = mapImageUrl;
  }


  public String getLandscapeBackgroundUrl() {
    return landscapeBackgroundUrl;
  }

  public void setLandscapeBackgroundUrl(String landscapeBackgroundUrl) {
    this.landscapeBackgroundUrl = landscapeBackgroundUrl;
  }


  public String getSkylineBackgroundUrl() {
    return skylineBackgroundUrl;
  }

  public void setSkylineBackgroundUrl(String skylineBackgroundUrl) {
    this.skylineBackgroundUrl = skylineBackgroundUrl;
  }


  public String getTwitterUrl() {
    return twitterUrl;
  }

  public void setTwitterUrl(String twitterUrl) {
    this.twitterUrl = twitterUrl;
  }


  public String getFacebookUrl() {
    return facebookUrl;
  }

  public void setFacebookUrl(String facebookUrl) {
    this.facebookUrl = facebookUrl;
  }

}
