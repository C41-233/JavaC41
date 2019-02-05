/*
 * This file is generated by ITEnumerator.java.template
 */
 
package c41.utility.linq.enumerator;

/**
 * 基本类型int的Enumerator。
 */
public interface IIntEnumerator extends IEnumerator<Integer>{

	@Override
	public default Integer next() {
		return nextInt();
	}
	
	public int nextInt();
	
}