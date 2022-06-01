package com.sykking.entity;

public class Message {
    private String fromName;
    private String message;
    private String toName;

    @Override
    public String toString() {
        return "Message{" +
                "fromName='" + fromName + '\'' +
                ", message='" + message + '\'' +
                ", toName='" + toName + '\'' +
                '}';
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Message(String fromName, String message, String toName) {
        this.fromName = fromName;
        this.message = message;
        this.toName = toName;
    }

    public Message() {
    }
}
