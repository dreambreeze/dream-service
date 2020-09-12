package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Photos;
import cn.dreambreeze.server.mapper.PhotosMapper;
import cn.dreambreeze.server.service.PhotosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相片表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class PhotosServiceImpl extends ServiceImpl<PhotosMapper, Photos> implements PhotosService {

}
