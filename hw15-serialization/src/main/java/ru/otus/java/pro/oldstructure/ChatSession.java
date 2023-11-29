package ru.otus.java.pro.oldstructure;

import java.util.LinkedHashMap;
import java.util.List;
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
        "chat_id",
        "chat_identifier",
        "display_name",
        "is_deleted",
        "members",
        "messages"
})
@Generated("jsonschema2pojo")
public class ChatSession {

    @JsonProperty("chat_id")
    private Integer chatId;
    @JsonProperty("chat_identifier")
    private String chatIdentifier;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("is_deleted")
    private Integer isDeleted;
    @JsonProperty("members")
    private List<Member> members;
    @JsonProperty("messages")
    private List<Message> messages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("chat_id")
    public Integer getChatId() {
        return chatId;
    }

    @JsonProperty("chat_id")
    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    @JsonProperty("chat_identifier")
    public String getChatIdentifier() {
        return chatIdentifier;
    }

    @JsonProperty("chat_identifier")
    public void setChatIdentifier(String chatIdentifier) {
        this.chatIdentifier = chatIdentifier;
    }

    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("is_deleted")
    public Integer getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("is_deleted")
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("members")
    public List<Member> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
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
