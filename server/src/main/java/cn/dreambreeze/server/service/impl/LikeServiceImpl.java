package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Like;
import cn.dreambreeze.server.mapper.LikeMapper;
import cn.dreambreeze.server.service.LikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 点赞收藏表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {

}
