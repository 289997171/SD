package com.vicking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class Obj3Reader {
	public static Obj3 read(InputStream is) throws IOException {
		if(is.read() == 0) return null;
		Obj3 o = new Obj3();
		o.iv3= (int)DeseriUtil.getVarInt(is, 5);
o.iv4= (int)DeseriUtil.getVarInt(is, 5);
{int lenEUuV80 = DeseriUtil.getInt(is);if (lenEUuV80 > 0) {
    ArrayList<Boolean> listA8D6Fe = new ArrayList<>();for (int imb7Vvo = 0; imb7Vvo < lenEUuV80; imb7Vvo++) {listA8D6Fe.add(DeseriUtil.getBoolean(is));}o.bs2= listA8D6Fe;}}
{int leny4gu8U = DeseriUtil.getInt(is);if (leny4gu8U > 0) {
    HashSet<Boolean> setlt21Mw = new HashSet<>();for (int iyTRMaI = 0; iyTRMaI < leny4gu8U; iyTRMaI++) {setlt21Mw.add(DeseriUtil.getBoolean(is));}o.bs4= setlt21Mw;}}
{int lenUECO87 = DeseriUtil.getInt(is);if (lenUECO87 > 0) {boolean[] arrYU3QA8 = new boolean[lenUECO87];for (int iwNzjIZ = 0; iwNzjIZ < lenUECO87; iwNzjIZ++) {arrYU3QA8[iwNzjIZ] = DeseriUtil.getBoolean(is);}o.bs6= arrYU3QA8;}}
{int lenZUzBPu = DeseriUtil.getInt(is);if (lenZUzBPu > 0) {
    ArrayList<Obj4> listGi1U2v = new ArrayList<>();for (int i7gY2YA = 0; i7gY2YA < lenZUzBPu; i7gY2YA++) {listGi1U2v.add(Obj4Reader.read(is));}o.obj42= listGi1U2v;}}
{int lenQLFS80 = DeseriUtil.getInt(is);if (lenQLFS80 > 0) {
    HashSet<Obj4> setU8jYjf = new HashSet<>();for (int ijYY1rP = 0; ijYY1rP < lenQLFS80; ijYY1rP++) {setU8jYjf.add(Obj4Reader.read(is));}o.obj44= setU8jYjf;}}
{int lenKICE8a = DeseriUtil.getInt(is);if (lenKICE8a > 0) {
    Obj4[] arrygUCmn = new Obj4[lenKICE8a];for (int i1teRjL = 0; i1teRjL < lenKICE8a; i1teRjL++) {arrygUCmn[i1teRjL] = Obj4Reader.read(is);}o.obj46= arrygUCmn;}}
{int lenBSLdxf = DeseriUtil.getInt(is);if (lenBSLdxf > 0) {
    HashMap<Integer, HashMap<Integer, HashMap<Integer, Float>>> map4uNJpm = new HashMap<Integer, HashMap<Integer, HashMap<Integer, Float>>>();for (int ipAhAL1 = 0; ipAhAL1 < lenBSLdxf; ipAhAL1++) {
        Integer _kIrQq5z = (int)DeseriUtil.getVarInt(is, 5);
        HashMap<Integer, HashMap<Integer, Float>> _vwos9gg = null;{int lenSD2Pv3 = DeseriUtil.getInt(is);if (lenSD2Pv3 > 0) {
            HashMap<Integer, HashMap<Integer, Float>> mapw2fXZ1 = new HashMap<Integer, HashMap<Integer, Float>>();for (int iKMJhmw = 0; iKMJhmw < lenSD2Pv3; iKMJhmw++) {
                Integer _kg9HMtA = (int)DeseriUtil.getVarInt(is, 5);
                HashMap<Integer, Float> _vQLcXwm = null;{int len87LpGX = DeseriUtil.getInt(is);if (len87LpGX > 0) {
                    HashMap<Integer, Float> mapFK7ERZ = new HashMap<Integer, Float>();for (int iC2vfYW = 0; iC2vfYW < len87LpGX; iC2vfYW++) {mapFK7ERZ.put((int)DeseriUtil.getVarInt(is, 5),DeseriUtil.getFloat(is));}_vQLcXwm = mapFK7ERZ;}}mapw2fXZ1.put(_kg9HMtA,_vQLcXwm);}_vwos9gg = mapw2fXZ1;}}map4uNJpm.put(_kIrQq5z,_vwos9gg);}o.map6= map4uNJpm;}}
o.setIv((int)DeseriUtil.getVarInt(is, 5));
o.setIv2((int)DeseriUtil.getVarInt(is, 5));
{int lenccmexO = DeseriUtil.getInt(is);if (lenccmexO > 0) {
    ArrayList<Boolean> listQg08jd = new ArrayList<>();for (int iGFpEZv = 0; iGFpEZv < lenccmexO; iGFpEZv++) {listQg08jd.add(DeseriUtil.getBoolean(is));}o.setBs1(listQg08jd);}}
{int lenvolLU5 = DeseriUtil.getInt(is);if (lenvolLU5 > 0) {
    HashSet<Boolean> set2xaByF = new HashSet<>();for (int io4aw59 = 0; io4aw59 < lenvolLU5; io4aw59++) {set2xaByF.add(DeseriUtil.getBoolean(is));}o.setBs3(set2xaByF);}}
{int lendY0smw = DeseriUtil.getInt(is);if (lendY0smw > 0) {boolean[] arrqsR7bq = new boolean[lendY0smw];for (int igCJ5mZ = 0; igCJ5mZ < lendY0smw; igCJ5mZ++) {arrqsR7bq[igCJ5mZ] = DeseriUtil.getBoolean(is);}o.setBs5(arrqsR7bq);}}
o.setObj4(Obj4Reader.read(is));
{int lenjJg6pQ = DeseriUtil.getInt(is);if (lenjJg6pQ > 0) {
    ArrayList<Obj4> list4QRpq6 = new ArrayList<>();for (int iAxY2Y8 = 0; iAxY2Y8 < lenjJg6pQ; iAxY2Y8++) {list4QRpq6.add(Obj4Reader.read(is));}o.setObj41(list4QRpq6);}}
{int len9I0ka6 = DeseriUtil.getInt(is);if (len9I0ka6 > 0) {
    HashSet<Obj4> seteSTkyQ = new HashSet<>();for (int iRUQPfV = 0; iRUQPfV < len9I0ka6; iRUQPfV++) {seteSTkyQ.add(Obj4Reader.read(is));}o.setObj43(seteSTkyQ);}}
{int len3wsmH7 = DeseriUtil.getInt(is);if (len3wsmH7 > 0) {
    Obj4[] arr3XGFGI = new Obj4[len3wsmH7];for (int iAtemtQ = 0; iAtemtQ < len3wsmH7; iAtemtQ++) {arr3XGFGI[iAtemtQ] = Obj4Reader.read(is);}o.setObj45(arr3XGFGI);}}
{int lendvr7Y1 = DeseriUtil.getInt(is);if (lendvr7Y1 > 0) {
    HashMap<Integer, String> mapoKvNsT = new HashMap<Integer, String>();for (int i1rafqE = 0; i1rafqE < lendvr7Y1; i1rafqE++) {mapoKvNsT.put((int)DeseriUtil.getVarInt(is, 5),DeseriUtil.getString(is));}o.setMap1(mapoKvNsT);}}
{int lenwMzdeX = DeseriUtil.getInt(is);if (lenwMzdeX > 0) {
    HashMap<Integer, ArrayList<String>> map6fmlR2 = new HashMap<Integer, ArrayList<String>>();for (int i9J6zV0 = 0; i9J6zV0 < lenwMzdeX; i9J6zV0++) {
        Integer _kx3IMPv = (int)DeseriUtil.getVarInt(is, 5);
        ArrayList<String> _vXsQVu4 = null;{int len4ihcWo = DeseriUtil.getInt(is);if (len4ihcWo > 0) {
            ArrayList<String> listuKKlP6 = new ArrayList<>();for (int iBoasdb = 0; iBoasdb < len4ihcWo; iBoasdb++) {listuKKlP6.add(DeseriUtil.getString(is));}_vXsQVu4 = listuKKlP6;}}map6fmlR2.put(_kx3IMPv,_vXsQVu4);}o.setMap2(map6fmlR2);}}
{int lenCTfnvV = DeseriUtil.getInt(is);if (lenCTfnvV > 0) {
    HashMap<Integer, HashSet<String>> map5UUdYd = new HashMap<Integer, HashSet<String>>();for (int izrmEJR = 0; izrmEJR < lenCTfnvV; izrmEJR++) {
        Integer _ktW3NNd = (int)DeseriUtil.getVarInt(is, 5);
        HashSet<String> _vjRII4F = null;{int len2bXBgS = DeseriUtil.getInt(is);if (len2bXBgS > 0) {
            HashSet<String> setu52iks = new HashSet<>();for (int ixajMMZ = 0; ixajMMZ < len2bXBgS; ixajMMZ++) {setu52iks.add(DeseriUtil.getString(is));}_vjRII4F = setu52iks;}}map5UUdYd.put(_ktW3NNd,_vjRII4F);}o.setMap3(map5UUdYd);}}
{int lenghowSM = DeseriUtil.getInt(is);if (lenghowSM > 0) {
    HashMap<Integer, String[]> mapLm6nhf = new HashMap<Integer, String[]>();for (int iXuwBNb = 0; iXuwBNb < lenghowSM; iXuwBNb++) {
        Integer _kS9SdEb = (int)DeseriUtil.getVarInt(is, 5);
        String[] _v5hfKyh = null;{int lenH24mjg = DeseriUtil.getInt(is);if (lenH24mjg > 0) {
            String[] arrxNlT4P = new String[lenH24mjg];for (int iNgOIgr = 0; iNgOIgr < lenH24mjg; iNgOIgr++) {arrxNlT4P[iNgOIgr] = DeseriUtil.getString(is);}_v5hfKyh = arrxNlT4P;}}mapLm6nhf.put(_kS9SdEb,_v5hfKyh);}o.setMap4(mapLm6nhf);}}
{int lencbp8eE = DeseriUtil.getInt(is);if (lencbp8eE > 0) {
    HashMap<Integer, boolean[]> mapRLTLYu = new HashMap<Integer, boolean[]>();for (int idiTHU1 = 0; idiTHU1 < lencbp8eE; idiTHU1++) {
        Integer _kCspdHn = (int)DeseriUtil.getVarInt(is, 5);boolean[] _vcTDSvs = null;{int len2W9gyC = DeseriUtil.getInt(is);if (len2W9gyC > 0) {boolean[] arrUaAK1p = new boolean[len2W9gyC];for (int iZ2DIFw = 0; iZ2DIFw < len2W9gyC; iZ2DIFw++) {arrUaAK1p[iZ2DIFw] = DeseriUtil.getBoolean(is);}_vcTDSvs = arrUaAK1p;}}mapRLTLYu.put(_kCspdHn,_vcTDSvs);}o.setMap5(mapRLTLYu);}}

		return o;
	}
}
