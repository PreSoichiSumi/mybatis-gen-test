package jp.yoyoyousei;

import jp.yoyoyousei.mybatis.gen.TodoMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by s-sumi on 2017/07/10.
 */
@Configuration
@PropertySource("classpath:application.properties")
@MapperScan("jp.yoyoyousei.mybatis.gen")
public class AppConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource(); //http://tomoyamkung.net/2013/12/13/java-spring-datasource/
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDefaultAutoCommit(false);
        dataSource.setMaxIdle(16);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        return dataSource;
    }
    //@ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }
//    @Bean
//    public MapperFactoryBean<TodoMapper> todoMapper() throws Exception{
//        MapperFactoryBean<TodoMapper> factoryBean = new MapperFactoryBean<>(TodoMapper.class);
//        factoryBean.setSqlSessionFactory(sqlSessionFactory());
//        return factoryBean;
//    }
}
