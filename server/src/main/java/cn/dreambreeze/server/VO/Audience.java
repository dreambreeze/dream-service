package cn.dreambreeze.server.VO;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dream breeze
 * @date 2020/9/17 15:09
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
  private String clientId;
  private String base64Secret;
  private String name;
  private int expiresSecond;
}