package com.vicking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Obj3Reader {
    public static Obj3 read(InputStream is) throws IOException {
        if (is.read() == 0) return null;
        Obj3 o = new Obj3();
        o.iv3 = DeseriUtil.getInt(is);
        o.iv4 = DeseriUtil.getInt(is);
        {
            int lenjlX1cd = DeseriUtil.getShort(is);
            if (lenjlX1cd > 0) {
                ArrayList<Boolean> listaJt05R = new ArrayList<>();
                for (int iUKU7uc = 0; iUKU7uc < lenjlX1cd; iUKU7uc++) {
                    listaJt05R.add(DeseriUtil.getBoolean(is));
                }
                o.bs2 = listaJt05R;
            }
        }
        {
            int lenFWfajr = DeseriUtil.getShort(is);
            if (lenFWfajr > 0) {
                HashSet<Boolean> setBotuvd = new HashSet<>();
                for (int iNm81Ba = 0; iNm81Ba < lenFWfajr; iNm81Ba++) {
                    setBotuvd.add(DeseriUtil.getBoolean(is));
                }
                o.bs4 = setBotuvd;
            }
        }
        {
            int len86MOjT = DeseriUtil.getShort(is);
            if (len86MOjT > 0) {
                boolean[] arrNq8oG8 = new boolean[len86MOjT];
                for (int i1p9oIj = 0; i1p9oIj < len86MOjT; i1p9oIj++) {
                    arrNq8oG8[i1p9oIj] = DeseriUtil.getBoolean(is);
                }
                o.bs6 = arrNq8oG8;
            }
        }
        {
            int lencLOSrj = DeseriUtil.getShort(is);
            if (lencLOSrj > 0) {
                ArrayList<Obj4> listPtgs7j = new ArrayList<>();
                for (int ilO0W1C = 0; ilO0W1C < lencLOSrj; ilO0W1C++) {
                    listPtgs7j.add(Obj4Reader.read(is));
                }
                o.obj42 = listPtgs7j;
            }
        }
        {
            int lenmPt2Zl = DeseriUtil.getShort(is);
            if (lenmPt2Zl > 0) {
                HashSet<Obj4> setM3egfC = new HashSet<>();
                for (int i47Z3V6 = 0; i47Z3V6 < lenmPt2Zl; i47Z3V6++) {
                    setM3egfC.add(Obj4Reader.read(is));
                }
                o.obj44 = setM3egfC;
            }
        }
        {
            int lenRiXA0t = DeseriUtil.getShort(is);
            if (lenRiXA0t > 0) {
                Obj4[] arrgccUYv = new Obj4[lenRiXA0t];
                for (int iKcjghk = 0; iKcjghk < lenRiXA0t; iKcjghk++) {
                    arrgccUYv[iKcjghk] = Obj4Reader.read(is);
                }
                o.obj46 = arrgccUYv;
            }
        }
        {
            int lenxtWdrb = DeseriUtil.getShort(is);
            if (lenxtWdrb > 0) {
                HashMap<Integer, HashMap<Integer, HashMap<Integer, Float>>> mapcLfvG9 = new HashMap<Integer, HashMap<Integer, HashMap<Integer, Float>>>();
                for (int ibOFHJU = 0; ibOFHJU < lenxtWdrb; ibOFHJU++) {
                    Integer _k9ikog6 = DeseriUtil.getInt(is);
                    HashMap<Integer, HashMap<Integer, Float>> _vUEl9IF = null;
                    {
                        int len5dx0Un = DeseriUtil.getShort(is);
                        if (len5dx0Un > 0) {
                            HashMap<Integer, HashMap<Integer, Float>> mapRgTgag = new HashMap<Integer, HashMap<Integer, Float>>();
                            for (int ikmscQX = 0; ikmscQX < len5dx0Un; ikmscQX++) {
                                Integer _kCBx35T = DeseriUtil.getInt(is);
                                HashMap<Integer, Float> _vHuhDgF = null;
                                {
                                    int len0RusAd = DeseriUtil.getShort(is);
                                    if (len0RusAd > 0) {
                                        HashMap<Integer, Float> maplkewsg = new HashMap<Integer, Float>();
                                        for (int igmWjrb = 0; igmWjrb < len0RusAd; igmWjrb++) {
                                            maplkewsg.put(DeseriUtil.getInt(is), DeseriUtil.getFloat(is));
                                        }
                                        _vHuhDgF = maplkewsg;
                                    }
                                }
                                mapRgTgag.put(_kCBx35T, _vHuhDgF);
                            }
                            _vUEl9IF = mapRgTgag;
                        }
                    }
                    mapcLfvG9.put(_k9ikog6, _vUEl9IF);
                }
                o.map6 = mapcLfvG9;
            }
        }
        o.setIv(DeseriUtil.getInt(is));
        o.setIv2(DeseriUtil.getInt(is));
        {
            int lenGsndBy = DeseriUtil.getShort(is);
            if (lenGsndBy > 0) {
                ArrayList<Boolean> listYSQe73 = new ArrayList<>();
                for (int ilaiHHc = 0; ilaiHHc < lenGsndBy; ilaiHHc++) {
                    listYSQe73.add(DeseriUtil.getBoolean(is));
                }
                o.setBs1(listYSQe73);
            }
        }
        {
            int lenlaHZUk = DeseriUtil.getShort(is);
            if (lenlaHZUk > 0) {
                HashSet<Boolean> setwPJdCl = new HashSet<>();
                for (int igoe9ML = 0; igoe9ML < lenlaHZUk; igoe9ML++) {
                    setwPJdCl.add(DeseriUtil.getBoolean(is));
                }
                o.setBs3(setwPJdCl);
            }
        }
        {
            int len9pzesO = DeseriUtil.getShort(is);
            if (len9pzesO > 0) {
                boolean[] arrZveOQ6 = new boolean[len9pzesO];
                for (int iiR86dW = 0; iiR86dW < len9pzesO; iiR86dW++) {
                    arrZveOQ6[iiR86dW] = DeseriUtil.getBoolean(is);
                }
                o.setBs5(arrZveOQ6);
            }
        }
        o.setObj4(Obj4Reader.read(is));
        {
            int lenDGlZjE = DeseriUtil.getShort(is);
            if (lenDGlZjE > 0) {
                ArrayList<Obj4> listc2dmfV = new ArrayList<>();
                for (int iT3fAGk = 0; iT3fAGk < lenDGlZjE; iT3fAGk++) {
                    listc2dmfV.add(Obj4Reader.read(is));
                }
                o.setObj41(listc2dmfV);
            }
        }
        {
            int lenaPFiLx = DeseriUtil.getShort(is);
            if (lenaPFiLx > 0) {
                HashSet<Obj4> setBS5Jr9 = new HashSet<>();
                for (int ikQPURw = 0; ikQPURw < lenaPFiLx; ikQPURw++) {
                    setBS5Jr9.add(Obj4Reader.read(is));
                }
                o.setObj43(setBS5Jr9);
            }
        }
        {
            int lenyoXPbs = DeseriUtil.getShort(is);
            if (lenyoXPbs > 0) {
                Obj4[] arrVo51XS = new Obj4[lenyoXPbs];
                for (int iIxBGeF = 0; iIxBGeF < lenyoXPbs; iIxBGeF++) {
                    arrVo51XS[iIxBGeF] = Obj4Reader.read(is);
                }
                o.setObj45(arrVo51XS);
            }
        }
        {
            int lenA3FAJ7 = DeseriUtil.getShort(is);
            if (lenA3FAJ7 > 0) {
                HashMap<Integer, String> mapQChZrS = new HashMap<Integer, String>();
                for (int iBLf4yt = 0; iBLf4yt < lenA3FAJ7; iBLf4yt++) {
                    mapQChZrS.put(DeseriUtil.getInt(is), DeseriUtil.getString(is));
                }
                o.setMap1(mapQChZrS);
            }
        }
        {
            int lenvkS7Ig = DeseriUtil.getShort(is);
            if (lenvkS7Ig > 0) {
                HashMap<Integer, ArrayList<String>> mapgT9NwZ = new HashMap<Integer, ArrayList<String>>();
                for (int iegAQPb = 0; iegAQPb < lenvkS7Ig; iegAQPb++) {
                    Integer _kVqE0SB = DeseriUtil.getInt(is);
                    ArrayList<String> _vMaAGXh = null;
                    {
                        int lenGZdc60 = DeseriUtil.getShort(is);
                        if (lenGZdc60 > 0) {
                            ArrayList<String> listD3qkQP = new ArrayList<>();
                            for (int ikjqzNU = 0; ikjqzNU < lenGZdc60; ikjqzNU++) {
                                listD3qkQP.add(DeseriUtil.getString(is));
                            }
                            _vMaAGXh = listD3qkQP;
                        }
                    }
                    mapgT9NwZ.put(_kVqE0SB, _vMaAGXh);
                }
                o.setMap2(mapgT9NwZ);
            }
        }
        {
            int len4gQErF = DeseriUtil.getShort(is);
            if (len4gQErF > 0) {
                HashMap<Integer, HashSet<String>> mapEs0mux = new HashMap<Integer, HashSet<String>>();
                for (int iUlWJrD = 0; iUlWJrD < len4gQErF; iUlWJrD++) {
                    Integer _kuSt6yr = DeseriUtil.getInt(is);
                    HashSet<String> _vDWeF79 = null;
                    {
                        int len0WuSKu = DeseriUtil.getShort(is);
                        if (len0WuSKu > 0) {
                            HashSet<String> setbk9eOA = new HashSet<>();
                            for (int i49FT0v = 0; i49FT0v < len0WuSKu; i49FT0v++) {
                                setbk9eOA.add(DeseriUtil.getString(is));
                            }
                            _vDWeF79 = setbk9eOA;
                        }
                    }
                    mapEs0mux.put(_kuSt6yr, _vDWeF79);
                }
                o.setMap3(mapEs0mux);
            }
        }
        {
            int len2g7Sfm = DeseriUtil.getShort(is);
            if (len2g7Sfm > 0) {
                HashMap<Integer, String[]> map53xvOD = new HashMap<Integer, String[]>();
                for (int iavTvHF = 0; iavTvHF < len2g7Sfm; iavTvHF++) {
                    Integer _kOHzN76 = DeseriUtil.getInt(is);
                    String[] _v5Qw4BB = null;
                    {
                        int lenAght9M = DeseriUtil.getShort(is);
                        if (lenAght9M > 0) {
                            String[] arrOMt4hm = new String[lenAght9M];
                            for (int iqwKUzh = 0; iqwKUzh < lenAght9M; iqwKUzh++) {
                                arrOMt4hm[iqwKUzh] = DeseriUtil.getString(is);
                            }
                            _v5Qw4BB = arrOMt4hm;
                        }
                    }
                    map53xvOD.put(_kOHzN76, _v5Qw4BB);
                }
                o.setMap4(map53xvOD);
            }
        }
        {
            int lenzbmwaO = DeseriUtil.getShort(is);
            if (lenzbmwaO > 0) {
                HashMap<Integer, boolean[]> mapHaNL1g = new HashMap<Integer, boolean[]>();
                for (int iyGfQiD = 0; iyGfQiD < lenzbmwaO; iyGfQiD++) {
                    Integer _kuk9cGt = DeseriUtil.getInt(is);
                    boolean[] _v1oNVL6 = null;
                    {
                        int lenEvgoMr = DeseriUtil.getShort(is);
                        if (lenEvgoMr > 0) {
                            boolean[] arrYWysw0 = new boolean[lenEvgoMr];
                            for (int iLtNOUL = 0; iLtNOUL < lenEvgoMr; iLtNOUL++) {
                                arrYWysw0[iLtNOUL] = DeseriUtil.getBoolean(is);
                            }
                            _v1oNVL6 = arrYWysw0;
                        }
                    }
                    mapHaNL1g.put(_kuk9cGt, _v1oNVL6);
                }
                o.setMap5(mapHaNL1g);
            }
        }

        return o;
    }
}
