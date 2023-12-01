package ru.otus.java.pro.newstructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageAggregatedByBelongNumber {
    @JsonProperty("chat_identifier")
    private String chatIdentifier;
    @JsonProperty("last")
    private String last;
    @JsonProperty("belong_number")
    private String belongNumber;
    @JsonProperty("send_date")
    private String sendDate;
    @JsonProperty("text")
    private String text;


    public String getChatIdentifier() {
        return chatIdentifier;
    }

    public void setChatIdentifier(String chatIdentifier) {
        this.chatIdentifier = chatIdentifier;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBelongNumber() {
        return belongNumber;
    }

    public void setBelongNumber(String belongNumber) {
        this.belongNumber = belongNumber;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
