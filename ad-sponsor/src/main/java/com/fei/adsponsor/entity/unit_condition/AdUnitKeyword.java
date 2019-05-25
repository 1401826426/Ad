package com.fei.adsponsor.entity.unit_condition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdUnitKeyword {

	//
	@Id
	private int id;

	//推广单元 id
	private int unitId;

	//关键词
	private String keyword;

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

	public void setKeyword(String keyword){
	    this.keyword = keyword;
	}

	public String getKeyword(){
	    return keyword;
	}

	public AdUnitKeyword(int unitId, String keyword) {
		this.unitId = unitId;
		this.keyword = keyword;
	}

	public AdUnitKeyword() {
	}
}