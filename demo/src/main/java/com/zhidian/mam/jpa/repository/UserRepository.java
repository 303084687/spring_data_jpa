package com.zhidian.mam.jpa.repository;


import com.zhidian.mam.jpa.entity.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangjiming on 2017/5/20.
 */
//@Repository
public interface UserRepository extends JpaRepository<TUser, String>, JpaSpecificationExecutor<TUser> {
    //http://blog.csdn.net/u012706811/article/details/53218083
    //http://www.cnblogs.com/jiangxiaoyaoblog/p/5635152.html

    /**
     * 修改、删除
     * JPQL语句方式
     * @param name
     * @param id
     * @return
     */
    @Modifying
    @Query("update TUser u set u.name = ?1 where u.id = ?2")
    int update(String name, String id);

    @Modifying
    @Query(value="update TUser u set u.name = :name where u.id = :id")
    int update2(@Param("name") String name, @Param("id") String id);

    /**
     * 按照特定属性查询（按照where条件）
     * 解析方法名方式
     * @param createDate
     * @return
     */
    List<TUser> findByCreateDate(Date createDate);

    /**
     * 按照特定属性查询（按照where条件）
     * 解析方法名方式（分页）
     * @param username
     * @param pageable
     * @return
     */
    Page<TUser> findByUsernameLikeOrName(String username, String name, Pageable pageable);

}
