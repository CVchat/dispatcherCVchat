package com.telran.m2m.dto;

public class MessageData {
    /**
     * Timestamp of room data object
     */
    public long timestamp;

    /**
     * Room object
     */
    public String text;

    /**
     * Critical message flag
     */
    public boolean critical;

    public MessageData(long timestamp, String text, boolean critical) {
        this.timestamp = timestamp;
        this.text = text;
        this.critical = critical;
    }

    public MessageData() {
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "timestamp=" + timestamp +
                ", text='" + text + '\'' +
                ", critical=" + critical +
                '}';
    }

    public boolean isCritical() {
        return critical;
    }
}
