package com.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSMS {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(System.getenv("MY_PHONE_NUMBER")),
                new com.twilio.type.PhoneNumber("+12564725932"),
                "This is just a Test of TWILIO SMS feature"
        ).create();

        System.out.println(message.getSid());

        //System.out.println(ACCOUNT_SID + "  " + AUTH_TOKEN + "  "+ System.getenv("MY_PHONE_NUMBER"));
    }
}
