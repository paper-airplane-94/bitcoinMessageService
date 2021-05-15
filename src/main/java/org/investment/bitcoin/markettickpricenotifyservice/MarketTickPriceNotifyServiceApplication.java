package org.investment.bitcoin.markettickpricenotifyservice;

import org.investment.bitcoin.markettickpricenotifyservice.service.FirebaseCloudMessageService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class MarketTickPriceNotifyServiceApplication {

    @Autowired
    FirebaseCloudMessageService firebaseCloudMessageService;

    public static void main(String[] args){
        SpringApplication.run(MarketTickPriceNotifyServiceApplication.class, args);
    }

}
