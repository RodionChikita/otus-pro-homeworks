package ru.otus.java.pro.newstructure;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;
import java.util.Map;
import java.util.Objects;


public class SmsDataNewStructure {
    @JsonProperty("messages")
    private Map<String, List<MessageAggregatedByBelongNumber>> messages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsDataNewStructure that = (SmsDataNewStructure) o;
        return Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages);
    }

    public Map<String, List<MessageAggregatedByBelongNumber>> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, List<MessageAggregatedByBelongNumber>> messages) {
        this.messages = messages;
    }
}
