package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.UserComment;
import cn.dreambreeze.server.mapper.UserCommentMapper;
import cn.dreambreeze.server.service.UserCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper, UserComment> implements UserCommentService {

}
