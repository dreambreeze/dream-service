package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Saying;
import cn.dreambreeze.server.mapper.SayingMapper;
import cn.dreambreeze.server.service.SayingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 箴言表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class SayingServiceImpl extends ServiceImpl<SayingMapper, Saying> implements SayingService {

}
