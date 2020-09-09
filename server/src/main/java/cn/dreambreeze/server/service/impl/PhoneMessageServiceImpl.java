package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.PhoneMessage;
import cn.dreambreeze.server.mapper.PhoneMessageMapper;
import cn.dreambreeze.server.service.PhoneMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短信记录表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class PhoneMessageServiceImpl extends ServiceImpl<PhoneMessageMapper, PhoneMessage> implements PhoneMessageService {

}
