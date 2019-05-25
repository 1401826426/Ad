package com.fei.adsponsor.entity;
import com.fei.adsponsor.constants.UserStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AdUser {

	//自增主键
	@Id
	private long id;

	//用户名
	private String username;

//	@Transient 表示不是表字段
	//给用户生成的 token
	private String token;

	//用户状态
	private byte userStatus;

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

	public void setUsername(String username){
	    this.username = username;
	}

	public String getUsername(){
	    return username;
	}

	public void setToken(String token){
	    this.token = token;
	}

	public String getToken(){
	    return token;
	}

	public void setUserStatus(byte userStatus){
	    this.userStatus = userStatus;
	}

	public byte getUserStatus(){
	    return userStatus;
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


	public AdUser(String username, String token) {
		this.username = username;
		this.token = token;
		this.userStatus = UserStatus.VALID.getState();
		this.updateTime = new Date() ;
		this.createTime = new Date() ;
	}

	public AdUser() {
	}
}