package ru.otus.java.pro.oldstructure;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "first",
        "handle_id",
        "image_path",
        "last",
        "middle",
        "phone_number",
        "service",
        "thumb_path"
})
@Generated("jsonschema2pojo")
public class Member {

    @JsonProperty("first")
    private String first;
    @JsonProperty("handle_id")
    private Integer handleId;
    @JsonProperty("image_path")
    private String imagePath;
    @JsonProperty("last")
    private String last;
    @JsonProperty("middle")
    private String middle;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("service")
    private String service;
    @JsonProperty("thumb_path")
    private String thumbPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("first")
    public String getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(String first) {
        this.first = first;
    }

    @JsonProperty("handle_id")
    public Integer getHandleId() {
        return handleId;
    }

    @JsonProperty("handle_id")
    public void setHandleId(Integer handleId) {
        this.handleId = handleId;
    }

    @JsonProperty("image_path")
    public String getImagePath() {
        return imagePath;
    }

    @JsonProperty("image_path")
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    @JsonProperty("middle")
    public String getMiddle() {
        return middle;
    }

    @JsonProperty("middle")
    public void setMiddle(String middle) {
        this.middle = middle;
    }

    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("service")
    public String getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonProperty("thumb_path")
    public String getThumbPath() {
        return thumbPath;
    }

    @JsonProperty("thumb_path")
    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}