package com.tgou.hikaricp_single;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(Application.class);

  @Autowired
  private DataSource dataSource;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) {
    try (Connection conn = dataSource.getConnection()) {
      // 这里，可以做点什么
      logger.info("[run][获得连接：{}]", conn);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
