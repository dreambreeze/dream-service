package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Visitor;
import cn.dreambreeze.server.mapper.VisitorMapper;
import cn.dreambreeze.server.service.VisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 访客记录表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements VisitorService {

}
