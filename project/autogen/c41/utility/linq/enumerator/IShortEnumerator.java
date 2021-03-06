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
		return nextShort();
	}
	
	public short nextShort();
	
}
