package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.domain.Saying;
import cn.dreambreeze.server.service.SayingService;
import cn.dreambreeze.server.utils.ResultBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author dream breeze
 * @Date 2021/1/7 10:16
 */
@RestController
@RequestMapping("/saying")
public class SayingController {

  @Autowired
  private SayingService sayingService;

  @GetMapping("/random")
  public final ResultVO getRandomSaying() {
    QueryWrapper<Saying> queryWrapper = new QueryWrapper<>();
    queryWrapper.last("order by rand() limit 1");
    Saying saying = sayingService.getOne(queryWrapper);
    return ResultBean.success(saying);
  }

  @GetMapping("/list")
  public final ResultVO getSayings() {
    List<Saying> sayings = sayingService.list();
    return ResultBean.success(sayings);
  }

  @PostMapping
  public ResultVO addSaying(@RequestBody @Validated Saying saying) {
    return ResultBean.success(sayingService.save(saying));
  }

  @PatchMapping
  public ResultVO updateSaying(@RequestBody @Validated Saying saying) {
    return ResultBean.success(sayingService.updateById(saying));
  }

  @DeleteMapping("/{sayingId}")
  public ResultVO deleteSaying(@PathVariable("sayingId") String sayingId) {
    return ResultBean.success(sayingService.removeById(sayingId));
  }

}
