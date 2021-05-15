package org.investment.bitcoin.markettickpricenotifyservice.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.investment.bitcoin.markettickpricenotifyservice.service.FirebaseCloudMessageService;
import org.investment.bitcoin.markettickpricenotifyservice.service.TargetOverCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class TargetOverCheckServiceScheduler {
    private TargetOverCheckService targetOverCheckService;
    private FirebaseCloudMessageService firebaseCloudMessageService;

    @Autowired
    public TargetOverCheckServiceScheduler(TargetOverCheckService targetOverCheckService, FirebaseCloudMessageService firebaseCloudMessageService) {
        this.targetOverCheckService = targetOverCheckService;
        this.firebaseCloudMessageService = firebaseCloudMessageService;
    }

    @Scheduled(cron = "*/1 * * * * *")
    public void updateMarketInformation() {
        targetOverCheckService.getTargetOverTickPrices().stream().forEach( target -> {
            try {
                firebaseCloudMessageService.sendMessageTo(target.getToken(), target.getMarketId(), "가격 변동이 일어났습니다. 가격 : " + target.getTickPrice());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
