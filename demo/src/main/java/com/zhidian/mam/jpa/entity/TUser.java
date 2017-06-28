package com.zhidian.mam.jpa.entity;

import com.zhidian.mam.commons.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户表
 * Created by zhangjiming on 2017/6/22.
 */
@DynamicInsert(true)
@DynamicUpdate(true)
@Entity
@Table(name="t_user")
@Data
public class TUser extends BaseEntity {

    private String username;
    private String password;
}
