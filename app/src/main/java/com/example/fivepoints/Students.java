package com.example.fivepoints;

import java.util.Date;

public class Students {

    String sName;
    String sImage;
    String sBd;


    public Students() {
    }

    public Students(String sName, String sImage, String sBd) {
        this.sName = sName;
        this.sImage = sImage;
        this.sBd = sBd;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsBd() {
        return sBd;
    }

    public void setsBd(String sBd) {
        this.sBd = sBd;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sName='" + sName + '\'' +
                ", sImage='" + sImage + '\'' +
                ", sBd=" + sBd +
                '}';
    }
}
