package cn.dreambreeze.server.config;

import cn.dreambreeze.server.utils.CommonUtils;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * My Meta Object Handler mybatis plus auto fill
 *
 * @author dream breeze
 * @date 2020/9/4 22:57
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

  @Override
  public void insertFill(MetaObject metaObject) {
    LOGGER.info("start insert fill ...");
    fillStrategy(metaObject, "createBy", 1L);
    fillStrategy(metaObject, "createName", "dream breeze");
    fillStrategy(metaObject, "createAt", CommonUtils.getUTCTimestamp());
    fillStrategy(metaObject, "updateAt", 0L);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    LOGGER.info("start insert fill ...");
    fillStrategy(metaObject, "updateAt", CommonUtils.getUTCTimestamp());
  }
}
