
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


/**
 * 基本类型char的Enumerable。
 */
public interface ICharEnumerable extends IEnumerable<Character>{
	
	@Override
	public ICharEnumerator iterator();
	
	/**
	 * 查询指定下标的值。
	 * @param index 下标
	 * @return 指定值
	 * @throws IllegalArgumentException index &lt; 0
	 * @throws NoSuchElementException 下标超出迭代器范围
	 */
	public default char at(int index){
		Arguments.is(index>=0, "%d < 0", index);
		
		ICharEnumerator enumerator = iterator();
		for(int i=0; i<index; i++) {
			if(!enumerator.hasNext()) {
				throw new NoSuchElementException();
			}
			if(!enumerator.hasNext()){
				throw new NoSuchElementException();
			}
			enumerator.nextChar();
		}
		if(enumerator.hasNext()) {
			return enumerator.nextChar();
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * 返回满足条件的元素数量。
	 * @param predicate 谓词
	 * @return 数量
	 */
	public default int countIf(ICharPredicate predicate){
		Arguments.isNotNull(predicate);
		
		int count = 0;
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			enumerator.nextChar();
			count++;
		}
		return count;
	}
	
	/**
	 * 获取第一个元素。
	 * @return 第一个元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default char first(){
		ICharEnumerator enumerator = iterator();
		return enumerator.next();
	}
	
	/**
	 * 获取第一个重复元素。
	 * @return 第一个重复元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default char firstDuplicateElement(){
		CharHashSet set = new CharHashSet();
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			char value = enumerator.nextChar();
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
	public default char firstDuplicateElementOrDefault(){
		return firstDuplicateElementOrDefault((char)0);
	}
	
	/**
	 * 返回第一个重复元素。如果不存在，则返回默认值。
	 * @param def 默认值
	 * @return 第一个重复元素或默认值。
	 */
	public default char firstDuplicateElementOrDefault(char def){
		CharHashSet set = new CharHashSet();
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			char value = enumerator.nextChar();
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
	public default char firstIf(ICharPredicate predicate){
		Arguments.isNotNull(predicate);
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			char value = enumerator.nextChar();
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
	public default int firstIndexIf(ICharPredicate predicate){
		Arguments.isNotNull(predicate);
		
		ICharEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			char value = enumerator.nextChar();
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
	public default int firstIndexOf(char value){
		ICharEnumerator enumerator = iterator();
		int index = 0;
		while(enumerator.hasNext()){
			char val = enumerator.nextChar();
			if(val == value){
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
	public default char firstOrDefaultIf(ICharPredicate predicate){
		return firstOrDefaultIf(predicate, (char)0);
	}
	
	/**
	 * 返回第一个满足条件的元素。如果不存在，则返回默认值。
	 * @param predicate 谓词
	 * @param def 默认值
	 * @return 第一个满足条件的元素或默认值
	 */
	public default char firstOrDefaultIf(ICharPredicate predicate, char def){
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()){
			char val = enumerator.nextChar();
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
	public default int foreach(ICharAction action) {
		Arguments.isNotNull(action);
		
		ICharEnumerator enumerator = iterator();
		int count = 0;
		while(enumerator.hasNext()) {
			action.invoke(enumerator.nextChar());
			count++;
		}
		return count;
	}

	/**
	 * 对每个元素执行操作。
	 * @param action 对每个元素执行的操作，参数包含当前元素及其下标
	 * @return 执行的次数
	 */
	public default int foreach(IForeachCharAction action) {
		Arguments.isNotNull(action);
		
		ICharEnumerator enumerator = iterator();
		int count = 0;
		while(enumerator.hasNext()) {
			action.invoke(enumerator.nextChar(), count++);
		}
		return count;
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param predicate 对每个元素执行的操作，返回false表示break
	 * @return true表示循环完毕，false表示break退出
	 */
	public default boolean foreach2(ICharPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			boolean next = predicate.invoke(enumerator.nextChar());
			if(!next) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 * @see IReferenceEnumerable#all(IPredicate)
	 * @see ICharEnumerable#all(ICharPredicate)
	 */
	public default boolean all(ICharPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			char val = enumerator.nextChar();
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
	public default boolean existsIf(ICharPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			char val = enumerator.nextChar();
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
	public default boolean exists(char value) {
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			char val = enumerator.nextChar();
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
	public default boolean notAll(ICharPredicate predicate) {
		Arguments.isNotNull(predicate);
		
		ICharEnumerator enumerator = iterator();
		while(enumerator.hasNext()) {
			char val = enumerator.nextChar();
			if(predicate.is(val) == false) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 跳过前n个元素。
	 * @param n 跳过的元素个数
	 * @return 跳过后的查询
	 */
	@Override
	public default ICharEnumerable skip(int n){
		return new CharSkipEnumerable(this, n);
	}
	
	/**
	 * 返回所有元素组成的数组。
	 * 如果没有元素，则返回空数组。
	 * @return 数组
	 */
	public default char[] toArray() {
		CharArrayList list = new CharArrayList(this);
		return list.toArray();
	}
	
}