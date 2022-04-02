package com.vicking.util;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
public class UserWriter {
	public static void write(OutputStream os,User o) throws IOException {
		if (o == null) {
			SeriUtil.put(os, (byte)0);
			return;
		}
		SeriUtil.put(os, (byte)1);
		SeriUtil.putInt(os, o.getId());
		SeriUtil.putString(os, o.getName());
		SeriUtil.putStringCol(os, o.getList1());
		SeriUtil.putIntCol(os, o.getList2());
		SeriUtil.putShortCol(os, o.getList3());
		SeriUtil.putLongCol(os, o.getList4());
		PlayerWriter.write(os, o.getPlayer());
		SeriUtil.putShort(os, (short)o.getPlayers().size());
		for (Player item : o.getPlayers()) {
			PlayerWriter.write(os, item);
		}
		SeriUtil.put(os, o.getB());
		SeriUtil.putShort(os, o.getS());
		SeriUtil.putFloat(os, o.getF());
		SeriUtil.putDouble(os, o.getD());
		SeriUtil.putDate(os, o.getDate());
		SeriUtil.putShort(os, (short)o.getMap1().size());
		for (Map.Entry<Integer, Integer> entry : o.getMap1().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putInt(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap2().size());
		for (Map.Entry<Integer, String> entry : o.getMap2().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putString(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap3().size());
		for (Map.Entry<Integer, Short> entry : o.getMap3().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putShort(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap4().size());
		for (Map.Entry<Integer, Byte> entry : o.getMap4().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.put(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap5().size());
		for (Map.Entry<Integer, Float> entry : o.getMap5().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putFloat(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap6().size());
		for (Map.Entry<Integer, Double> entry : o.getMap6().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putDouble(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap7().size());
		for (Map.Entry<Integer,java.util.Date> entry : o.getMap7().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putDate(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap11().size());
		for (Map.Entry<Integer, Integer> entry : o.getMap11().entrySet()) {
			SeriUtil.putInt(os, entry.getKey());
			SeriUtil.putInt(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap12().size());
		for (Map.Entry<String, String> entry : o.getMap12().entrySet()) {
			SeriUtil.putString(os, entry.getKey());
			SeriUtil.putString(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap13().size());
		for (Map.Entry<Short, Short> entry : o.getMap13().entrySet()) {
			SeriUtil.putShort(os, entry.getKey());
			SeriUtil.putShort(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap14().size());
		for (Map.Entry<Byte, Byte> entry : o.getMap14().entrySet()) {
			SeriUtil.put(os, entry.getKey());
			SeriUtil.put(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap15().size());
		for (Map.Entry<Float, Float> entry : o.getMap15().entrySet()) {
			SeriUtil.putFloat(os, entry.getKey());
			SeriUtil.putFloat(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap16().size());
		for (Map.Entry<Double, Double> entry : o.getMap16().entrySet()) {
			SeriUtil.putDouble(os, entry.getKey());
			SeriUtil.putDouble(os, entry.getValue());
		}
		SeriUtil.putShort(os, (short)o.getMap17().size());
		for (Map.Entry<java.util.Date,java.util.Date> entry : o.getMap17().entrySet()) {
			SeriUtil.putDate(os, entry.getKey());
			SeriUtil.putDate(os, entry.getValue());
		}
	}
}
