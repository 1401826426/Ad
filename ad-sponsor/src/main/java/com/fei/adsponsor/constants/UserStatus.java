package com.fei.adsponsor.constants;

public enum UserStatus {

    VALID((byte)1),
    INVALID((byte)0) ;

    private byte state ;

    private UserStatus(byte state){
        this.state = state ;
    }

    public byte getState(){
        return state ;
    }
}
