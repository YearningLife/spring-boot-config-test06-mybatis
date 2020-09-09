package com.green.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @description: TODO MapperScan用来作为mapper映射文件的扫描路径，添加后，则mapper路径下的文件不需要在手动添加
 * @author: zero
 * @date: 2020/9/9
 * @version: 1.0
 */
@MapperScan(basePackages = "com.green.springboot.mapper")
@SpringBootApplication
public class SpringBootConfigTest06MybatisApplication {

    /*
     *
     * @description: TODO 用来作为主函数使用
     * @param: args
     * @return: void
     * @author zero
     * @date: 2020/9/9 23:28
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigTest06MybatisApplication.class, args);
    }

}
