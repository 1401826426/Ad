package com.fei.adsponsor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreativeUnit {

	//
	@Id
	private long id;

	//创意 id
	private long creativeId;

	//推广单元 id
	private long unitId;

	public void setId(long id){
	    this.id = id;
	}

	public long getId(){
	    return id;
	}

	public void setCreativeId(long creativeId){
	    this.creativeId = creativeId;
	}

	public long getCreativeId(){
	    return creativeId;
	}

	public void setUnitId(long unitId){
	    this.unitId = unitId;
	}

	public long getUnitId(){
	    return unitId;
	}


	public CreativeUnit(long creativeId, long unitId) {
		this.creativeId = creativeId;
		this.unitId = unitId;
	}

	public CreativeUnit() {
	}
}