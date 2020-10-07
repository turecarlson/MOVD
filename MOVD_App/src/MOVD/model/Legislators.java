package MOVD.model;

import java.util.Date;

public class Legislators {
  private long legislatorsKey;
  private String lastName;
  private String firstName;
  private String middleName;
  private String suffix;
  private String nickname;
  private String fullName;
  private Date birthday;
  private String gender;
  private String type;
  private String state;
  private String district;
  private String senateClass;
  private String party;


  public Legislators(long legislatorsKey, String lastName, String firstName, String middleName, String suffix,
                     String nickname, String fullName, Date birthday, String gender, String type, String state, String district,
                     String senateClass, String party) {
    this.legislatorsKey = legislatorsKey;
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.suffix = suffix;
    this.nickname = nickname;
    this.fullName = fullName;
    this.birthday = birthday;
    this.gender = gender;
    this.type = type;
    this.state = state;
    this.district = district;
    this.senateClass = senateClass;
    this.party = party;
  }

  public Legislators(String lastName, String firstName, String middleName, String suffix,
                     String nickname, String fullName, Date birthday, String gender, String type, String state, String district,
                     String senateClass, String party) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.suffix = suffix;
    this.nickname = nickname;
    this.fullName = fullName;
    this.birthday = birthday;
    this.gender = gender;
    this.type = type;
    this.state = state;
    this.district = district;
    this.senateClass = senateClass;
    this.party = party;
  }

  public Legislators(long legislatorsKey) {
    this.legislatorsKey = legislatorsKey;
  }


  public long getLegislatorsKey() {
    return legislatorsKey;
  }

  public void setLegislatorsKey(long legislatorsKey) {
    this.legislatorsKey = legislatorsKey;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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


  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }


  public String getSenateClass() {
    return senateClass;
  }

  public void setSenateClass(String senateClass) {
    this.senateClass = senateClass;
  }


  public String getParty() {
    return party;
  }

  public void setParty(String party) {
    this.party = party;
  }

}
