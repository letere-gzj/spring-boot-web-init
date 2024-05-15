package com.letere.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.letere.demo.common.bean.PageParam;
import com.letere.demo.common.util.BeanUtil;
import com.letere.demo.entity.Demo;
import com.letere.demo.entity.dto.DemoDTO;
import com.letere.demo.entity.param.DemoParam;
import com.letere.demo.entity.vo.DemoVO;
import com.letere.demo.mapper.DemoMapper;
import com.letere.demo.service.DemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author letere
 * @since 2023-08-04
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public IPage<DemoVO> pageDemo(PageParam<Demo> pageParam, DemoParam demoParam) {
        return demoMapper.pageDemo(pageParam.getPage(), demoParam);
    }

    @Override
    public DemoVO getDemoById(Integer id) {
        Demo demo = this.getById(id);
        return BeanUtil.getBean(demo, DemoVO::new);
    }

    @Override
    public void saveDemo(DemoDTO demoDTO) {
        Demo demo = BeanUtil.getBean(demoDTO, Demo::new);
        this.save(demo);
    }

    @Override
    public void updateDemo(DemoDTO demoDTO) {
        Demo demo = BeanUtil.getBean(demoDTO, Demo::new);
        this.updateById(demo);
    }

    @Override
    public void deleteDemo(Integer id) {
        this.removeById(id);
    }
}
