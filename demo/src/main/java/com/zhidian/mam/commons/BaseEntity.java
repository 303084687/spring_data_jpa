package com.zhidian.mam.commons;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 表实体对象父类
 */
@MappedSuperclass
public class BaseEntity {
	
	/**
	 * <br/>Description:保存时触发，设置当前时间
	 * <p>Author:jmzhang</p>
	 */
	@PrePersist
	protected void prePersist(){
		Date d = new Date();
        this.createDate = d;
        this.lastModifiedDate = d;
    }
	
	/**
	 * <br/>Description:更新时触发，更新当前时间
	 * <p>Author:jmzhang</p>
	 */
	@PreUpdate
	protected void preUpdate() {
		this.lastModifiedDate = new Date();
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="assigned")
	@GenericGenerator(name="assigned", strategy="assigned")
	private String id;
	
//	@Version
//	@Column(name="version", length = 11)
//	private int version;
	
	/**
	 * 名字
	 */
	@Column(length=128, name="name")
	private String name;
	
	/**
	 * 创建日期
	 */
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false, name="create_date")
	private Date createDate;
	
	/**
	 * <p>Description: 最后修改时间</p>
	 * <p>Author:jmzhang</p>
	 * @Fields lastModifiedDate 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified_date")
	private Date lastModifiedDate;
	
	/**
	 * 启用
	 */
	@Column(name="enabled")
	private Boolean enabled = true;
	
	/**
	 * 逻辑删除
	 */
	@Column(name="logic_del")
	private Boolean logicDel = false;
	
	/**
	 * 描述
	 */
	@Column(name="description")
	private String description;

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Boolean getEnabled(){
		return enabled;
	}

	public void setEnabled(Boolean enabled){
		this.enabled = enabled;
	}

	public Boolean getLogicDel(){
		return logicDel;
	}

	public void setLogicDel(Boolean logicDel){
		this.logicDel = logicDel;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
