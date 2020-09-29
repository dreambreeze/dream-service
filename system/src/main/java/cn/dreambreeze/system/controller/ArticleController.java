package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.req.ArticleReqVO;
import cn.dreambreeze.server.domain.Article;
import cn.dreambreeze.server.service.ArticleService;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.ArticleHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
  public ResultVO<PageInfo> getArticleList(
    @RequestParam("pageSize") Integer pageSize,
    @RequestParam("pageNum") Integer pageNum,
    @RequestParam("articleName") String articleName
  ) {
    PageHelper.startPage(pageNum, pageSize);
    QueryWrapper<Article> wrapper = new QueryWrapper();
    wrapper.like("article_name", articleName);
    List<Article> articleList = articleService.list(wrapper);
    PageInfo pageInfo = new PageInfo<>(articleList);
    pageInfo.setList(articleList);
    return ResultBean.success(pageInfo);
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
