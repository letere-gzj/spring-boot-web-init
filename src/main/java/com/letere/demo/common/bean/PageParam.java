package com.letere.demo.common.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.Ignore;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页参数
 * @author gaozijie
 * @since 2023-08-04
 */
@Data
public class PageParam<T> {

    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "页面数据大小")
    private Integer pageSize;

    @Hidden
    public Page<T> getPage() {
        return new Page<>(pageNum, pageSize);
    }
}
