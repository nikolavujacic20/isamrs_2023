package com.isamrs.isamrs_projekat.dto;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
    private String subject;
    private String content;
    private String[] address;

    public EmailEvent(Object source, String subject, String content, String[] address) {
        super(source);

        this.subject = subject;
        this.content = content;
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }
}
