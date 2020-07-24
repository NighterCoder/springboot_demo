package com.tgou.hikaricp_multiple;

import com.tgou.hikaricp_multiple.config.Person;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
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

  @Resource(name = "ordersDataSource")
  private DataSource ordersDataSource;

  @Resource(name = "usersDataSource")
  private DataSource usersDataSource;

  @Autowired
  private Person person;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    // orders 数据源
    try (Connection conn = ordersDataSource.getConnection()) {
      // 这里，可以做点什么
      logger.info("[run][ordersDataSource 获得连接：{}]", conn);
      logger.info(person.getAge()+" "+person.getHeight()+" "+person.getSalary());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    // users 数据源
    try (Connection conn = usersDataSource.getConnection()) {
      // 这里，可以做点什么
      logger.info("[run][usersDataSource 获得连接：{}]", conn);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
