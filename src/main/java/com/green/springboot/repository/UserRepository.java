package com.green.springboot.repository;

import com.green.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
/*
用来作为实体类Dao层，实现对数据库的访问操作
 */
public interface UserRepository extends JpaRepository<User, Id> {

}
