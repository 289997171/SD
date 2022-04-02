package com.vicking.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class UserReader {
	public static User read(InputStream is) throws IOException {
		if(DeseriUtil.getShort(is) == 0) return null;
		User o = new User();
		o.setId(DeseriUtil.getInt(is));
		o.setName(DeseriUtil.getString(is));
		Collection<String> list1 = DeseriUtil.getStringCol(is);
		if(list1 != null) o.getList1().addAll(list1);
		Collection<Integer> list2 = DeseriUtil.getIntCol(is);
		if(list2 != null) o.getList2().addAll(list2);
		o.setPlayer(PlayerReader.read(is));
		for (int i = 0; i < DeseriUtil.getShort(is); i++) {
			o.getPlayers().add(PlayerReader.read(is));
		}
		return o;
	}
}
