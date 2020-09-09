package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.SystemMessage;
import cn.dreambreeze.server.mapper.SystemMessageMapper;
import cn.dreambreeze.server.service.SystemMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统通知表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class SystemMessageServiceImpl extends ServiceImpl<SystemMessageMapper, SystemMessage> implements SystemMessageService {

}
