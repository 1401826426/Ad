package com.fei.adsponsor.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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
	private long userId;

	//物料地址
	private String url;

	//创建时间
	private Date createTime;

	//更新时间
	private Date updateTime;

	public AdCreative(AdCreative creative) {
		this.name = creative.getName();
		this.type = creative.getType();
		this.materialType = creative.getMaterialType() ;
		this.height = creative.getHeight() ;
		this.width = creative.getWidth() ;
		this.size = creative.getSize() ;
		this.duration = creative.getDuration() ;
		this.auditStatus = creative.getAuditStatus();
		this.url = creative.getUrl() ;
		this.createTime = new Date() ;
		this.updateTime = new Date() ;
	}
}