package com.fei.adsponsor.constants;

public enum UnitStatus {

    VALID((byte)1),
    INVALID((byte)0) ;

    private byte state ;

    private UnitStatus(byte state){
        this.state = state ;
    }

    public byte getState(){
        return state ;
    }

}
