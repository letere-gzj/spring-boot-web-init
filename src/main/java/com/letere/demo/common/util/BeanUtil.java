package com.letere.demo.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author gaozijie
 * @since 2023-08-04
 */
public class BeanUtil {

    /**
     * 对象赋值
     * @param source 赋值源
     * @param supplier 赋值对象
     * @return
     * @param <S>
     * @param <T>
     */
    public static <S, T> T getBean(S source, Supplier<T> supplier) {
        if (Objects.isNull(source)) {
            return supplier.get();
        }
        T target = supplier.get();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 集合对象赋值
     * @param sources 赋值源
     * @param supplier 赋值对象
     * @return
     * @param <S>
     * @param <T>
     */
    public static <S, T> List<T> getBeans(List<S> sources, Supplier<T> supplier) {
        if (CollectionUtils.isEmpty(sources)) {
            return new ArrayList<>();
        }
        return sources.stream().map(x -> {
            T target = supplier.get();
            BeanUtils.copyProperties(x, target);
            return target;
        }).toList();
    }
}
