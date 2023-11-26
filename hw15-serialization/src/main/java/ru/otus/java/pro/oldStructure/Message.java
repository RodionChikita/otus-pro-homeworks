package ru.otus.java.pro.oldStructure;

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
        "ROWID",
        "attributedBody",
        "belong_number",
        "date",
        "date_read",
        "guid",
        "handle_id",
        "has_dd_results",
        "is_deleted",
        "is_from_me",
        "send_date",
        "send_status",
        "service",
        "text"
})
@Generated("jsonschema2pojo")
public class Message {

    @JsonProperty("ROWID")
    private Integer rowid;
    @JsonProperty("attributedBody")
    private String attributedBody;
    @JsonProperty("belong_number")
    private String belongNumber;
    @JsonProperty("date")
    private Long date;
    @JsonProperty("date_read")
    private Long dateRead;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("handle_id")
    private Integer handleId;
    @JsonProperty("has_dd_results")
    private Integer hasDdResults;
    @JsonProperty("is_deleted")
    private Integer isDeleted;
    @JsonProperty("is_from_me")
    private Integer isFromMe;
    @JsonProperty("send_date")
    private String sendDate;
    @JsonProperty("send_status")
    private Integer sendStatus;
    @JsonProperty("service")
    private String service;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ROWID")
    public Integer getRowid() {
        return rowid;
    }

    @JsonProperty("ROWID")
    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    @JsonProperty("attributedBody")
    public String getAttributedBody() {
        return attributedBody;
    }

    @JsonProperty("attributedBody")
    public void setAttributedBody(String attributedBody) {
        this.attributedBody = attributedBody;
    }

    @JsonProperty("belong_number")
    public String getBelongNumber() {
        return belongNumber;
    }

    @JsonProperty("belong_number")
    public void setBelongNumber(String belongNumber) {
        this.belongNumber = belongNumber;
    }

    @JsonProperty("date")
    public Long getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Long date) {
        this.date = date;
    }

    @JsonProperty("date_read")
    public Long getDateRead() {
        return dateRead;
    }

    @JsonProperty("date_read")
    public void setDateRead(Long dateRead) {
        this.dateRead = dateRead;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("handle_id")
    public Integer getHandleId() {
        return handleId;
    }

    @JsonProperty("handle_id")
    public void setHandleId(Integer handleId) {
        this.handleId = handleId;
    }

    @JsonProperty("has_dd_results")
    public Integer getHasDdResults() {
        return hasDdResults;
    }

    @JsonProperty("has_dd_results")
    public void setHasDdResults(Integer hasDdResults) {
        this.hasDdResults = hasDdResults;
    }

    @JsonProperty("is_deleted")
    public Integer getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("is_deleted")
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("is_from_me")
    public Integer getIsFromMe() {
        return isFromMe;
    }

    @JsonProperty("is_from_me")
    public void setIsFromMe(Integer isFromMe) {
        this.isFromMe = isFromMe;
    }

    @JsonProperty("send_date")
    public String getSendDate() {
        return sendDate;
    }

    @JsonProperty("send_date")
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    @JsonProperty("send_status")
    public Integer getSendStatus() {
        return sendStatus;
    }

    @JsonProperty("send_status")
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    @JsonProperty("service")
    public String getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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