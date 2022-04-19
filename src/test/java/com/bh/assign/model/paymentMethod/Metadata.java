
package com.bh.assign.model;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Metadata {

    @SerializedName("applicationReferenceId")
    @Expose
    private String applicationReferenceId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metadata() {
    }

    /**
     * 
     * @param applicationReferenceId
     */
    public Metadata(String applicationReferenceId) {
        super();
        this.applicationReferenceId = applicationReferenceId;
    }

    public String getApplicationReferenceId() {
        return applicationReferenceId;
    }

    public void setApplicationReferenceId(String applicationReferenceId) {
        this.applicationReferenceId = applicationReferenceId;
    }

}
