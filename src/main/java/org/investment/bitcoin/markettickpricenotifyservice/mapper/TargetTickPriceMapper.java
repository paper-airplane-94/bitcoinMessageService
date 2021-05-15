package org.investment.bitcoin.markettickpricenotifyservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.investment.bitcoin.markettickpricenotifyservice.domain.TargetTickPrice;

import java.util.List;

@Mapper
public interface TargetTickPriceMapper {
    List<TargetTickPrice> selectTargetOverTickPrices();
}
