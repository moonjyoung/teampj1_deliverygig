package com.deliverygig.moonjyoung.vo.store;

import java.time.LocalTime;
import java.util.List;

import com.deliverygig.moonjyoung.entity.delivery.StoreTimeDetailEntity;

import lombok.Data;

@Data
public class ShowStoreListVO {
    private Long storeSeq;
    private String storeName;
    private LocalTime storeCloseTime;
    private Integer status;
    // private List<StoreClosedDayInfoVO> storeClosedDay ; 

    public ShowStoreListVO(StoreTimeDetailEntity entity) {
        this.storeSeq = entity.getStoreInfoEntity().getSiSeq();
        this.storeName = entity.getStoreInfoEntity().getSiName();
        this.storeCloseTime = entity.getStdCloseTime();
        this.status = entity.getStoreInfoEntity().getSiStatus();
        
    }

    public ShowStoreListVO() {
    }

    
    
}
