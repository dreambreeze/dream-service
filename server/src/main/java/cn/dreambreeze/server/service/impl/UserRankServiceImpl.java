package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.UserRank;
import cn.dreambreeze.server.mapper.UserRankMapper;
import cn.dreambreeze.server.service.UserRankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 等级表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class UserRankServiceImpl extends ServiceImpl<UserRankMapper, UserRank> implements UserRankService {

}
