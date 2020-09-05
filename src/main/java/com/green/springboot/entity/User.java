package com.green.springboot.entity;

import javax.persistence.*;
/*
创建实体类
 */
@Entity
@Table(name="user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer id;
    @Column(name ="name",length=50)
    public String name;
    public Integer age;
    public String company;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
