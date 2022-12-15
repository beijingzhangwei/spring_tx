package com.ddyydy.tk;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.MalformedURLException;

@Configuration//指定这是一个核心配置类
@MapperScan("com.ddyydy.tk")//扫描dao层，生成动态代理
@ComponentScan("com.ddyydy.tk")//扫描该路径下所有类上的注解
@EnableTransactionManagement//开启事务
//@EnableAspectJAutoProxy
public class ApplicationConfig {
    //配置数据源
    @Bean//等同于xml中的<bean>节点
    public DataSource dataSource(JdbcConfig dbcp) throws PropertyVetoException {
        //其中JdbcConfig是自定义的配置类，读取properties文件的类
        BasicDataSource cd = new BasicDataSource();
        cd.setDriverClassName(dbcp.getDriver());
        cd.setUrl(dbcp.getUrl());
        cd.setUsername(dbcp.getName());
        System.out.println("config：PWD---"+dbcp.getPassword());

        if (!StringUtils.isEmpty(RuntimeArgs.getPasswd())){
            System.out.println("args：PWD---"+RuntimeArgs.getPasswd());
            cd.setPassword(RuntimeArgs.getPasswd());
        }else{
            cd.setPassword(dbcp.getPassword());
        }
        return cd;
    }
    //配置核心Mybatis核心工厂
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);//配置数据源
        bean.setTypeAliasesPackage("com.ddyydy.tk");//设置实体类别名
        PathMatchingResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));//配置Mapper映射文件的路径
        return bean;
    }
    //配置事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource ds){
        DataSourceTransactionManager dm = new DataSourceTransactionManager();
        dm.setDataSource(ds);
        return dm;
    }
}