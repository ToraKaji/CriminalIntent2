package edu.cnm.deepdive.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {


  private UUID mID;
  private String mTitle;
  private boolean mSolved;
  private Date mDate;

  public Crime() {
    mID = UUID.randomUUID();
    mDate = new Date();
  }

  public Date getmDate() {
    return mDate;
  }

  public void setmDate(Date mDate) {
    this.mDate = mDate;
  }

  public UUID getmID() {
    return mID;
  }

  public void setmID(UUID mID) {
    this.mID = mID;
  }

  public String getmTitle() {
    return mTitle;
  }

  public void setmTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  public boolean ismSolved() {
    return mSolved;
  }

  public void setmSolved(boolean mSolved) {
    this.mSolved = mSolved;
  }

}
