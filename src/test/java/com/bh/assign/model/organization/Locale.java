
package com.bh.assign.model.organization;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Locale {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("variant")
    @Expose
    private String variant;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Locale() {
    }

    /**
     * 
     * @param variant
     * @param language
     * @param region
     */
    public Locale(String language, String region, String variant) {
        super();
        this.language = language;
        this.region = region;
        this.variant = variant;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

}
