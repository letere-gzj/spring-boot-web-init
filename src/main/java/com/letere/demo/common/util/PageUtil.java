package com.letere.demo.common.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;

import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author gaozijie
 * @date 2023-08-04
 */
public class PageUtil {

    /**
     * page对象赋值
     * @param source 赋值源
     * @param supplier 赋值对象
     * @return
     * @param <S>
     * @param <T>
     */
    public static <S, T> Page<T> getPage(Page<S> source, Supplier<T> supplier) {
        Page<T> target = new Page<>();
        BeanUtils.copyProperties(source, target);
        // 复制数组
        target.setRecords(
                source.getRecords().stream().map(x -> {
                    T record = supplier.get();
                    BeanUtils.copyProperties(x, record);
                    return record;
                }).collect(Collectors.toList())
        );
        return target;
    }
}
