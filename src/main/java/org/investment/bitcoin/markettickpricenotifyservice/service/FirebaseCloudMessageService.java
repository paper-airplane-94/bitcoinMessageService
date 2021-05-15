package org.investment.bitcoin.markettickpricenotifyservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.gson.Gson;
import org.investment.bitcoin.markettickpricenotifyservice.domain.FcmPushMessage;
import org.investment.bitcoin.markettickpricenotifyservice.domain.Message;
import org.investment.bitcoin.markettickpricenotifyservice.domain.Notification;
import org.investment.bitcoin.markettickpricenotifyservice.feignclient.FcmPushMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.io.IOException;

@Service
public class FirebaseCloudMessageService {
    private static final String DEVICE_TOKEN = "cbJcP1-kQCW9a2yPNuhafA:APA91bHEK9gnBeFX4kNXB5iUElkDAJy0BFhMOIZv4va0enBd3A-Twl_hHn3_OFkWs9W90nT7rw-b1d4OtMpIOLJCRR63Xl190BKKHMvUKDy_1J7eInmrZpPq0V0J7gFuXUTJVWjqxGqm";
    private final Gson gson = new Gson();
    private FcmPushMessageClient fcmPushMessageClient;

    @Autowired
    public FirebaseCloudMessageService(FcmPushMessageClient fcmPushMessageClient) {
        this.fcmPushMessageClient = fcmPushMessageClient;
    }

    public void sendMessageTo(String token, String title, String body) throws IOException {
        fcmPushMessageClient.sendFcmMessage(createFcmMessageBody(token, title, body));
    }

    public String createFcmMessageBody(String token, String title, String body) throws IOException {
        FcmPushMessage fcmPushMessage = FcmPushMessage.builder()
                .message(Message.builder()
                        .token(token)
                        .notification(Notification.builder()
                                .title(title)
                                .body(body)
                                .image("classpath:/image/ticPriceService.jpg")
                                .build())
                        .build()
                )
                .isValidation(false)
                .build();
        System.out.println(gson.toJson(fcmPushMessage));
        return gson.toJson(fcmPushMessage);
    }
}