
package com.bh.assign.model;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Paymentmethod {

    @SerializedName("lastFour")
    @Expose
    private String lastFour;
    @SerializedName("tokenId")
    @Expose
    private String tokenId;
    @SerializedName("payorProfileId")
    @Expose
    private String payorProfileId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subType")
    @Expose
    private String subType;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("expiryMonth")
    @Expose
    private String expiryMonth;
    @SerializedName("expiryYear")
    @Expose
    private Integer expiryYear;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("accountHolderName")
    @Expose
    private String accountHolderName;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Paymentmethod() {
    }

    /**
     * 
     * @param lastFour
     * @param metadata
     * @param address
     * @param tokenId
     * @param expiryMonth
     * @param alias
     * @param subType
     * @param expiryYear
     * @param type
     * @param brand
     * @param accountHolderName
     * @param payorProfileId
     */
    public Paymentmethod(String lastFour, String tokenId, String payorProfileId, String type, String subType, String brand, String expiryMonth, Integer expiryYear, String alias, String accountHolderName, Address address, Metadata metadata) {
        super();
        this.lastFour = lastFour;
        this.tokenId = tokenId;
        this.payorProfileId = payorProfileId;
        this.type = type;
        this.subType = subType;
        this.brand = brand;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.alias = alias;
        this.accountHolderName = accountHolderName;
        this.address = address;
        this.metadata = metadata;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getPayorProfileId() {
        return payorProfileId;
    }

    public void setPayorProfileId(String payorProfileId) {
        this.payorProfileId = payorProfileId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
