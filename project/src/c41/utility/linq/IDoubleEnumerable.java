
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
 * 基本类型double的Enumerable。
 */
public interface IDoubleEnumerable extends IEnumerable<Double>{
	
	@Override
	public IDoubleEnumerator iterator();
	
	/**
	 * 查询指定下标的值。
	 * @param index 下标
	 * @return 指定值
	 * @throws IllegalArgumentException index &lt; 0
	 * @throws NoSuchElementException 下标超出迭代器范围
	 */
	public default double at(int index){
		Arguments.is(index>=0, "%d < 0", index);
		
		IDoubleEnumerator enumerator = iterator();
		for(int i=0; i<index; i++) {
			if(!enumerator.hasNext()) {
				throw new NoSuchElementException();
			}
			enumerator.moveNext();
		}
		if(enumerator.hasNext()) {
			return enumerator.nextDouble();
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 返回满足条件的元素数量。
	 * @param predicate 谓词
	 * @return 数量
	 */
	public default int countIf(IDoublePredicate predicate){
		Arguments.isNotNull(predicate);
		
		int count = 0;
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			enumerator.nextDouble();
			count++;
		}
		return count;
	}
	
	/**
	 * 获取第一个元素。
	 * @return 第一个元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default double first(){
		IDoubleEnumerator enumerator = iterator();
		return enumerator.next();
	}
	
	/**
	 * 获取第一个重复元素。
	 * @return 第一个重复元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default double firstDuplicate(){
		DoubleHashSet set = new DoubleHashSet();
		
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			double value = enumerator.nextDouble();
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
	public default double firstDuplicateOrDefault(){
		return firstDuplicateOrDefault(0.0);
	}
	
	/**
	 * 返回第一个重复元素。如果不存在，则返回默认值。
	 * @param def 默认值
	 * @return 第一个重复元素或默认值。
	 */
	public default double firstDuplicateOrDefault(double def){
		DoubleHashSet set = new DoubleHashSet();
		
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			double value = enumerator.nextDouble();
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
	public default double firstIf(IDoublePredicate predicate){
		Arguments.isNotNull(predicate);
		
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			double value = enumerator.nextDouble();
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
	public default int firstIndexIf(IDoublePredicate predicate){
		Arguments.isNotNull(predicate);
		
		IDoubleEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			double value = enumerator.nextDouble();
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
	public default int firstIndexOf(double value){
		IDoubleEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			double val = enumerator.nextDouble();
			if(val == value){
				return index;
			}
			++index;
		}
		return -1;
	}
	
	/**
	 * 返回元素value的下标。如果不存在，则返回-1。
	 * @param value 目标元素
	 * @param epsilon 误差
	 * @return 下标
	 */
	public default int firstIndexOf(double value, double epsilon){
		Arguments.is(epsilon >= 0, "epsilon < 0");
	
		IDoubleEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			double val = enumerator.nextDouble();
			if(Maths.equals(val, value, epsilon)){
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
	public default boolean isAll(IDoublePredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			double val = enumerator.nextDouble();
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
	public default boolean isExist(IDoublePredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			double val = enumerator.nextDouble();
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
	public default boolean isExist(double value) {
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			double val = enumerator.nextDouble();
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
	public default boolean isNotAll(IDoublePredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IDoubleEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			double val = enumerator.nextDouble();
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
	public default double[] toArray() {
		DoubleArrayList list = new DoubleArrayList(this);
		return list.toArray();
	}
	
}