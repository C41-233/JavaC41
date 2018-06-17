/*
 * This file is generated by ITEnumerator.java.template
 */
 
package c41.utility.linq.enumerator;

/**
 * 基本类型short的Enumerator。
 */
public interface IShortEnumerator extends IEnumerator<Short>{

	@Override
	public default Short next() {
		moveNext();
		return current();
	}
	
	public default short nextShort() {
		moveNext();
		return currentShort();
	}
	
	@Override
	public default Short current() {
		return currentShort();
	}
	
	public short currentShort();
	
}