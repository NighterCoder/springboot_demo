package com.tgou.druid_multiple;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DruidMultipleApplication implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(DruidMultipleApplication.class);

  @Resource(name = "ordersDataSource")
  private DataSource ordersDataSource;

  @Resource(name = "usersDataSource")
  private DataSource usersDataSource;

  public static void main(String[] args) {
    SpringApplication.run(DruidMultipleApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    // orders 数据源
    logger.info("[run][获得数据源：{}]", ordersDataSource.getClass());

    // users 数据源
    logger.info("[run][获得数据源：{}]", usersDataSource.getClass());
  }
}
