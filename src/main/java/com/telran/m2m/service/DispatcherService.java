package com.telran.m2m.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telran.m2m.dto.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;

import java.io.IOException;

@EnableBinding(Dispatcher.class)
public class DispatcherService {
    private ObjectMapper mapper = new ObjectMapper();


    @Autowired
    Dispatcher channels;

    @StreamListener(Dispatcher.INPUT)
    void getMessageData(String messagePayload) throws IOException {

        MessageData payload = mapper.readValue(messagePayload, MessageData.class);
        System.out.println(payload);

        if (payload.isCritical()) {
            channels.criticalMessage().send(MessageBuilder.withPayload(messagePayload).build());
            System.out.println("Critical!");
        }

        channels.monitoringDashboard().send(MessageBuilder.withPayload(messagePayload).build());
        System.out.println("monitoring");
    }
}
