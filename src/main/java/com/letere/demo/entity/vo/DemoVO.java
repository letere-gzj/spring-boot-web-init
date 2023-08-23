package com.letere.demo.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gaozijie
 * @date 2023-08-22
 */
@Data
public class DemoVO {
    @Schema(description = "主键id")
    private Integer id;

    @Schema(description = "关键词")
    private String key;

    @Schema(description = "值")
    private String value;
}
