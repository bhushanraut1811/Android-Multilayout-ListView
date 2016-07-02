package com.example.bhushanraut.multilayoutlist.modalclass;

/**
 * Created by bhushan.raut on 1/7/2016.
 * <p>
 *     Player class is modal class which holds data of Players
 * </p>
 */
public class Player {
    private String mName;
    private String mPlayerDetails;
    private String mNoOfMatches;
    private int mImage;
    private String mLink;
    private int mViewRowType;

    public int getmViewRowType() {
        return mViewRowType;
    }

    public void setmViewRowType(int mViewRowType) {
        this.mViewRowType = mViewRowType;
    }

    public String getmPlayerDetails() {
        return mPlayerDetails;
    }

    public void setmPlayerDetails(String mPlayerDetails) {
        this.mPlayerDetails = mPlayerDetails;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public Player(String mPlayerDetails, String mLink, int mViewRowType) {
        this.mPlayerDetails = mPlayerDetails;
        this.mViewRowType = mViewRowType;
        this.mLink = mLink;

    }

    public Player(int mImage, String mName, String mNumber, int mViewRowType) {
        this.mImage = mImage;
        this.mViewRowType = mViewRowType;
        this.mNoOfMatches = mNumber;
        this.mName = mName;
    }


    public int getmImage() {
        return mImage;
    }

    public String getmNoOfMatches() {
        return mNoOfMatches;
    }

    public void setmNoOfMatches(String mNoOfMatches) {
        this.mNoOfMatches = mNoOfMatches;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
