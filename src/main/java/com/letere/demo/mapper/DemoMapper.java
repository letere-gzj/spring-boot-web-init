package com.letere.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.letere.demo.entity.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.letere.demo.entity.param.DemoParam;
import com.letere.demo.entity.vo.DemoVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author letere
 * @since 2023-08-04
 */
public interface DemoMapper extends BaseMapper<Demo> {

    /**
     * 分页查询
     * @param pageParam 分页参数
     * @param demoParam 查询参数
     * @return 分页对象
     */
    IPage<DemoVO> pageDemo(IPage<Demo> pageParam, @Param("demoParam") DemoParam demoParam);
}
