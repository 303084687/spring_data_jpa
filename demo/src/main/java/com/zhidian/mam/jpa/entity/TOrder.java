package com.zhidian.mam.jpa.entity;

import com.zhidian.mam.commons.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 订单表
 * 用户表-订单表,one-to-many
 * Created by zhangjiming on 2017/6/22.
 */
@DynamicInsert(true)
@DynamicUpdate(true)
@Entity
@Table(name="t_order")
@Data
public class TOrder extends BaseEntity {

    private String orderId;
    private String userId;

}
