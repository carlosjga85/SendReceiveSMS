package com.twilio;

import static spark.Spark.*;

import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.MessagingResponse;

public class ReceiveSMS {

    public static void main(String[] args) {

        post("/receive-sms", (req, res) -> {
            res.type("application/xml");

            Body body = new Body
                    .Builder("Thank you for using This App. See you next Time.")
                    .build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();

            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();

            return twiml.toXml();

        });
    }

}
