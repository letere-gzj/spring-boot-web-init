package com.letere.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.letere.demo.common.bean.BaseEntity;
import lombok.Data;

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
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 关键词
     */
    private String demoKey;

    /**
     * 值
     */
    private String demoValue;
}
