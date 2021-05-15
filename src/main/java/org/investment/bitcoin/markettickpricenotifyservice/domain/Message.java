package org.investment.bitcoin.markettickpricenotifyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Message {
    private Notification notification;
    private String token;
}
