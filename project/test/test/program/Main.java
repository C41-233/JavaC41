package test.program;

import java.nio.charset.Charset;

import c41.utility.string.Charsets;

public class Main {

	public static void main(String[] args) {
		for(String c : Charset.availableCharsets().keySet()) {
			System.out.println(c);
		}
	}

}
