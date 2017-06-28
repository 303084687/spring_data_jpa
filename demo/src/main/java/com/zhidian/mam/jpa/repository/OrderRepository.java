package com.zhidian.mam.jpa.repository;


import com.zhidian.mam.jpa.entity.TOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by zhangjiming on 2017/5/20.
 */
//@Repository
public interface OrderRepository extends JpaRepository<TOrder, String>, JpaSpecificationExecutor<TOrder> {

    List<TOrder> findByUserId(String userid);
}
