package com.fei.adsponsor.entity.unit_condition;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class AdUnitDistrict {

	//
	@Id
	private int id;

	//推广单元 id
	private long unitId;

	//省
	private String province;

	//市
	private String city;


	public AdUnitDistrict(long unitId, String province, String city) {
		this.unitId = unitId;
		this.province = province;
		this.city = city;
	}
}