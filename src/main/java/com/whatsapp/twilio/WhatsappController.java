package com.whatsapp.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsappController {

    public static final String ACCOUNT_SID = "ACf3ffea56256e63fea37c793407ec99c2";
    public static final String AUTH_ID = "af318c1e42b60a6a61b7ab3eb3ab7a66";

    @GetMapping(value = "/send/whatsapp", params = {"to","body"})
    public String sendWhatsApp(@RequestParam("to") String to, @RequestParam("body") String body){
        Twilio.init(ACCOUNT_SID, AUTH_ID);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+917000598464"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        body)
                .create();

        System.out.println(message.getSid());
        System.out.println("Message sent");
        return message.getSid();
    }
}
