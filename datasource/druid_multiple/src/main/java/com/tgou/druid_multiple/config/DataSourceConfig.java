package com.tgou.druid_multiple.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 这里可以直接配置,属性都是在spring.datasource.orders
 * 或者spring.datasource.users第一层
 *
 * Created by 凌战 on 2020/7/24
 */
@Configuration
public class DataSourceConfig {

  /**
   * 创建 orders 数据源
   */
  @Primary
  @Bean(name = "ordersDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.orders") // 读取 spring.datasource.orders 配置到 HikariDataSource 对象
  public DataSource ordersDataSource() {
    return DruidDataSourceBuilder.create().build();
  }

  /**
   * 创建 users 数据源
   */
  @Bean(name = "usersDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.users")
  public DataSource usersDataSource() {
    return DruidDataSourceBuilder.create().build();
  }


}
