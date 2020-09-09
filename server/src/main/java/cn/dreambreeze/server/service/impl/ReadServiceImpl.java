package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Read;
import cn.dreambreeze.server.mapper.ReadMapper;
import cn.dreambreeze.server.service.ReadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 已读表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class ReadServiceImpl extends ServiceImpl<ReadMapper, Read> implements ReadService {

}
