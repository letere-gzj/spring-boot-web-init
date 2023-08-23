package com.letere.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.letere.demo.common.bean.PageParam;
import com.letere.demo.entity.Demo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.letere.demo.entity.dto.DemoDTO;
import com.letere.demo.entity.param.DemoParam;
import com.letere.demo.entity.vo.DemoVO;

/**
 * @author letere
 * @since 2023-08-04
 */
public interface DemoService extends IService<Demo> {

    /**
     * 分页查询
     * @param pageParam 分页参数
     * @param demoParam 查询参数
     * @return
     */
    IPage<DemoVO> pageDemo(PageParam<Demo> pageParam, DemoParam demoParam);

    /**
     * 获取demo通过id
     * @param id 主键id
     * @return
     */
    DemoVO getDemoById(Integer id);

    /**
     * 新增
     * @param demoDTO demoDTO
     */
    void saveDemo(DemoDTO demoDTO);

    /**
     * 修改
     * @param demoDTO demoDTO
     */
    void updateDemo(DemoDTO demoDTO);

    /**
     * 删除
     * @param id 主键id
     */
    void deleteDemo(Integer id);
}
