package com.vicking.util.ann;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // TODO 开发完成后需要修改为: SOURCE
@Repeatable(SD_Groups.class)
public @interface SD_Group {
    String value();
}
