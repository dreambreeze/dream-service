package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.SecretMessage;
import cn.dreambreeze.server.mapper.SecretMessageMapper;
import cn.dreambreeze.server.service.SecretMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 私信表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class SecretMessageServiceImpl extends ServiceImpl<SecretMessageMapper, SecretMessage> implements SecretMessageService {

}
