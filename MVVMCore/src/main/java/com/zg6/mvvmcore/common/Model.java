package com.zg6.mvvmcore.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.common
 * @ClassName: Model
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 10:59
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 10:59
 * @UpdateRemark:
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public  @interface Model {
    String value() default "";
}
