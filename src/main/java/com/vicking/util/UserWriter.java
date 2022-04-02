package com.vicking.util;
import java.io.IOException;
import java.io.OutputStream;
public class UserWriter {
	public static void write(OutputStream os,User o) throws IOException {
		SeriUtil.putInt(os, o.getId());
		SeriUtil.putString(os, o.getName());
		SeriUtil.putStringCol(os, o.getList1());
		SeriUtil.putIntCol(os, o.getList2());
		PlayerWriter.write(os, o.getPlayer());
		SeriUtil.putShort(os, (short)o.getPlayers().size());
		for (com.vicking.util.Player item : o.getPlayers()) {
			com.vicking.util.PlayerWriter.write(os, item);
		}
	}
}
