package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Obj3Writer {
    public static void write(OutputStream os, Obj3 o) throws IOException {
        if (o == null) {
            os.write(0);
            return;
        }
        os.write(1);
        SeriUtil.putInt(os, o.iv3);
        SeriUtil.putInt(os, o.iv4);
        if (o.bs2 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.bs2.size());
            for (Boolean itemL6ufvY : o.bs2) {
                SeriUtil.putBoolean(os, itemL6ufvY);
            }
        }
        if (o.bs4 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.bs4.size());
            for (Boolean itemglR4hF : o.bs4) {
                SeriUtil.putBoolean(os, itemglR4hF);
            }
        }
        if (o.bs6 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.bs6.length);
            for (boolean itemPrXpDL : o.bs6) {
                SeriUtil.putBoolean(os, itemPrXpDL);
            }
        }
        if (o.obj42 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.obj42.size());
            for (Obj4 itemjGRi6h : o.obj42) {
                Obj4Writer.write(os, itemjGRi6h);
            }
        }
        if (o.obj44 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.obj44.size());
            for (Obj4 itemPTPoSE : o.obj44) {
                Obj4Writer.write(os, itemPTPoSE);
            }
        }
        if (o.obj46 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.obj46.length);
            for (Obj4 itemLO3nat : o.obj46) {
                Obj4Writer.write(os, itemLO3nat);
            }
        }
        if (o.map6 == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.map6.size());
            for (Map.Entry<Integer, HashMap<Integer, HashMap<Integer, Float>>> entryPiJPes : o.map6.entrySet()) {
                SeriUtil.putInt(os, entryPiJPes.getKey());
                if (entryPiJPes.getValue() == null) {
                    SeriUtil.putShort(os, 0);
                } else {
                    SeriUtil.putShort(os, (short) entryPiJPes.getValue().size());
                    for (Map.Entry<Integer, HashMap<Integer, Float>> entryTXjyVH : entryPiJPes.getValue().entrySet()) {
                        SeriUtil.putInt(os, entryTXjyVH.getKey());
                        if (entryTXjyVH.getValue() == null) {
                            SeriUtil.putShort(os, 0);
                        } else {
                            SeriUtil.putShort(os, (short) entryTXjyVH.getValue().size());
                            for (Map.Entry<Integer, Float> entryTWYOFu : entryTXjyVH.getValue().entrySet()) {
                                SeriUtil.putInt(os, entryTWYOFu.getKey());
                                SeriUtil.putFloat(os, entryTWYOFu.getValue());
                            }
                        }
                    }
                }
            }
        }
        SeriUtil.putInt(os, o.getIv());
        SeriUtil.putInt(os, o.getIv2());
        if (o.getBs1() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getBs1().size());
            for (Boolean itemNbp3H1 : o.getBs1()) {
                SeriUtil.putBoolean(os, itemNbp3H1);
            }
        }
        if (o.getBs3() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getBs3().size());
            for (Boolean itemJJQkIL : o.getBs3()) {
                SeriUtil.putBoolean(os, itemJJQkIL);
            }
        }
        if (o.getBs5() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getBs5().length);
            for (boolean itemcFdTCM : o.getBs5()) {
                SeriUtil.putBoolean(os, itemcFdTCM);
            }
        }
        Obj4Writer.write(os, o.getObj4());
        if (o.getObj41() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getObj41().size());
            for (Obj4 itemVcJ4Is : o.getObj41()) {
                Obj4Writer.write(os, itemVcJ4Is);
            }
        }
        if (o.getObj43() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getObj43().size());
            for (Obj4 item9NyyzT : o.getObj43()) {
                Obj4Writer.write(os, item9NyyzT);
            }
        }
        if (o.getObj45() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getObj45().length);
            for (Obj4 itemnIzHOy : o.getObj45()) {
                Obj4Writer.write(os, itemnIzHOy);
            }
        }
        if (o.getMap1() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getMap1().size());
            for (Map.Entry<Integer, String> entry59wLwy : o.getMap1().entrySet()) {
                SeriUtil.putInt(os, entry59wLwy.getKey());
                SeriUtil.putString(os, entry59wLwy.getValue());
            }
        }
        if (o.getMap2() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getMap2().size());
            for (Map.Entry<Integer, ArrayList<String>> entryyjV2rW : o.getMap2().entrySet()) {
                SeriUtil.putInt(os, entryyjV2rW.getKey());
                if (entryyjV2rW.getValue() == null) {
                    SeriUtil.putShort(os, 0);
                } else {
                    SeriUtil.putShort(os, (short) entryyjV2rW.getValue().size());
                    for (String itemEviJf8 : entryyjV2rW.getValue()) {
                        SeriUtil.putString(os, itemEviJf8);
                    }
                }
            }
        }
        if (o.getMap3() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getMap3().size());
            for (Map.Entry<Integer, HashSet<String>> entry5qKA2B : o.getMap3().entrySet()) {
                SeriUtil.putInt(os, entry5qKA2B.getKey());
                if (entry5qKA2B.getValue() == null) {
                    SeriUtil.putShort(os, 0);
                } else {
                    SeriUtil.putShort(os, (short) entry5qKA2B.getValue().size());
                    for (String itemZKZL1L : entry5qKA2B.getValue()) {
                        SeriUtil.putString(os, itemZKZL1L);
                    }
                }
            }
        }
        if (o.getMap4() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getMap4().size());
            for (Map.Entry<Integer, String[]> entryOMTD2Z : o.getMap4().entrySet()) {
                SeriUtil.putInt(os, entryOMTD2Z.getKey());
                if (entryOMTD2Z.getValue() == null) {
                    SeriUtil.putShort(os, 0);
                } else {
                    SeriUtil.putShort(os, (short) entryOMTD2Z.getValue().length);
                    for (String item4IzxwO : entryOMTD2Z.getValue()) {
                        SeriUtil.putString(os, item4IzxwO);
                    }
                }
            }
        }
        if (o.getMap5() == null) {
            SeriUtil.putShort(os, 0);
        } else {
            SeriUtil.putShort(os, (short) o.getMap5().size());
            for (Map.Entry<Integer, boolean[]> entryQPgVZ1 : o.getMap5().entrySet()) {
                SeriUtil.putInt(os, entryQPgVZ1.getKey());
                if (entryQPgVZ1.getValue() == null) {
                    SeriUtil.putShort(os, 0);
                } else {
                    SeriUtil.putShort(os, (short) entryQPgVZ1.getValue().length);
                    for (boolean itembyFkBP : entryQPgVZ1.getValue()) {
                        SeriUtil.putBoolean(os, itembyFkBP);
                    }
                }
            }
        }

    }
}
