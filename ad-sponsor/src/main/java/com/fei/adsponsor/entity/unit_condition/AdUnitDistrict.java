package com.fei.adsponsor.entity.unit_condition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdUnitDistrict {

	//
	@Id
	private int id;

	//推广单元 id
	private int unitId;

	//省
	private String province;

	//市
	private String city;

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

	public void setProvince(String province){
	    this.province = province;
	}

	public String getProvince(){
	    return province;
	}

	public void setCity(String city){
	    this.city = city;
	}

	public String getCity(){
	    return city;
	}

	public AdUnitDistrict() {
	}

	public AdUnitDistrict(int unitId, String province, String city) {
		this.unitId = unitId;
		this.province = province;
		this.city = city;
	}
}