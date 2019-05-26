package com.fei.adsponsor.entity.unit_condition;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class AdUnitKeyword {

	//
	@Id
	private long id;

	//推广单元 id
	private long unitId;

	//关键词

	private String keyword;

	public AdUnitKeyword(long unitId, String keyword) {
		this.unitId = unitId;
		this.keyword = keyword;
	}
}