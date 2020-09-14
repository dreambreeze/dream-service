package cn.dreambreeze.server.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * app config
 *
 * @author dream breeze
 * @date 2020/9/4 21:58
 */
@Configuration
public class AppConfig {
  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customJackson() {
    return jacksonObjectMapperBuilder -> {
      jacksonObjectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
      // Jackson全局转换long类型为String，解决jackson序列化时long类型缺失精度问题
      // 自定义Long类型转换 超过12个数字用String格式返回，由于js的number只能表示15个数字
      jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance);
      jacksonObjectMapperBuilder.failOnUnknownProperties(false);
      jacksonObjectMapperBuilder.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    };
  }
}
