/*
 * This file is generated by ITEnumerable.java.template
 */


package c41.utility.linq;

import java.util.NoSuchElementException;

import c41.lambda.predicate.*;
import c41.utility.assertion.Arguments;
import c41.utility.linq.enumerator.*;

/**
 * 基本类型byte的Enumerable。
 */
public interface IByteEnumerable extends IEnumerable<Byte>{
	
	@Override
	public IByteEnumerator iterator();
	
	/**
	 * 查询指定下标的值。
	 * @param index 下标
	 * @return 指定值
	 * @throws IllegalArgumentException index &lt; 0
	 * @throws NoSuchElementException 下标超出迭代器范围
	 */
	public default byte at(int index){
		Arguments.is(index>=0, "%d < 0", index);
		
		IByteEnumerator enumerator = iterator();
		for(int i=0; i<index; i++) {
			if(!enumerator.hasNext()) {
				throw new NoSuchElementException();
			}
			enumerator.moveNext();
		}
		if(enumerator.hasNext()) {
			return enumerator.nextByte();
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 * @see IReferenceEnumerable#isAll(IPredicate)
	 * @see ICharEnumerable#isAll(ICharPredicate)
	 */
	public default boolean isAll(IBytePredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IByteEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			byte val = enumerator.nextByte();
			if(predicate.is(val) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 存在满足谓词的元素。
	 * @param predicate 谓词
	 * @return 如果存在，则返回true
	 */
	public default boolean isExist(IBytePredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IByteEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			byte val = enumerator.nextByte();
			if(predicate.is(val)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 存在指定值。
	 * @param value 值
	 * @return 如果存在，则返回true
	 */
	public default boolean isExist(byte value) {
		IByteEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			byte val = enumerator.nextByte();
			if(val == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 非所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果非所有元素都满足谓词，返回true
	 */
	public default boolean isNotAll(IBytePredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IByteEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			byte val = enumerator.nextByte();
			if(predicate.is(val) == false) {
				return true;
			}
		}
		return false;
	}
	
	public default byte[] toArray() {
		return null;
	}
	
}