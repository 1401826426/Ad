package com.fei.adsponsor.entity;
import com.fei.adsponsor.constants.UnitStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class AdUnit {

	@Id
	//自增主键
	private long id;

	//关联推广计划 id
	private long planId;

	//推广单元名称
	private String unitName;

	//推广单元状态
	private byte unitStatus;

	//广告位类型(开屏, 贴片, 中贴, 暂停帖, 后贴)
	private byte positionType;

	//预算
	private long budget;

	//创建时间
	private Date createTime;

	//更新时间
	private Date updateTime;

	public AdUnit(long planId, String unitName,
				  byte positionType, long budget) {
		this.planId = planId;
		this.unitName = unitName;
		this.unitStatus = UnitStatus.VALID.getState();
		this.positionType = positionType;
		this.budget = budget;
		this.createTime = new Date() ;
		this.updateTime = new Date() ;
	}
}