/*
 * This file is generated by ITEnumerator.java.template
 */
 
package c41.utility.linq.enumerator;

/**
 * 基本类型long的Enumerator。
 */
public interface ILongEnumerator extends IEnumerator<Long>{

	@Override
	public default Long next() {
		moveNext();
		return current();
	}
	
	public default long nextLong() {
		moveNext();
		return currentLong();
	}
	
	@Override
	public default Long current() {
		return currentLong();
	}
	
	public long currentLong();
	
}
