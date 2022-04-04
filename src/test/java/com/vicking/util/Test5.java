package com.vicking.util;

import com.vicking.util.tools.SDBuilder;
import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;

public class Test5 {

    @Test
    void test1() throws IntrospectionException {
        SDBuilder.build(Obj3.class);
        SDBuilder.build(Obj4.class);
    }
}
