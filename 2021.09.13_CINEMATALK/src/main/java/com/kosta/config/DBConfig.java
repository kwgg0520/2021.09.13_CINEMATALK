package com.kosta.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {
   
   @Bean(name="oracledb", destroyMethod="close")
   public HikariDataSource getDataSource() throws IOException
   {
      ClassPathResource resource=new ClassPathResource("db.properties");
      Properties prop=new Properties();
      prop.load(resource.getInputStream());
      
      HikariConfig dbconfig=new HikariConfig(prop);
      HikariDataSource ds=new HikariDataSource(dbconfig);
      return ds;
   }

   @Bean(name="sqlsession")
   public SqlSessionFactory getSessionFactory() throws Exception {
	   SqlSessionFactoryBean factory=new SqlSessionFactoryBean();
	   factory.setDataSource(getDataSource());
	   Resource[] resources=new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
	   factory.setMapperLocations(resources);
	   
	   return (SqlSessionFactory)factory.getObject();
   }
}