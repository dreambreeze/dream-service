package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.StayMessage;
import cn.dreambreeze.server.mapper.StayMessageMapper;
import cn.dreambreeze.server.service.StayMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 留言表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class StayMessageServiceImpl extends ServiceImpl<StayMessageMapper, StayMessage> implements StayMessageService {

}
