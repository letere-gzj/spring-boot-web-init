package com.letere.demo.entity.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gaozijie
 * @since 2023-08-22
 */
@Schema(description = "demo演示")
@Data
public class DemoParam {

    @Schema(description = "关键词")
    private String key;
}
