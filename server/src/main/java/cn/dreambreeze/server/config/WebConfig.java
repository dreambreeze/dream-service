package cn.dreambreeze.server.config;

import cn.dreambreeze.server.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author dream breeze
 * @date 2020/9/17 17:11
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Bean
  public JwtInterceptor getInterceptor() {
    return new JwtInterceptor();

  }

  /**
   * 添加拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //拦截路径可自行配置多个 可用 ，分隔开
    registry.addInterceptor(getInterceptor()).addPathPatterns("/**").excludePathPatterns("*/auth/login", "*/user/register");
  }

  /**
   * 跨域支持
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowCredentials(true)
      .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
      .maxAge(3600 * 24);
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

  }

  @Override
  public void addFormatters(FormatterRegistry formatterRegistry) {

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

  }

  @Override
  public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

  }

  @Override
  public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

  }

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

  }

  @Override
  public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

  }

  @Override
  public Validator getValidator() {
    return null;
  }

  @Override
  public MessageCodesResolver getMessageCodesResolver() {
    return null;
  }
}
