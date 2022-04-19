
package com.bh.assign.model.organization;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Phone {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Phone() {
    }

    /**
     * 
     * @param number
     * @param extension
     * @param countryCode
     */
    public Phone(String number, String extension, String countryCode) {
        super();
        this.number = number;
        this.extension = extension;
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
