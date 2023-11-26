package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newStructure.MessageAggregatedByBelongNumber;
import ru.otus.java.pro.newStructure.SmsDataNewStructure;
import ru.otus.java.pro.oldStructure.ChatSession;
import ru.otus.java.pro.oldStructure.Member;
import ru.otus.java.pro.oldStructure.Message;
import ru.otus.java.pro.oldStructure.SmsData;

import java.text.ParseException;
import java.util.*;

public class ProcessorAggregator implements Processor {
    @Override
    public SmsDataNewStructure process(SmsData data){
        SmsDataNewStructure dataNewStructure = new SmsDataNewStructure();
        Map<String, List<MessageAggregatedByBelongNumber>> dataMap = new HashMap<>();
        for (ChatSession chatSession : data.getChatSessions()) {
            for (Message message : chatSession.getMessages()) {
                MessageAggregatedByBelongNumber messageAggregated = new MessageAggregatedByBelongNumber();
                messageAggregated.setBelongNumber(message.getBelongNumber());
                messageAggregated.setChatIdentifier(chatSession.getChatIdentifier());
                messageAggregated.setSendDate(message.getSendDate());
                messageAggregated.setText(message.getText());
                int handleId = message.getHandleId();
                for (Member member : chatSession.getMembers()) {
                    if (handleId == member.getHandleId()) {
                        messageAggregated.setLast(member.getLast());
                    }
                }
                String belongNumber = messageAggregated.getBelongNumber();
                if (!dataMap.containsKey(belongNumber)) {
                    List<MessageAggregatedByBelongNumber> messageList = new ArrayList<>();
                    dataMap.put(belongNumber, messageList);
                }
                dataMap.get(belongNumber).add(messageAggregated);
                Collections.sort(dataMap.get(belongNumber), Comparator.comparing(MessageAggregatedByBelongNumber :: getSendDate));
            }
        }
        dataNewStructure.setMessages(dataMap);
        return dataNewStructure;
    }
}
