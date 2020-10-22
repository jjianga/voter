package org.jjianga;

import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@SpringBootApplication
@EnableSwaggerBootstrapUI
@EnableScheduling
@MapperScan({"org.jjianga.*.mapper"})
public class VoterApplication extends SpringBootServletInitializer {

        public static void main(String[] args) {
            SpringApplication.run(VoterApplication.class, args);
        }

        //配置mybatis的分页插件pageHelper
        @Bean
        public PageHelper pageHelper(){
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("offsetAsPageNum","true");
            properties.setProperty("rowBoundsWithCount","true");
            properties.setProperty("reasonable","true");
            properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
            pageHelper.setProperties(properties);
            return pageHelper;
        }

        /**
         * 	容器
         *	springfox.documentation.swagger.web.ClassOrApiAnnotationResourceGrouping
         */
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            return builder.sources(VoterApplication.class);
        }
}
