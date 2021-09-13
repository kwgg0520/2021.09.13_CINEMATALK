package com.kosta.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.kosta.mapper"})
@ComponentScan(basePackages = {"com.kosta.service"})
public class BoardConfig {

}
