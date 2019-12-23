package com.atguigu.config;

/*
* Profile:
*       Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
*
*   开发环境、测试环境、生产环境
*   数据源：A,B,C
*   @Profile：指定组件在哪个环境的情况下才能被注册到容器中；不指定，则任何环境下都能注册这个组件
*   1.加载环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
*   2.@Profile 写在类上，则在这个环境被激活的时候，所有的bean生效
*   3.没有标注环境标识的bean，在任何类中都会加载
* */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

//@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfig_Profile implements EmbeddedValueResolverAware{

    @Value("${db.user}")
    private String user;

    private String jdbcUrl;

    private StringValueResolver valueResolver;

    private String driverClass;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver = stringValueResolver;
        this.driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSource_Test(@Value("${db.password}") String password) throws Exception{
        ComboPooledDataSource dataSource =  new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSource_Dev(@Value("${db.password}") String password) throws Exception{
        ComboPooledDataSource dataSource =  new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/dev");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSource_Prod(@Value("${db.password}") String password) throws Exception{
        ComboPooledDataSource dataSource =  new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/prod");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
}
