package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Article;
import cn.dreambreeze.server.mapper.ArticleMapper;
import cn.dreambreeze.server.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
