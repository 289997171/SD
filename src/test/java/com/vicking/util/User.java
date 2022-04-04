package com.vicking.util;

import com.vicking.util.ann.SD_Group;
import com.vicking.util.ann.SD_Groups;
import com.vicking.util.tools.SDBuilder;
import lombok.Getter;
import lombok.Setter;

import java.beans.IntrospectionException;

@Getter @Setter
@SD_Groups({@SD_Group("4Create"), @SD_Group("4Update"), @SD_Group("4Delete")})
public class User {

    // 只有Update 和 Delete 的情况下才包含id
    // 也就是说 Create情况下不包含id
    @SD_Groups({@SD_Group("4Update"), @SD_Group("4Delete")})
    private int id;

    private String name;

    private int fr;

    public static void main(String[] args) throws IntrospectionException {
        SDBuilder.build(User.class);
    }
}
