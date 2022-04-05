package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class Obj3Writer {
	public static void write(OutputStream os,Obj3 o) throws IOException {
		if (o == null) {
			os.write(0);
			return;
		}
		os.write(1);
		SeriUtil.putVarInt(os, o.iv3);
SeriUtil.putVarInt(os, o.iv4);
if (o.bs2 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.bs2.size());for (Boolean itemJc8K4F : o.bs2) {SeriUtil.putBoolean(os, itemJc8K4F);}}
if (o.bs4 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.bs4.size());for (Boolean itemHUnj2S : o.bs4) {SeriUtil.putBoolean(os, itemHUnj2S);}}
if (o.bs6 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.bs6.length);for (boolean itemWMfnIJ : o.bs6) {SeriUtil.putBoolean(os, itemWMfnIJ);}}
if (o.obj42 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.obj42.size());for (Obj4 itemXxpjG2 : o.obj42) {
    Obj4Writer.write(os, itemXxpjG2);}}
if (o.obj44 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.obj44.size());for (Obj4 itemGxGPFV : o.obj44) {
    Obj4Writer.write(os, itemGxGPFV);}}
if (o.obj46 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.obj46.length);for (Obj4 item3uRuFW : o.obj46) {
    Obj4Writer.write(os, item3uRuFW);}}
if (o.map6 == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.map6.size());for (Map.Entry<Integer, HashMap<Integer, HashMap<Integer, Float>>> entry2Z4MZU : o.map6.entrySet()) {SeriUtil.putVarInt(os, entry2Z4MZU.getKey());if (entry2Z4MZU.getValue() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, entry2Z4MZU.getValue().size());for (Map.Entry<Integer, HashMap<Integer, Float>> entryF9T1uV : entry2Z4MZU.getValue().entrySet()) {SeriUtil.putVarInt(os, entryF9T1uV.getKey());if (entryF9T1uV.getValue() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, entryF9T1uV.getValue().size());for (Map.Entry<Integer, Float> entry3YGyAo : entryF9T1uV.getValue().entrySet()) {SeriUtil.putVarInt(os, entry3YGyAo.getKey());SeriUtil.putFloat(os, entry3YGyAo.getValue());}}}}}}
SeriUtil.putVarInt(os, o.getIv());
SeriUtil.putVarInt(os, o.getIv2());
if (o.getBs1() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getBs1().size());for (Boolean itemqmKPtP : o.getBs1()) {SeriUtil.putBoolean(os, itemqmKPtP);}}
if (o.getBs3() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getBs3().size());for (Boolean itemslI7kD : o.getBs3()) {SeriUtil.putBoolean(os, itemslI7kD);}}
if (o.getBs5() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getBs5().length);for (boolean itemxFKRPL : o.getBs5()) {SeriUtil.putBoolean(os, itemxFKRPL);}}
Obj4Writer.write(os, o.getObj4());
if (o.getObj41() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getObj41().size());for (Obj4 itemIsr3gQ : o.getObj41()) {
    Obj4Writer.write(os, itemIsr3gQ);}}
if (o.getObj43() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getObj43().size());for (Obj4 itemZXJz15 : o.getObj43()) {
    Obj4Writer.write(os, itemZXJz15);}}
if (o.getObj45() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getObj45().length);for (Obj4 itemFL1r9E : o.getObj45()) {
    Obj4Writer.write(os, itemFL1r9E);}}
if (o.getMap1() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getMap1().size());for (Map.Entry<Integer, String> entryWRDku9 : o.getMap1().entrySet()) {SeriUtil.putVarInt(os, entryWRDku9.getKey());SeriUtil.putString(os, entryWRDku9.getValue());}}
if (o.getMap2() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getMap2().size());for (Map.Entry<Integer, ArrayList<String>> entryBJ8BNn : o.getMap2().entrySet()) {SeriUtil.putVarInt(os, entryBJ8BNn.getKey());if (entryBJ8BNn.getValue() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, entryBJ8BNn.getValue().size());for (String item72OOBl : entryBJ8BNn.getValue()) {SeriUtil.putString(os, item72OOBl);}}}}
if (o.getMap3() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getMap3().size());for (Map.Entry<Integer, HashSet<String>> entryPzZFjQ : o.getMap3().entrySet()) {SeriUtil.putVarInt(os, entryPzZFjQ.getKey());if (entryPzZFjQ.getValue() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, entryPzZFjQ.getValue().size());for (String itemK0vWDl : entryPzZFjQ.getValue()) {SeriUtil.putString(os, itemK0vWDl);}}}}
if (o.getMap4() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getMap4().size());for (Map.Entry<Integer, String[]> entryBdKJzI : o.getMap4().entrySet()) {SeriUtil.putVarInt(os, entryBdKJzI.getKey());if (entryBdKJzI.getValue() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, entryBdKJzI.getValue().length);for (String itemm6c6V6 : entryBdKJzI.getValue()) {SeriUtil.putString(os, itemm6c6V6);}}}}
if (o.getMap5() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, o.getMap5().size());for (Map.Entry<Integer,boolean[]> entryrUPHuI : o.getMap5().entrySet()) {SeriUtil.putVarInt(os, entryrUPHuI.getKey());if (entryrUPHuI.getValue() == null) {SeriUtil.putVarInt(os, 0);} else {SeriUtil.putVarInt(os, entryrUPHuI.getValue().length);for (boolean itemZVIhca : entryrUPHuI.getValue()) {SeriUtil.putBoolean(os, itemZVIhca);}}}}

	}
}
