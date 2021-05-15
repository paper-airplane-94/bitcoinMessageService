package org.investment.bitcoin.markettickpricenotifyservice.service;

import org.investment.bitcoin.markettickpricenotifyservice.domain.TargetTickPrice;
import org.investment.bitcoin.markettickpricenotifyservice.mapper.TargetTickPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetOverCheckService {
    private TargetTickPriceMapper targetTickPriceMapper;

    @Autowired
    public TargetOverCheckService(TargetTickPriceMapper targetTickPriceMapper) {
        this.targetTickPriceMapper = targetTickPriceMapper;
    }

    public List<TargetTickPrice> getTargetOverTickPrices(){
        return targetTickPriceMapper.selectTargetOverTickPrices();
    }
}
