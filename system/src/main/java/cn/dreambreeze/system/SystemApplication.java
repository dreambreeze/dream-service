package cn.dreambreeze.system;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * system application
 *
 * @author dream breeze
 * @date 2020/9/2 22:23
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("cn.dreambreeze")
@MapperScan("cn.dreambreeze.server.mapper")
public class SystemApplication {
  private static final Logger LOG = LoggerFactory.getLogger(SystemApplication.class);

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(SystemApplication.class);
    Environment env = app.run(args).getEnvironment();
    LOG.info("启动成功！！");
    LOG.info("System地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
  }
}
