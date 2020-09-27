package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.res.SortResVO;
import cn.dreambreeze.server.domain.Sort;
import cn.dreambreeze.server.service.SortService;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.SortHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * sort controller
 *
 * @author dream breeze
 * @date 2020/9/12 12:47
 */
@RestController
@RequestMapping("/sort")
public class SortController {

  @Autowired
  private SortService sortService;

  @Autowired
  private SortHandler sortHandler;

  @GetMapping("/all")
  public ResultVO getAllSort() {
    return ResultBean.success(sortService.list());
  }

  @GetMapping("/list")
  public ResultVO getSortList(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum, @RequestParam("sortName") String sortName) {
    PageHelper.startPage(pageNum, pageSize);
    QueryWrapper<Sort> wrapper = new QueryWrapper<>();
    wrapper.like("sortName", sortName);
    List<Sort> sortList = sortService.list(wrapper);
    PageInfo<Sort> pageInfo = new PageInfo<>(sortList);
    pageInfo.setList(sortList);
    return ResultBean.success(pageInfo);
  }

  @GetMapping("/{sortId}")
  public ResultVO getSort(@PathVariable("sortId") String sortId) {
    return ResultBean.success(sortService.getById(sortId));
  }

  @PostMapping
  public ResultVO addSort(@RequestBody @Validated SortResVO sort) {
    return ResultBean.success(sortHandler.addSort(sort));
  }

  @PatchMapping
  public ResultVO updateSort(@RequestBody @Validated SortResVO sortResVO) {
    Sort sort = new Sort();
    BeanUtils.copyProperties(sortResVO, sort);
    return ResultBean.success(sortService.updateById(sort));
  }

  @DeleteMapping("/{sortId}")
  public ResultVO deleteSort(@PathVariable("sortId") String sortId) {
    return ResultBean.success(sortService.removeById(sortId));
  }

}
