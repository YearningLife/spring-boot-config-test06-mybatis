package com.green.springboot.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;

/*
1. 引入druid数据源
2. 在application.yml文件中添加数据源属性
3. 重新加载DruidDataSource数据源，并配置 ConfigurationProperties(prefix="spring.datasource") 属性
4. 启动后 会报错，需要在pom.xml文件中引入 <groupId>log4j</groupId> 依赖，参考： https://blog.csdn.net/dingjianmin/article/details/106532075
 */
@Configuration
public class DruidSourceConfig {

    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource mydruidDataSource(){

        return new DruidDataSource();
    }

    /*
    1. 前提条件，在application文件中配置了spring.datasource相关属性，并且引入了druid参数
    2. new DruidDataSource() 引入后，下面的设置才会生效
    3. StatViewServlet 的引入可参考 com.alibaba.druid.support.http.StatViewServlet ，属性设置参考：ResourceServlet
    4. WebStatFilter 的引入可参考pom文件的 <artifactId>druid</artifactId>  依赖
     */
    //配置servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        System.out.println("进入druid后台。。。。。servlet。。start");
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        registrationBean.addInitParameter("allow","");
        registrationBean.addInitParameter("deny","192.168.10.1");
        System.out.println("进入druid后台。。。。。servlet。。end");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean statViewFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        System.out.println("进入druid后台。。。。。filter。。begin");
        bean.setFilter(new WebStatFilter());
        bean.addInitParameter("exclusions","*.js,*.css,/druid/*");
        bean.setUrlPatterns(Arrays.asList("/*"));
        System.out.println("进入druid后台。。。。。filter。。end");
        return bean;
    }
}
