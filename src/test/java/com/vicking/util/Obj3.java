package com.vicking.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class Obj3 {
//    private int iv;
//    private Integer iv2;
//
//    public int iv3;
//    public Integer iv4;

    private List<Boolean> bs1;
    public List<Boolean> bs2;

    private Set<Boolean> bs3;
    public HashSet<Boolean> bs4;

    private boolean[] bs5;
    public boolean[] bs6;

    private Obj4 obj4;

    private List<Obj4> obj41;
    public List<Obj4> obj42;

    private Set<Obj4> obj43;
    public HashSet<Obj4> obj44;

    private Obj4[] obj45;
    public Obj4[] obj46;



}
