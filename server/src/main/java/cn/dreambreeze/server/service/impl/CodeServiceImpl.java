package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Code;
import cn.dreambreeze.server.mapper.CodeMapper;
import cn.dreambreeze.server.service.CodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微码表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

}
