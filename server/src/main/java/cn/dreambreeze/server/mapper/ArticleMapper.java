package cn.dreambreeze.server.mapper;

import cn.dreambreeze.server.VO.res.ArticleResVO;
import cn.dreambreeze.server.domain.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-22
 */
public interface ArticleMapper extends BaseMapper<Article> {
  /**
   * fetch article list by sort id
   *
   * @param sortId
   * @param searchKey
   * @return List<ArticleResVO>
   */
  @Select(
    "<script>"
      + "SELECT a.*, se.sort_id"
      + " FROM d_article as a, d_sort_entity as se"
      + " WHERE"
      + " a.article_id = se.entity_id and"
      + "<if test=\"sortId!=null\">"
      + " se.sort_id = #{sortId} and"
      + "</if>"
      + "<if test=\"searchKey!=null\">"
      + " (a.title like CONCAT('%',#{searchKey},'%')  "
      + " or a.summary like CONCAT('%',#{searchKey},'%')"
      + " or a.content like CONCAT('%',#{searchKey},'%')"
      + ") and"
      + "</if>"
      + " a.delete_at = 0"
      + " order by update_at"
      + "</script>"
  )
  List<ArticleResVO> getArticleList(Long sortId, String searchKey);
}
