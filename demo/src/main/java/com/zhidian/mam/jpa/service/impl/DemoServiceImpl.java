package com.zhidian.mam.jpa.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhidian.mam.commons.ServiceException;
import com.zhidian.mam.commons.Utils;
import com.zhidian.mam.jpa.entity.TUser;
import com.zhidian.mam.jpa.repository.OrderRepository;
import com.zhidian.mam.jpa.repository.UserRepository;
import com.zhidian.mam.jpa.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangjiming on 2017/6/22.
 */
@Service("demoService")
@Slf4j
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 增
     * @param username
     * @param password
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(String username, String password) throws ServiceException {
        TUser user = new TUser();
        user.setId(Utils.uuid());
        user.setName("用户"+ RandomStringUtils.randomNumeric(5));
        user.setUsername(username);
        user.setPassword(password);
        user = userRepository.save(user);

        log.info(JSON.toJSONString(user));
    }

    /**
     * 删
     * @param id
     * @throws ServiceException
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String id) throws ServiceException {
//        //方法一，spring-data-jpa提供实现
//        userRepository.delete(id);

        //方法二，通过对象删除
        TUser user = new TUser();
        user.setId(id);
        userRepository.delete(user);

    }

    /**
     * 改
     * @param id
     * @param name
     * @throws ServiceException
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(String id, String name) throws ServiceException {
        //方法一，对象化操作
        TUser user = userRepository.findOne(id);
        if(null != user) {
            user.setName(name);
            userRepository.save(user);
        }

//        //方法二，JPQL语句
//        int i = userRepository.update2(name, id);
//        log.debug("受影响记录数："+i);
    }

    /**
     * 其它查询操作
     * @return
     */
    @Override
    public TUser findTable() throws ServiceException {
        try {
            log.info("findTable");

            //查询列表-按照特定属性查询（按照where条件）
            //Date createDate = DateUtils.parseDate("2017-06-28 10:52:33", "yyyy-MM-dd HH:mm:ss");
            //List<TUser> userList = userRepository.findByCreateDate(createDate);
            List<TUser> userList=userRepository.findAll();
            log.debug(""+userList.size());

            //查询分页-按照特定属性查询（按照where条件）
            //场景：列表页+模糊查询
            Sort sort = new Sort(Sort.Direction.DESC, "createDate");
            Pageable pageable = new PageRequest(0, 5, sort);  //spring-data分页查询对象
            Page<TUser> userPage = userRepository.findAll(pageable);
            log.debug(""+userPage.getTotalPages());

            //String userId = "";
            //userRepository.findOne(userId);
            //orderRepository.findByUserId(userId);

            log.info("findTable");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
