package com.vicking.util;
import java.io.IOException;
import java.io.OutputStream;
public class PlayerWriter {
	public static void write(OutputStream os,Player o) throws IOException {
		if (o == null) {
			SeriUtil.put(os, (byte)0);
			return;
		}
		SeriUtil.put(os, (byte)1);
		SeriUtil.putInt(os, o.getId());
		SeriUtil.putString(os, o.getName());
	}
}