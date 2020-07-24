package com.tgou.hikaricp_multiple.config;


import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里配置错误的原因是因为hikaricp的属性配置在第二层
 *
 * Created by 凌战 on 2020/7/24
 */
/*
@Configuration
public class MistakenDataSourceConfig {

  @Bean(name = "ordersDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.orders")
  public DataSource ordersDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "usersDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.users")
  public DataSource usersDataSource() {
    return DataSourceBuilder.create().build();
  }

}
*/
