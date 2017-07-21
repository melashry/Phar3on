package com.example.aya_moh.phar3on;

import java.io.Serializable;

/**
 * Created by Aya_Moh on 7/2/2017.
 */

public class StatusModel implements Serializable{
    private String mName;
    private String aDscription;
    private String eDscription;
    private String fDscription;
    private String iDscription;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getADscription() {
        return aDscription;
    }

    public void setADscription(String Adscription) {
        aDscription = Adscription;
    }
    public String getEDscription() {
        return eDscription;
    }

    public void setEDscription(String Edscription) {
        eDscription = Edscription;
    }
    public String getFDscription() {
        return fDscription;
    }

    public void setFDscription(String Fdscription) {
        fDscription = Fdscription;
    }
    public String getIMAGE() {
        return iDscription;
    }

    public void setIMAGE(String image) {
        iDscription = image;
    }




}