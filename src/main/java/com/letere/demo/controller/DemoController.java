package com.letere.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.letere.demo.common.bean.PageParam;
import com.letere.demo.common.bean.Result;
import com.letere.demo.entity.Demo;
import com.letere.demo.entity.dto.DemoDTO;
import com.letere.demo.entity.param.DemoParam;
import com.letere.demo.entity.vo.DemoVO;
import com.letere.demo.service.DemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaozijie
 * @since 2023-08-22
 */
@Tag(name = "demo接口")
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<?> pageDemo(@ParameterObject PageParam<Demo> pageParam, DemoParam demoParam) {
        IPage<DemoVO> page = demoService.pageDemo(pageParam, demoParam);
        return Result.success(page);
    }

    @GetMapping("/info/{id}")
    @Operation(summary = "获取详情")
    @Parameter(name = "id", description = "主键")
    public Result<?> getDemo(@PathVariable("id") Integer id) {
        DemoVO demoVO = demoService.getDemoById(id);
        return Result.success(demoVO);
    }

    @PostMapping
    @Operation(summary = "新增")
    public Result<?> saveDemo(@RequestBody DemoDTO demoDTO) {
        demoService.saveDemo(demoDTO);
        return Result.success();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result<?> updateDemo(@RequestBody DemoDTO demoDTO) {
        demoService.updateDemo(demoDTO);
        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @Parameter(name = "id", description = "主键")
    public Result<?> deleteDemo(Integer id) {
        demoService.deleteDemo(id);
        return Result.success();
    }
}
