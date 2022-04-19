
package com.bh.assign.model.organization;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Branding {

    @SerializedName("colorScheme")
    @Expose
    private ColorScheme colorScheme;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Branding() {
    }

    /**
     * 
     * @param colorScheme
     */
    public Branding(ColorScheme colorScheme) {
        super();
        this.colorScheme = colorScheme;
    }

    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

}
