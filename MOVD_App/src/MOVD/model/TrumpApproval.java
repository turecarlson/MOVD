package MOVD.model;

import java.util.Date;


public class TrumpApproval {

  private int trumpApprovalPk;
  private String president;
  private Date startDate;
  private Date endDate;
  private String pollster;
  private String grade;
  private int sampleSize;
  private double weight;
  private double influence;
  private float approve;
  private float disapprove;
  private float adjustedApprove;
  private float adjustedDisapprove;
  private String URL;
  private String pollId;
  private String questionId;
  private Date createDate;
  private Date timestamp;

  public TrumpApproval(int trumpApprovalPk, String president, Date startDate, Date endDate, String pollster,
                       String grade, int sampleSize, double weight, double influence, float approve, float disapprove,
                       float adjustedApprove, float adjustedDisapprove, String uRL, String pollId, String questionId,
                       Date createDate, Date timestamp) {
    this.trumpApprovalPk = trumpApprovalPk;
    this.president = president;
    this.startDate = startDate;
    this.endDate = endDate;
    this.pollster = pollster;
    this.grade = grade;
    this.sampleSize = sampleSize;
    this.weight = weight;
    this.influence = influence;
    this.approve = approve;
    this.disapprove = disapprove;
    this.adjustedApprove = adjustedApprove;
    this.adjustedDisapprove = adjustedDisapprove;
    this.URL = uRL;
    this.pollId = pollId;
    this.questionId = questionId;
    this.createDate = createDate;
    this.timestamp = timestamp;
  }

  public TrumpApproval(String president, Date startDate, Date endDate, String pollster,
                       String grade, int sampleSize, double weight, double influence, float approve, float disapprove,
                       float adjustedApprove, float adjustedDisapprove, String uRL, String pollId, String questionId,
                       Date createDate, Date timestamp) {
    this.president = president;
    this.startDate = startDate;
    this.endDate = endDate;
    this.pollster = pollster;
    this.grade = grade;
    this.sampleSize = sampleSize;
    this.weight = weight;
    this.influence = influence;
    this.approve = approve;
    this.disapprove = disapprove;
    this.adjustedApprove = adjustedApprove;
    this.adjustedDisapprove = adjustedDisapprove;
    this.URL = uRL;
    this.pollId = pollId;
    this.questionId = questionId;
    this.createDate = createDate;
    this.timestamp = timestamp;
  }

  public TrumpApproval(int trumpApprovalPk) {
    this.trumpApprovalPk = trumpApprovalPk;
  }

  public int getTrumpApprovalPk() {
    return trumpApprovalPk;
  }

  public void setTrumpApprovalPk(int trumpApprovalPk) {
    this.trumpApprovalPk = trumpApprovalPk;
  }

  public String getPresident() {
    return president;
  }

  public void setPresident(String president) {
    this.president = president;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getPollster() {
    return pollster;
  }

  public void setPollster(String pollster) {
    this.pollster = pollster;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public int getSampleSize() {
    return sampleSize;
  }

  public void setSampleSize(int sampleSize) {
    this.sampleSize = sampleSize;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getInfluence() {
    return influence;
  }

  public void setInfluence(double influence) {
    this.influence = influence;
  }

  public float getApprove() {
    return approve;
  }

  public void setApprove(float approve) {
    this.approve = approve;
  }

  public float getDisapprove() {
    return disapprove;
  }

  public void setDisapprove(float disapprove) {
    this.disapprove = disapprove;
  }

  public float getAdjustedApprove() {
    return adjustedApprove;
  }

  public void setAdjustedApprove(float adjustedApprove) {
    this.adjustedApprove = adjustedApprove;
  }

  public float getAdjustedDisapprove() {
    return adjustedDisapprove;
  }

  public void setAdjustedDisapprove(float adjustedDisapprove) {
    this.adjustedDisapprove = adjustedDisapprove;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String uRL) {
    URL = uRL;
  }

  public String getPollId() {
    return pollId;
  }

  public void setPollId(String pollId) {
    this.pollId = pollId;
  }

  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }


}
