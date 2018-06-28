package c41.utility.string;

import c41.reflect.StaticClassException;

public final class Chars {

	private Chars() {
		throw new StaticClassException();
	}
	
	/**
	 * 判断是否是ASCII字符。
	 * @param ch 字符
	 * @return 结果
	 */
	public static boolean isAscii(int ch) {
		return ch <= 256;
	}

	/**
	 * 判断是否是基本拉丁数字。
	 * @param ch 字符
	 * @return 结果
	 */
	public static boolean isBasicLatinDigit(int ch) {
		return ch >= '0' && ch <= '9';
	}

	/**
	 * 判断是否是CJK统一表意字符。
	 * @param ch 字符
	 * @return 结果
	 */
	public static boolean isCJKUnifiedIdeograph(int ch) {
		return ch >= 0x4E00 && ch <= 0x9FCC;
	}

	/**
	 * 判断是否是平假名。
	 * @param ch 字符
	 * @return 结果
	 */
	public static boolean isHiragana(int ch) {
		return ch >= 0x3040 && ch <= 0x309F;
	}

	/**
	 * 判断是否是片假名及片假名扩展。
	 * @param ch 字符
	 * @return 结果
	 */
	public static boolean isKatakana(int ch) {
		return ch >= 0x30A0 && ch <= 0x30FF || ch >= 0x31F0 && ch <= 0x31FF; 
	}
	
	
}
