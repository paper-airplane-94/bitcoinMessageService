package org.investment.bitcoin.markettickpricenotifyservice.feignclient;

import org.investment.bitcoin.markettickpricenotifyservice.config.FeginConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "fcm-push-message-client", url = "https://fcm.googleapis.com/v1/projects/tickpriceservice/messages:send"
        , configuration = FeginConfiguration.class)
public interface FcmPushMessageClient {
    @PostMapping
    void sendFcmMessage(@RequestBody String fcmPushMessage);
}
