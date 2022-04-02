package com.vicking.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
public class UserReader {
	public static User read(InputStream is) throws IOException {
		if(DeseriUtil.get(is) == 0) return null;
		User o = new User();
		o.setId(DeseriUtil.getInt(is));
		o.setName(DeseriUtil.getString(is));
		Collection<String> list1 = DeseriUtil.getStringCol(is);
		if(list1 != null) o.getList1().addAll(list1);
		Collection<Integer> list2 = DeseriUtil.getIntCol(is);
		if(list2 != null) o.getList2().addAll(list2);
		Collection<Short> list3 = DeseriUtil.getShortCol(is);
		if(list3 != null) o.getList3().addAll(list3);
		Collection<Long> list4 = DeseriUtil.getLongCol(is);
		if(list4 != null) o.getList4().addAll(list4);
		o.setPlayer(PlayerReader.read(is));
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getPlayers().add(PlayerReader.read(is));
		}}
		o.setB((byte)DeseriUtil.get(is));
		o.setS(DeseriUtil.getShort(is));
		o.setF(DeseriUtil.getFloat(is));
		o.setD(DeseriUtil.getDouble(is));
		o.setDate(DeseriUtil.getDate(is));
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap1().put(DeseriUtil.getInt(is),DeseriUtil.getInt(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap2().put(DeseriUtil.getInt(is),DeseriUtil.getString(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap3().put(DeseriUtil.getInt(is),DeseriUtil.getShort(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap4().put(DeseriUtil.getInt(is),(byte)DeseriUtil.get(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap5().put(DeseriUtil.getInt(is),DeseriUtil.getFloat(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap6().put(DeseriUtil.getInt(is),DeseriUtil.getDouble(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap7().put(DeseriUtil.getInt(is),DeseriUtil.getDate(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap11().put(DeseriUtil.getInt(is),DeseriUtil.getInt(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap12().put(DeseriUtil.getString(is),DeseriUtil.getString(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap13().put(DeseriUtil.getShort(is),DeseriUtil.getShort(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap14().put((byte)DeseriUtil.get(is),(byte)DeseriUtil.get(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap15().put(DeseriUtil.getFloat(is),DeseriUtil.getFloat(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap16().put(DeseriUtil.getDouble(is),DeseriUtil.getDouble(is));
		}}
		{short size = DeseriUtil.getShort(is);
		for (int i = 0; i < size; i++) {
			o.getMap17().put(DeseriUtil.getDate(is),DeseriUtil.getDate(is));
		}}
		return o;
	}
}
