package com.zhidian.mam.jpa.service;

import com.zhidian.mam.commons.ServiceException;
import com.zhidian.mam.jpa.entity.TUser;

/**
 * Created by zhangjiming on 2017/6/22.
 */
public interface IDemoService {

    void save(String username, String password) throws ServiceException;

    void delete(String id) throws ServiceException;

    void update(String id, String name) throws ServiceException;

    TUser findTable() throws ServiceException;
}
