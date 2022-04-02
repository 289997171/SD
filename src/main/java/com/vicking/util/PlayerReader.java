package com.vicking.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
public class PlayerReader {
	public static Player read(InputStream is) throws IOException {
		if(DeseriUtil.get(is) == 0) return null;
		Player o = new Player();
		o.setId(DeseriUtil.getInt(is));
		o.setName(DeseriUtil.getString(is));
		return o;
	}
}