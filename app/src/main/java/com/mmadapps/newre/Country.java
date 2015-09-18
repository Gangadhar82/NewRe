package com.mmadapps.newre;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gangadhar.g on 9/18/2015.
 */
public class Country {


    @SerializedName("name")
    public String name;

//    @SerializedName("Capital")
//    public String Capital;

//    @SerializedName("region")
//    public String region;
//
//    @SerializedName("population")
//    public int population;

    @SerializedName("area")
    public int area;

//    @SerializedName("borders")
//    public int borders;
    @SerializedName("nativeName")
    public  String nativeName;

    @SerializedName("translations")
    public translations trans;

    public class translations{
        @SerializedName("de")
        public String de;
        @SerializedName("es")
        public String es;
        @SerializedName("ja")
        public String ja;


    }

    }



