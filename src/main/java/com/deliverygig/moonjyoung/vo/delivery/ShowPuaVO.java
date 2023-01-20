package com.deliverygig.moonjyoung.vo.delivery;

import com.deliverygig.moonjyoung.entity.delivery.PickUpAreaEntity;

import lombok.Data;

@Data
public class ShowPuaVO {
    private Long puaSeq;
    private String puaName;

    public ShowPuaVO(PickUpAreaEntity entity) {
        this.puaSeq = entity.getPuaSeq();
        this.puaName = entity.getPuaName();
    }
}