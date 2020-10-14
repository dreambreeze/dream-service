package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.PageVO;
import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.req.ArticleReqVO;
import cn.dreambreeze.server.VO.res.ArticleResVO;
import cn.dreambreeze.server.domain.Article;
import cn.dreambreeze.server.service.ArticleService;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.ArticleHandler;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * article controller
 *
 * @author dream breeze
 * @date 2020/9/2 22:53
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @Autowired
  private ArticleHandler articleHandler;

  @GetMapping("/all")
  public ResultVO<List<Article>> getAllArticle() {
    return ResultBean.success(articleService.list());
  }

  @GetMapping("/list")
  public ResultVO getArticleList(@RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("sortId") Long sortId,
                                 @RequestParam("searchKey") String searchKey) {
    PageHelper.startPage(pageNum, pageSize);
    List<ArticleResVO> articleList = articleHandler.getArticleList(sortId, searchKey);
    PageInfo<ArticleResVO> articleResVOPageVO = new PageInfo<>(articleList);
    articleResVOPageVO.setList(articleList);
    PageVO<ArticleResVO> articlePageVO = new PageVO<>();
    articlePageVO.setItems(articleList);
    articlePageVO.setPageSize(pageSize);
    articlePageVO.setPageNum(pageNum);
    articlePageVO.setTotal(articleResVOPageVO.getTotal());
    return ResultBean.success(articlePageVO);
  }

  @GetMapping("/{articleId}")
  public ResultVO getArticle(@PathVariable("articleId") String articleId) {
    return ResultBean.success(articleHandler.getArticleById(articleId));
  }

  @PostMapping
  public ResultVO addArticle(@RequestBody ArticleReqVO articleReqVO, HttpServletRequest request) {
    return ResultBean.success(articleHandler.saveArticle(articleReqVO, request));
  }

  @PatchMapping
  public ResultVO updateArticle(@RequestBody ArticleReqVO articleReqVO, HttpServletRequest request) {
    return ResultBean.success(articleHandler.saveArticle(articleReqVO, request));
  }

  @DeleteMapping("/{articleId}")
  public ResultVO<Boolean> deleteArticle(@PathVariable("articleId") String articleId) {
    return ResultBean.success(articleService.removeById(articleId));
  }
}
