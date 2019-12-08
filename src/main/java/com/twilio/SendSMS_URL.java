package com.twilio;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Media;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.Arrays;

public class SendSMS_URL {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(System.getenv("MY_PHONE_NUMBER")),
                new com.twilio.type.PhoneNumber("+12564725932"),
                "This is just another Test of TWILIO MMS feature")
            .setMediaUrl(Arrays.asList(URI.create("https://farm8.staticflickr.com/7090/6941316406_80b4d6d50e_z_d.jpg")))
            .create();

        System.out.println(message.getSid());

    }
}
