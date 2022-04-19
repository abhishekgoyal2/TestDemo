
package com.bh.assign.model.organization;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CreateOrgranization {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private Phone phone;
    @SerializedName("signInLink")
    @Expose
    private String signInLink;
    @SerializedName("websiteUrl")
    @Expose
    private String websiteUrl;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("branding")
    @Expose
    private Branding branding;
    @SerializedName("locale")
    @Expose
    private Locale locale;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateOrgranization() {
    }

    /**
     * 
     * @param address
     * @param phone
     * @param signInLink
     * @param websiteUrl
     * @param timezone
     * @param branding
     * @param name
     * @param locale
     * @param email
     */
    public CreateOrgranization(String name, String email, Phone phone, String signInLink, String websiteUrl, String timezone, Address address, Branding branding, Locale locale) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.signInLink = signInLink;
        this.websiteUrl = websiteUrl;
        this.timezone = timezone;
        this.address = address;
        this.branding = branding;
        this.locale = locale;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getSignInLink() {
        return signInLink;
    }

    public void setSignInLink(String signInLink) {
        this.signInLink = signInLink;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Branding getBranding() {
        return branding;
    }

    public void setBranding(Branding branding) {
        this.branding = branding;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
