package com.fei.adsponsor.entity.unit_condition;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class AdUnitIt {

	//
	@Id
	private long id;

	//推广单元 id
	private long unitId;

	//兴趣标签
	private String itTag;


	public AdUnitIt(long unitId, String itTag) {
		this.unitId = unitId;
		this.itTag = itTag;
	}

	public AdUnitIt() {
	}
}