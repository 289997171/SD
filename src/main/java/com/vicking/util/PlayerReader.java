package com.vicking.util;
import java.io.IOException;
import java.io.InputStream;
public class PlayerReader {
	public static Player read(InputStream is) throws IOException {
		Player o = new Player();
		o.setId(DeseriUtil.getInt(is));
		o.setName(DeseriUtil.getString(is));
		return o;
	}
}
