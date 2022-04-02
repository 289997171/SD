package com.vicking.util;
import java.io.IOException;
import java.io.OutputStream;
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
	}
}
