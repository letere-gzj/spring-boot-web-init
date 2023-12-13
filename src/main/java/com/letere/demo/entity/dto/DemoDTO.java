package com.letere.demo.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gaozijie
 * @since 2023-08-22
 */
@Data
public class DemoDTO {
    @Schema(description = "主键id")
    private Integer id;

    @Schema(description = "关键词")
    private String key;

    @Schema(description = "值")
    private String value;
}
