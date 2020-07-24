package com.tgou.druid_single;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DruidSingleApplication implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(DruidSingleApplication.class);

  @Autowired
  private DataSource dataSource;

  public static void main(String[] args) {
    SpringApplication.run(DruidSingleApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("[run][获得数据源：{}]", dataSource.getClass());
  }
}
