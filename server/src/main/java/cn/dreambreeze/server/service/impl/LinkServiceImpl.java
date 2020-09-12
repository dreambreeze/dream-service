package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Link;
import cn.dreambreeze.server.mapper.LinkMapper;
import cn.dreambreeze.server.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 链接表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}
