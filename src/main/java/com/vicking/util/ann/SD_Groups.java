package com.vicking.util.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // TODO 开发完成后需要修改为: SOURCE
public @interface SD_Groups {
    SD_Group value()[];
}
