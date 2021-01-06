package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.VO.req.ArticleReqVO;
import cn.dreambreeze.server.VO.res.ArticleResVO;
import cn.dreambreeze.server.VO.res.UserResVO;
import cn.dreambreeze.server.domain.Article;
import cn.dreambreeze.server.mapper.ArticleMapper;
import cn.dreambreeze.server.utils.CommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * article handler
 *
 * @author dream breeze
 * @date 2020/9/7 22:08
 */
@Service
public class ArticleHandler {

  @Resource
  private ArticleMapper articleMapper;

  @Autowired
  private SortEntityHandler sortEntityHandler;

  @Autowired
  private SortHandler sortHandler;

  public ArticleResVO saveArticle(ArticleReqVO articleReqVO, HttpServletRequest request) {
    String remoteIpAddr = CommonUtils.getRemoteIpAddr(request);
    UserResVO user = CommonUtils.getUserByRequest(request);

    Article article = new Article();
    article.setTitle(articleReqVO.getTitle());
    article.setSummary(articleReqVO.getSummary());
    article.setContent(articleReqVO.getContent());
    article.setCoverImg(articleReqVO.getCoverImg());
    article.setSendIp(remoteIpAddr);
    article.setSecurity(articleReqVO.getSecurity());
    article.setStatus(articleReqVO.getStatus());
    article.setTop(articleReqVO.getTop());
    article.setSupport(articleReqVO.getSupport());
    article.setCreateBy(user.getUserId());
    article.setCreateName(user.getName());
    article.setCreateAt(System.currentTimeMillis());
    article.setUpdateAt(System.currentTimeMillis());

    if (ObjectUtils.isEmpty(articleReqVO.getArticleId())) {
      articleMapper.insert(article);
    } else {
      article.setArticleId(articleReqVO.getArticleId());
      articleMapper.updateById(article);
    }

    ArticleResVO articleResVO = new ArticleResVO();
    BeanUtils.copyProperties(article, articleResVO);

    sortEntityHandler.saveSortEntityForIds(articleReqVO.getSort(), article.getArticleId());

    return articleResVO;
  }

  public ArticleResVO getArticleById(String articleId) {
    Article article = articleMapper.selectById(articleId);
    ArticleResVO articleResVO = new ArticleResVO();
    articleResVO.setSortList(sortHandler.getSortListByEntityId(article.getArticleId()));
    BeanUtils.copyProperties(article, articleResVO);
    return articleResVO;
  }

  public List<ArticleResVO> getArticleList(Long sortId, String searchKey) {
    List<ArticleResVO> articleResVOS = articleMapper.getArticleList(sortId, searchKey);
    for (ArticleResVO article : articleResVOS) {
      article.setSortList(sortHandler.getSortListByEntityId(article.getArticleId()));
    }
    return articleResVOS;
  }
}
