package com.vicking.util;


import com.vicking.util.tools.SDBuilder;
import lombok.Getter;
import lombok.Setter;

import java.beans.IntrospectionException;

@Getter @Setter
public class B extends A {

    private boolean sex;

    private String adress;

    public static void main(String[] args) throws IntrospectionException {
        SDBuilder.build(B.class);
    }
}
