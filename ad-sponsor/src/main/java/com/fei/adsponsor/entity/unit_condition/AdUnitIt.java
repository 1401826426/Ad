package com.fei.adsponsor.entity.unit_condition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdUnitIt {

	//
	@Id
	private int id;

	//推广单元 id
	private int unitId;

	//兴趣标签
	private String itTag;

	public void setId(int id){
	    this.id = id;
	}

	public int getId(){
	    return id;
	}

	public void setUnitId(int unitId){
	    this.unitId = unitId;
	}

	public int getUnitId(){
	    return unitId;
	}

	public void setItTag(String itTag){
	    this.itTag = itTag;
	}

	public String getItTag(){
	    return itTag;
	}

	public AdUnitIt(int unitId, String itTag) {
		this.unitId = unitId;
		this.itTag = itTag;
	}

	public AdUnitIt() {
	}
}