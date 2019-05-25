package com.fei.adsponsor.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AdCreative {

	//自增主键
	@Id
	private long id;

	//创意名称
	private String name;

	//物料类型(图片, 视频)
	private byte type;

	//物料子类型(图片: bmp, jpg 等等)
	private byte materialType;

	//高度
	private int height;

	//宽度
	private int width;

	//物料大小, 单位是 KB
	private String size;

	//持续时长, 只有视频才不为 0
	private int duration;

	//审核状态
	private byte auditStatus;

	//标记当前记录所属用户
	private String userId;

	//物料地址
	private String url;

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

	public void setName(String name){
	    this.name = name;
	}

	public String getName(){
	    return name;
	}

	public void setType(byte type){
	    this.type = type;
	}

	public byte getType(){
	    return type;
	}

	public void setMaterialType(byte materialType){
	    this.materialType = materialType;
	}

	public byte getMaterialType(){
	    return materialType;
	}

	public void setHeight(int height){
	    this.height = height;
	}

	public int getHeight(){
	    return height;
	}

	public void setWidth(int width){
	    this.width = width;
	}

	public int getWidth(){
	    return width;
	}

	public void setSize(String size){
	    this.size = size;
	}

	public String getSize(){
	    return size;
	}

	public void setDuration(int duration){
	    this.duration = duration;
	}

	public int getDuration(){
	    return duration;
	}

	public void setAuditStatus(byte auditStatus){
	    this.auditStatus = auditStatus;
	}

	public byte getAuditStatus(){
	    return auditStatus;
	}

	public void setUserId(String userId){
	    this.userId = userId;
	}

	public String getUserId(){
	    return userId;
	}

	public void setUrl(String url){
	    this.url = url;
	}

	public String getUrl(){
	    return url;
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




}