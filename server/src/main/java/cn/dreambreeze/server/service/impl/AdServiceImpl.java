package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Ad;
import cn.dreambreeze.server.mapper.AdMapper;
import cn.dreambreeze.server.service.AdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class AdServiceImpl extends ServiceImpl<AdMapper, Ad> implements AdService {

}
