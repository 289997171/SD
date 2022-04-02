package com.vicking.util;
import java.io.IOException;
import java.io.OutputStream;
public class PlayerWriter {
	public static void write(OutputStream os,Player o) throws IOException {
		SeriUtil.putInt(os, o.getId());
		SeriUtil.putString(os, o.getName());
	}
}
