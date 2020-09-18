package cn.dreambreeze.server.annotation;

import java.lang.annotation.*;

/**
 * @author dream breeze
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {

}
