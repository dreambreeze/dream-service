package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.VO.res.SortResVO;
import cn.dreambreeze.server.constant.ResultCode;
import cn.dreambreeze.server.domain.Sort;
import cn.dreambreeze.server.exception.CustomException;
import cn.dreambreeze.server.mapper.SortMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * sort handler
 *
 * @author dream breeze
 * @date 2020/9/12 12:47
 */
@Service
public class SortHandler {

  private static final Logger LOG = LoggerFactory.getLogger(SortHandler.class);

  @Resource
  private SortMapper sortMapper;

  public Sort selectSortByName(String sortName) {
    QueryWrapper<Sort> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("sort_name", sortName);
    return sortMapper.selectOne(queryWrapper);
  }

  public SortResVO addSort(SortResVO sortResVO) {
    Sort sort = selectSortByName(sortResVO.getSortName());
    if (null != sort) {
      throw new CustomException(ResultCode.SORT_HAS_EXISTED);
    }
    sort = new Sort();
    BeanUtils.copyProperties(sortResVO, sort);
    sortMapper.insert(sort);
    BeanUtils.copyProperties(sort, sortResVO);
    return sortResVO;
  }

}
