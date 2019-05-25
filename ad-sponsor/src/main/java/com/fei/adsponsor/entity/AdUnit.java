package com.fei.adsponsor.entity;
import com.fei.adsponsor.constants.UnitStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AdUnit {

	@Id
	//自增主键
	private long id;

	//关联推广计划 id
	private String planId;

	//推广单元名称
	private String unitName;

	//推广单元状态
	private byte unitStatus;

	//广告位类型(开屏, 贴片, 中贴, 暂停帖, 后贴)
	private byte positionType;

	//预算
	private String budget;

	//创建时间
	private Date createTime;

	//更新时间
	private Date updateTime;

	public void setId(long id){
	    this.id = id;
	}

	public long getId(){
	    return id;
	}

	public void setPlanId(String planId){
	    this.planId = planId;
	}

	public String getPlanId(){
	    return planId;
	}

	public void setUnitName(String unitName){
	    this.unitName = unitName;
	}

	public String getUnitName(){
	    return unitName;
	}

	public void setUnitStatus(byte unitStatus){
	    this.unitStatus = unitStatus;
	}

	public byte getUnitStatus(){
	    return unitStatus;
	}

	public void setPositionType(byte positionType){
	    this.positionType = positionType;
	}

	public byte getPositionType(){
	    return positionType;
	}

	public void setBudget(String budget){
	    this.budget = budget;
	}

	public String getBudget(){
	    return budget;
	}

	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Date getCreateTime(){
	    return createTime;
	}

	public void setUpdateTime(Date updateTime){
	    this.updateTime = updateTime;
	}

	public Date getUpdateTime(){
	    return updateTime;
	}

	public AdUnit(long id, String planId, String unitName,
				  byte positionType, String budget) {
		this.id = id;
		this.planId = planId;
		this.unitName = unitName;
		this.unitStatus = UnitStatus.VALID.getState();
		this.positionType = positionType;
		this.budget = budget;
	}
}