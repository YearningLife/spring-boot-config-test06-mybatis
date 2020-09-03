package com.green.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
/*
这个类用来定义mapper定制化需求，实现自定义效果
 */
@org.springframework.context.annotation.Configuration
public class MapperConfig01 {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){

        return new ConfigurationCustomizer() {

            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);//开启系统级驼峰命名规范
            }
        };
    }


}
