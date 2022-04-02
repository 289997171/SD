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
		return o;
	}
}
