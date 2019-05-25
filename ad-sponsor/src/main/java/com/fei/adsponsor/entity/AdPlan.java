package com.fei.adsponsor.entity;
import com.fei.adsponsor.constants.PlanStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class AdPlan {

	//自增主键
	@Id
	private long id;

	//标记当前记录所属用户
	private String userId;

	//推广计划名称
	private String planName;

	//推广计划状态
	private byte planStatus;

	//推广计划开始时间；
	private Date startDate;

	//推广计划结束时间；
	private Date endDate;

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

	public void setUserId(String userId){
	    this.userId = userId;
	}

	public String getUserId(){
	    return userId;
	}

	public void setPlanName(String planName){
	    this.planName = planName;
	}

	public String getPlanName(){
	    return planName;
	}

	public void setPlanStatus(byte planStatus){
	    this.planStatus = planStatus;
	}

	public byte getPlanStatus(){
	    return planStatus;
	}

	public void setStartDate(Date startDate){
	    this.startDate = startDate;
	}

	public Date getStartDate(){
	    return startDate;
	}

	public void setEndDate(Date endDate){
	    this.endDate = endDate;
	}

	public Date getEndDate(){
	    return endDate;
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

	public AdPlan(long id, String userId, String planName, Date startDate, Date endDate) {
		this.id = id;
		this.userId = userId;
		this.planName = planName;
		this.planStatus = PlanStatus.VALID.getStatus();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public AdPlan() {
	}
}