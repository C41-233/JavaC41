
/*
 * This file is generated by ITEnumerable.java.template
 */
 
package c41.utility.linq;

import java.util.NoSuchElementException;

import c41.lambda.predicate.*;
import c41.core.assertion.Arguments;
import c41.utility.algorithm.Maths;
import c41.utility.linq.enumerator.*;
import c41.utility.collection.list.*;
import c41.utility.collection.set.*;

/**
 * 基本类型int的Enumerable。
 */
public interface IIntEnumerable extends IEnumerable<Integer>{
	
	@Override
	public IIntEnumerator iterator();
	
	/**
	 * 查询指定下标的值。
	 * @param index 下标
	 * @return 指定值
	 * @throws IllegalArgumentException index &lt; 0
	 * @throws NoSuchElementException 下标超出迭代器范围
	 */
	public default int at(int index){
		Arguments.is(index>=0, "%d < 0", index);
		
		IIntEnumerator enumerator = iterator();
		for(int i=0; i<index; i++) {
			if(!enumerator.hasNext()) {
				throw new NoSuchElementException();
			}
			enumerator.moveNext();
		}
		if(enumerator.hasNext()) {
			return enumerator.nextInt();
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 返回满足条件的元素数量。
	 * @param predicate 谓词
	 * @return 数量
	 */
	public default int countIf(IIntPredicate predicate){
		Arguments.isNotNull(predicate);
		
		int count = 0;
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			enumerator.nextInt();
			count++;
		}
		return count;
	}
	
	/**
	 * 获取第一个元素。
	 * @return 第一个元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default int first(){
		IIntEnumerator enumerator = iterator();
		return enumerator.next();
	}
	
	/**
	 * 获取第一个重复元素。
	 * @return 第一个重复元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default int firstDuplicate(){
		IntHashSet set = new IntHashSet();
		
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			int value = enumerator.nextInt();
			if(!set.add(value)){
				return value;
			}
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 返回第一个重复元素。如果不存在，则返回0。
	 * @return 第一个重复元素或0。
	 */
	public default int firstDuplicateOrDefault(){
		return firstDuplicateOrDefault(0);
	}
	
	/**
	 * 返回第一个重复元素。如果不存在，则返回默认值。
	 * @param def 默认值
	 * @return 第一个重复元素或默认值。
	 */
	public default int firstDuplicateOrDefault(int def){
		IntHashSet set = new IntHashSet();
		
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			int value = enumerator.nextInt();
			if(!set.add(value)){
				return value;
			}
		}
		return def;
	}
	
	/**
	 * 返回第一个满足条件的元素。
	 * @param predicate 谓词
	 * @return 第一个满足的元素
	 * @exception NoSuchElementException 没有满足条件的元素
	 */
	public default int firstIf(IIntPredicate predicate){
		Arguments.isNotNull(predicate);
		
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			int value = enumerator.nextInt();
			if(predicate.is(value)){
				return value;
			}
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 返回第一个满足条件的下标。如果不存在，则返回-1。
	 * @param predicate 谓词
	 * @return 下标。
	 */
	public default int firstIndexIf(IIntPredicate predicate){
		Arguments.isNotNull(predicate);
		
		IIntEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			int value = enumerator.nextInt();
			if(predicate.is(value)){
				return index;
			}
			++index;
		}
		return -1;
	}
	
	/**
	 * 返回元素value的下标。如果不存在，则返回-1。
	 * @param value 目标元素
	 * @return 下标
	 */
	public default int firstIndexOf(int value){
		IIntEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			int val = enumerator.nextInt();
			if(val == value){
				return index;
			}
			++index;
		}
		return -1;
	}
	
	
	/**
	 * 所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 * @see IReferenceEnumerable#isAll(IPredicate)
	 * @see ICharEnumerable#isAll(ICharPredicate)
	 */
	public default boolean isAll(IIntPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			int val = enumerator.nextInt();
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
	public default boolean isExist(IIntPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			int val = enumerator.nextInt();
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
	public default boolean isExist(int value) {
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			int val = enumerator.nextInt();
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
	public default boolean isNotAll(IIntPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IIntEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			int val = enumerator.nextInt();
			if(predicate.is(val) == false) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 返回所有元素组成的数组。
	 * 如果没有元素，则返回空数组。
	 * @return 数组
	 */
	public default int[] toArray() {
		IntArrayList list = new IntArrayList(this);
		return list.toArray();
	}
	
}