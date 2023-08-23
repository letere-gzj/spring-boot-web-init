package com.letere.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.letere.demo.common.bean.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author letere
 * @since 2023-08-04
 */
@TableName("demo")
@Data
public class Demo extends BaseEntity {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 关键词
     */
    private String key;
    /**
     * 值
     */
    private String value;
}
