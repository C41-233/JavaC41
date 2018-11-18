package c41.utility.string;

import java.nio.charset.Charset;

public final class Charsets {

	private Charsets() {}
	
	public static final class UTF_8{
		public static final Charset Instance = Charset.forName("utf-8");
	}
	

	public static final class GBK{
		public static final Charset Instance = Charset.forName("gbk");
	}
	
	
}
