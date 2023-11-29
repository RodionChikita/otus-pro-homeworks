package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newstructure.MessageAggregatedByBelongNumber;
import ru.otus.java.pro.newstructure.SmsDataNewStructure;
import ru.otus.java.pro.oldstructure.ChatSession;
import ru.otus.java.pro.oldstructure.Member;
import ru.otus.java.pro.oldstructure.Message;
import ru.otus.java.pro.oldstructure.SmsData;

import java.util.*;

public class ProcessorAggregator implements Processor {
    @Override
    public SmsDataNewStructure process(SmsData data) {
        SmsDataNewStructure dataNewStructure = new SmsDataNewStructure();
        Map<String, List<MessageAggregatedByBelongNumber>> dataMap = new HashMap<>();
        for (ChatSession chatSession : data.getChatSessions()) {
            for (Message message : chatSession.getMessages()) {
                MessageAggregatedByBelongNumber messageAggregated = new MessageAggregatedByBelongNumber();
                messageAggregated.setBelongNumber(message.getBelongNumber());
                messageAggregated.setChatIdentifier(chatSession.getChatIdentifier());
                messageAggregated.setSendDate(message.getSendDate());
                messageAggregated.setText(message.getText());
                messageAggregated.setLast(last(message, chatSession));
                addMessageInMap(messageAggregated, dataMap);
                Collections.sort(dataMap.get(messageAggregated.getBelongNumber()), Comparator.comparing(MessageAggregatedByBelongNumber::getSendDate));
            }
        }
        dataNewStructure.setMessages(dataMap);
        return dataNewStructure;
    }
    private void addMessageInMap(MessageAggregatedByBelongNumber messageAggregated, Map<String, List<MessageAggregatedByBelongNumber>> dataMap){
        String belongNumber = messageAggregated.getBelongNumber();
        if (!dataMap.containsKey(belongNumber)) {
            List<MessageAggregatedByBelongNumber> messageList = new ArrayList<>();
            dataMap.put(belongNumber, messageList);
        }
        dataMap.get(belongNumber).add(messageAggregated);
    }
    private String last(Message message, ChatSession chatSession){
        int handleId = message.getHandleId();
        for (Member member : chatSession.getMembers()) {
            if (handleId == member.getHandleId()) {
                String last = member.getLast();
                return last;
            }
        }
        throw new RuntimeException();
    }
}
