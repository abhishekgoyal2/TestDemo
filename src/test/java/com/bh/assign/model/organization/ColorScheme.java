
package com.bh.assign.model.organization;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ColorScheme {

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("primaryHover")
    @Expose
    private String primaryHover;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ColorScheme() {
    }

    /**
     * 
     * @param primaryHover
     * @param primary
     */
    public ColorScheme(String primary, String primaryHover) {
        super();
        this.primary = primary;
        this.primaryHover = primaryHover;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getPrimaryHover() {
        return primaryHover;
    }

    public void setPrimaryHover(String primaryHover) {
        this.primaryHover = primaryHover;
    }

}
