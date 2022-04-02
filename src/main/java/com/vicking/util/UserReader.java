package com.vicking.util;
import java.io.IOException;
import java.io.InputStream;
public class UserReader {
	public static User read(InputStream is) throws IOException {
		if(DeseriUtil.getShort(is) == 0) return null;
		User o = new User();
		o.setId(DeseriUtil.getInt(is));
		o.setName(DeseriUtil.getString(is));
		o.getList1().addAll(DeseriUtil.getStringCol(is));
		o.getList2().addAll(DeseriUtil.getIntCol(is));
		o.setPlayer(PlayerReader.read(is));
		for (int i = 0; i < DeseriUtil.getShort(is); i++) {
			o.getPlayers().add(PlayerReader.read(is));
		}
		return o;
	}
}
