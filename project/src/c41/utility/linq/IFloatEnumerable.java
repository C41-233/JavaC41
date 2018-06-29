
/*
 * This file is generated by ITEnumerable.java.template
 */
 
package c41.utility.linq;

import java.util.NoSuchElementException;

import c41.lambda.action.*;
import c41.lambda.predicate.*;
import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.*;
import c41.utility.collection.list.*;
import c41.utility.collection.set.*;

import c41.utility.algorithm.Maths;

/**
 * 基本类型float的Enumerable。
 */
public interface IFloatEnumerable extends IEnumerable<Float>{
	
	@Override
	public IFloatEnumerator iterator();
	
	/**
	 * 查询指定下标的值。
	 * @param index 下标
	 * @return 指定值
	 * @throws IllegalArgumentException index &lt; 0
	 * @throws NoSuchElementException 下标超出迭代器范围
	 */
	public default float at(int index){
		Arguments.is(index>=0, "%d < 0", index);
		
		IFloatEnumerator enumerator = iterator();
		for(int i=0; i<index; i++) {
			if(!enumerator.hasNext()) {
				throw new NoSuchElementException();
			}
			enumerator.moveNext();
		}
		if(enumerator.hasNext()) {
			return enumerator.nextFloat();
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 返回满足条件的元素数量。
	 * @param predicate 谓词
	 * @return 数量
	 */
	public default int countIf(IFloatPredicate predicate){
		Arguments.isNotNull(predicate);
		
		int count = 0;
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			enumerator.nextFloat();
			count++;
		}
		return count;
	}
	
	/**
	 * 获取第一个元素。
	 * @return 第一个元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default float first(){
		IFloatEnumerator enumerator = iterator();
		return enumerator.next();
	}
	
	/**
	 * 获取第一个重复元素。
	 * @return 第一个重复元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default float firstDuplicate(){
		FloatHashSet set = new FloatHashSet();
		
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			float value = enumerator.nextFloat();
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
	public default float firstDuplicateOrDefault(){
		return firstDuplicateOrDefault(0.0F);
	}
	
	/**
	 * 返回第一个重复元素。如果不存在，则返回默认值。
	 * @param def 默认值
	 * @return 第一个重复元素或默认值。
	 */
	public default float firstDuplicateOrDefault(float def){
		FloatHashSet set = new FloatHashSet();
		
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			float value = enumerator.nextFloat();
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
	public default float firstIf(IFloatPredicate predicate){
		Arguments.isNotNull(predicate);
		
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			float value = enumerator.nextFloat();
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
	public default int firstIndexIf(IFloatPredicate predicate){
		Arguments.isNotNull(predicate);
		
		IFloatEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			float value = enumerator.nextFloat();
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
	public default int firstIndexOf(float value){
		IFloatEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			float val = enumerator.nextFloat();
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
	public default int firstIndexOf(float value, float epsilon){
		Arguments.is(epsilon >= 0, "epsilon < 0");
	
		IFloatEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			float val = enumerator.nextFloat();
			if(Maths.equals(val, value, epsilon)){
				return index;
			}
			++index;
		}
		return -1;
	}
	
	/**
	 * 返回第一个满足条件的元素。如果不存在，则返回0。
	 * @param predicate 谓词
	 * @return 第一个满足条件的元素或0
	 */
	public default float firstOrDefaultIf(IFloatPredicate predicate){
		return firstOrDefaultIf(predicate, 0.0F);
	}
	
	/**
	 * 返回第一个满足条件的元素。如果不存在，则返回默认值。
	 * @param predicate 谓词
	 * @param def 默认值
	 * @return 第一个满足条件的元素或默认值
	 */
	public default float firstOrDefaultIf(IFloatPredicate predicate, float def){
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			float val = enumerator.nextFloat();
			if(predicate.is(val)){
				return val;
			}
		}
		return def;
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param action 对每个元素执行的操作
	 * @return 执行的次数
	 */
	public default int foreach(IFloatAction action) {
		Arguments.isNotNull(action);
		
		IFloatEnumerator enumerator = iterator();
		int count = 0;
		while(enumerator.hasNext()) {
			action.invoke(enumerator.nextFloat());
			count++;
		}
		return count;
	}

	/**
	 * 对每个元素执行操作。
	 * @param action 对每个元素执行的操作，参数包含当前元素及其下标
	 * @return 执行的次数
	 */
	public default int foreach(IForeachFloatAction action) {
		Arguments.isNotNull(action);
		
		IFloatEnumerator enumerator = iterator();
		int count = 0;
		while(enumerator.hasNext()) {
			action.invoke(enumerator.nextFloat(), count++);
		}
		return count;
	}

	/**
	 * 所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 * @see IReferenceEnumerable#isAll(IPredicate)
	 * @see ICharEnumerable#isAll(ICharPredicate)
	 */
	public default boolean isAll(IFloatPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			float val = enumerator.nextFloat();
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
	public default boolean isExist(IFloatPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			float val = enumerator.nextFloat();
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
	public default boolean isExist(float value) {
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			float val = enumerator.nextFloat();
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
	public default boolean isNotAll(IFloatPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		IFloatEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			float val = enumerator.nextFloat();
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
	public default float[] toArray() {
		FloatArrayList list = new FloatArrayList(this);
		return list.toArray();
	}
	
}