package com.telran.m2m.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface Dispatcher extends Sink {
    String CRITICAL_MESSAGE = "critical_message";

    String MONITORING_DASHBOARD = "monitoring_dashboard";

    @Output(CRITICAL_MESSAGE)
    MessageChannel criticalMessage();

    @Output(MONITORING_DASHBOARD)
    MessageChannel monitoringDashboard();

}
