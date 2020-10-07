package MOVD.model;


public class Governors {

  private long governorsPk;
  private String state;
  private String stateNameSlug;
  private String stateCode;
  private String stateCodeSlug;
  private String voteSmart;
  private String title;
  private String party;
  private String name;
  private String nameSlug;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nameSuffix;
  private String goesBy;
  private String pronunciation;
  private String gender;
  private String ethnicity;
  private String religion;
  private String openlyLgbtq;
  private String dateOfBirth;
  private String enteredOffice;
  private String termEnd;
  private String biography;
  private String phone;
  private String fax;
  private String latitude;
  private String longitude;
  private String addressComplete;
  private String addressNumber;
  private String addressPrefix;
  private String addressStreet;
  private String addressSecUnitType;
  private String addressSecUnitNum;
  private String addressCity;
  private String addressState;
  private String addressZipcode;
  private String addressType;
  private String website;
  private String contactPage;
  private String facebookUrl;
  private String twitterHandle;
  private String twitterUrl;
  private String photoUrl;


  public Governors(long governorsPk, String state, String stateNameSlug, String stateCode, String stateCodeSlug,
                   String voteSmart, String title, String party, String name, String nameSlug, String firstName, String middleName,
                   String lastName, String nameSuffix, String goesBy, String pronunciation, String gender, String ethnicity,
                   String religion, String openlyLgbtq, String dateOfBirth, String enteredOffice, String termEnd, String biography,
                   String phone, String fax, String latitude, String longitude, String addressComplete, String addressNumber,
                   String addressPrefix, String addressStreet, String addressSecUnitType, String addressSecUnitNum,
                   String addressCity, String addressState, String addressZipcode, String addressType, String website,
                   String contactPage, String facebookUrl, String twitterHandle, String twitterUrl, String photoUrl) {
    this.governorsPk = governorsPk;
    this.state = state;
    this.stateNameSlug = stateNameSlug;
    this.stateCode = stateCode;
    this.stateCodeSlug = stateCodeSlug;
    this.voteSmart = voteSmart;
    this.title = title;
    this.party = party;
    this.name = name;
    this.nameSlug = nameSlug;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nameSuffix = nameSuffix;
    this.goesBy = goesBy;
    this.pronunciation = pronunciation;
    this.gender = gender;
    this.ethnicity = ethnicity;
    this.religion = religion;
    this.openlyLgbtq = openlyLgbtq;
    this.dateOfBirth = dateOfBirth;
    this.enteredOffice = enteredOffice;
    this.termEnd = termEnd;
    this.biography = biography;
    this.phone = phone;
    this.fax = fax;
    this.latitude = latitude;
    this.longitude = longitude;
    this.addressComplete = addressComplete;
    this.addressNumber = addressNumber;
    this.addressPrefix = addressPrefix;
    this.addressStreet = addressStreet;
    this.addressSecUnitType = addressSecUnitType;
    this.addressSecUnitNum = addressSecUnitNum;
    this.addressCity = addressCity;
    this.addressState = addressState;
    this.addressZipcode = addressZipcode;
    this.addressType = addressType;
    this.website = website;
    this.contactPage = contactPage;
    this.facebookUrl = facebookUrl;
    this.twitterHandle = twitterHandle;
    this.twitterUrl = twitterUrl;
    this.photoUrl = photoUrl;
  }

  public Governors(String state, String stateNameSlug, String stateCode, String stateCodeSlug,
                   String voteSmart, String title, String party, String name, String nameSlug, String firstName, String middleName,
                   String lastName, String nameSuffix, String goesBy, String pronunciation, String gender, String ethnicity,
                   String religion, String openlyLgbtq, String dateOfBirth, String enteredOffice, String termEnd, String biography,
                   String phone, String fax, String latitude, String longitude, String addressComplete, String addressNumber,
                   String addressPrefix, String addressStreet, String addressSecUnitType, String addressSecUnitNum,
                   String addressCity, String addressState, String addressZipcode, String addressType, String website,
                   String contactPage, String facebookUrl, String twitterHandle, String twitterUrl, String photoUrl) {
    this.state = state;
    this.stateNameSlug = stateNameSlug;
    this.stateCode = stateCode;
    this.stateCodeSlug = stateCodeSlug;
    this.voteSmart = voteSmart;
    this.title = title;
    this.party = party;
    this.name = name;
    this.nameSlug = nameSlug;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nameSuffix = nameSuffix;
    this.goesBy = goesBy;
    this.pronunciation = pronunciation;
    this.gender = gender;
    this.ethnicity = ethnicity;
    this.religion = religion;
    this.openlyLgbtq = openlyLgbtq;
    this.dateOfBirth = dateOfBirth;
    this.enteredOffice = enteredOffice;
    this.termEnd = termEnd;
    this.biography = biography;
    this.phone = phone;
    this.fax = fax;
    this.latitude = latitude;
    this.longitude = longitude;
    this.addressComplete = addressComplete;
    this.addressNumber = addressNumber;
    this.addressPrefix = addressPrefix;
    this.addressStreet = addressStreet;
    this.addressSecUnitType = addressSecUnitType;
    this.addressSecUnitNum = addressSecUnitNum;
    this.addressCity = addressCity;
    this.addressState = addressState;
    this.addressZipcode = addressZipcode;
    this.addressType = addressType;
    this.website = website;
    this.contactPage = contactPage;
    this.facebookUrl = facebookUrl;
    this.twitterHandle = twitterHandle;
    this.twitterUrl = twitterUrl;
    this.photoUrl = photoUrl;
  }

  public long getGovernorsPk() {
    return governorsPk;
  }

  public void setGovernorsPk(long governorsPk) {
    this.governorsPk = governorsPk;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getStateNameSlug() {
    return stateNameSlug;
  }

  public void setStateNameSlug(String stateNameSlug) {
    this.stateNameSlug = stateNameSlug;
  }


  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }


  public String getStateCodeSlug() {
    return stateCodeSlug;
  }

  public void setStateCodeSlug(String stateCodeSlug) {
    this.stateCodeSlug = stateCodeSlug;
  }


  public String getVoteSmart() {
    return voteSmart;
  }

  public void setVoteSmart(String voteSmart) {
    this.voteSmart = voteSmart;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getParty() {
    return party;
  }

  public void setParty(String party) {
    this.party = party;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getNameSlug() {
    return nameSlug;
  }

  public void setNameSlug(String nameSlug) {
    this.nameSlug = nameSlug;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getNameSuffix() {
    return nameSuffix;
  }

  public void setNameSuffix(String nameSuffix) {
    this.nameSuffix = nameSuffix;
  }


  public String getGoesBy() {
    return goesBy;
  }

  public void setGoesBy(String goesBy) {
    this.goesBy = goesBy;
  }


  public String getPronunciation() {
    return pronunciation;
  }

  public void setPronunciation(String pronunciation) {
    this.pronunciation = pronunciation;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }


  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }


  public String getOpenlyLgbtq() {
    return openlyLgbtq;
  }

  public void setOpenlyLgbtq(String openlyLgbtq) {
    this.openlyLgbtq = openlyLgbtq;
  }


  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


  public String getEnteredOffice() {
    return enteredOffice;
  }

  public void setEnteredOffice(String enteredOffice) {
    this.enteredOffice = enteredOffice;
  }


  public String getTermEnd() {
    return termEnd;
  }

  public void setTermEnd(String termEnd) {
    this.termEnd = termEnd;
  }


  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
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


  public String getAddressComplete() {
    return addressComplete;
  }

  public void setAddressComplete(String addressComplete) {
    this.addressComplete = addressComplete;
  }


  public String getAddressNumber() {
    return addressNumber;
  }

  public void setAddressNumber(String addressNumber) {
    this.addressNumber = addressNumber;
  }


  public String getAddressPrefix() {
    return addressPrefix;
  }

  public void setAddressPrefix(String addressPrefix) {
    this.addressPrefix = addressPrefix;
  }


  public String getAddressStreet() {
    return addressStreet;
  }

  public void setAddressStreet(String addressStreet) {
    this.addressStreet = addressStreet;
  }


  public String getAddressSecUnitType() {
    return addressSecUnitType;
  }

  public void setAddressSecUnitType(String addressSecUnitType) {
    this.addressSecUnitType = addressSecUnitType;
  }


  public String getAddressSecUnitNum() {
    return addressSecUnitNum;
  }

  public void setAddressSecUnitNum(String addressSecUnitNum) {
    this.addressSecUnitNum = addressSecUnitNum;
  }


  public String getAddressCity() {
    return addressCity;
  }

  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }


  public String getAddressState() {
    return addressState;
  }

  public void setAddressState(String addressState) {
    this.addressState = addressState;
  }


  public String getAddressZipcode() {
    return addressZipcode;
  }

  public void setAddressZipcode(String addressZipcode) {
    this.addressZipcode = addressZipcode;
  }


  public String getAddressType() {
    return addressType;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }


  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }


  public String getContactPage() {
    return contactPage;
  }

  public void setContactPage(String contactPage) {
    this.contactPage = contactPage;
  }


  public String getFacebookUrl() {
    return facebookUrl;
  }

  public void setFacebookUrl(String facebookUrl) {
    this.facebookUrl = facebookUrl;
  }


  public String getTwitterHandle() {
    return twitterHandle;
  }

  public void setTwitterHandle(String twitterHandle) {
    this.twitterHandle = twitterHandle;
  }


  public String getTwitterUrl() {
    return twitterUrl;
  }

  public void setTwitterUrl(String twitterUrl) {
    this.twitterUrl = twitterUrl;
  }


  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

}
