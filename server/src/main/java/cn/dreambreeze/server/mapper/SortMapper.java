package cn.dreambreeze.server.mapper;

import cn.dreambreeze.server.VO.res.SortResVO;
import cn.dreambreeze.server.domain.Sort;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
public interface SortMapper extends BaseMapper<Sort> {
  /**
   * fetch sort list by entity id
   *
   * @param entityId
   * @return List<SortResVO>
   */
  @Select(
    " select"
      + " s.*"
      + " from"
      + " d_sort s, d_sort_entity se"
      + " where"
      + " se.sort_id = s.sort_id"
      + " and"
      + " se.entity_id = #{entityId}"
  )
  List<SortResVO> getSortListByEntityId(@Param("entityId") Long entityId);
}
