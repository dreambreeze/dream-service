package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.domain.SortEntity;
import cn.dreambreeze.server.mapper.SortEntityMapper;
import cn.dreambreeze.server.service.SortEntityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * sort handler
 *
 * @author dream breeze
 * @date 2020/9/12 12:47
 */
@Service
public class SortEntityHandler {

  private static final Logger LOG = LoggerFactory.getLogger(SortEntityHandler.class);

  @Resource
  private SortEntityMapper sortEntityMapper;

  @Autowired
  private SortEntityService sortEntityService;

  public boolean saveSortEntityForIds(List<Long> sortIds, Long entityId) {
    deleteByEntityId(entityId);
    ArrayList<SortEntity> sortEntities = new ArrayList<>();
    for (int i = 0, l = sortIds.size(); i < l; i++) {
      SortEntity sortEntity = new SortEntity();
      sortEntity.setSortId(sortIds.get(i));
      sortEntity.setEntityId(entityId);
      sortEntities.add(sortEntity);
    }
    return sortEntityService.saveBatch(sortEntities);
  }

  public int deleteByEntityId(Long entityId) {
    QueryWrapper<SortEntity> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("entity_id", entityId);
    return sortEntityMapper.delete(queryWrapper);
  }
}
