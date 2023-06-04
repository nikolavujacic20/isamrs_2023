package com.isamrs.isamrs_projekat.service;

import com.isamrs.isamrs_projekat.dto.EmailEvent;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class EmailListener implements
        ApplicationListener<EmailEvent> {

    @Autowired
    private Environment env;
    @Override
    public void onApplicationEvent(EmailEvent event) {
        try {
            this.sendEmail(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendEmail(EmailEvent event) throws IOException {

        SendGrid sg = new SendGrid("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");

        String subject = event.getSubject();

        Email from = new Email(env.getProperty("spring.mail.username"));
        Email to = new Email(event.getAddress()[0]);
        Content content = new Content("text/plain", event.getContent());
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}

