package com.letere.demo.common.annotation;

import java.lang.annotation.*;

/**
 * @author gaozijie
 * @since 2024-03-01
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatLimit {
}