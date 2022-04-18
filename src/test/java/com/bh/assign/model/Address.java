
package com.bh.assign.model;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Address {

    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("provinceCode")
    @Expose
    private String provinceCode;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("provinceName")
    @Expose
    private String provinceName;
    @SerializedName("region")
    @Expose
    private String region;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param address2
     * @param city
     * @param address1
     * @param countryCode
     * @param provinceCode
     * @param postalCode
     * @param provinceName
     * @param region
     */
    public Address(String address1, String address2, String city, String countryCode, String provinceCode, String postalCode, String provinceName, String region) {
        super();
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.countryCode = countryCode;
        this.provinceCode = provinceCode;
        this.postalCode = postalCode;
        this.provinceName = provinceName;
        this.region = region;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
