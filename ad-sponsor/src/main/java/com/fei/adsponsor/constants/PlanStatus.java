package com.fei.adsponsor.constants;

public enum PlanStatus {

    VALID((byte)1),
    INVALID((byte)0),
    ;

    private byte status ;

    private PlanStatus(byte status){
        this.status = status ;
    }

    public byte getStatus(){
        return status ;
    }

}
