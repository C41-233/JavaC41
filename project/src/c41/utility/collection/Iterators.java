package c41.utility.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import c41.core.assertion.Arguments;
import c41.lambda.action.IAction1;
import c41.lambda.action.IForeachAction;
import c41.lambda.function.IForeachFunction;
import c41.lambda.function.IFunction;
import c41.lambda.predicate.IPredicate;
import c41.reflect.StaticClassException;
import c41.utility.algorithm.LinearSearch;

public final class Iterators {

	private Iterators() {
		throw new StaticClassException();
	}

	/**
	 * 迭代器所有元素都满足谓词。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 */
	public static <T> boolean all(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj) == false) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> T at(Iterator<T> iterator, int index) {
		Arguments.isNotNull(iterator);
		Arguments.is(index>=0, "%d < 0", index);
		
		for(int i=0; i<index; i++) {
			if(!iterator.hasNext()) {
				throw new NoSuchElementException();
			}
			iterator.next();
		}
		if(iterator.hasNext()) {
			return iterator.next();
		}
		throw new NoSuchElementException();
	}

	public static int count(Iterator<?> iterator) {
		Arguments.isNotNull(iterator);
		
		int count = 0;
		while(iterator.hasNext()) {
			iterator.next();
			count++;
		}
		return count;
	}

	public static <T> int countIf(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		int count = 0;
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj)) {
				count++;
			}
		}
		return count;
	}

	public static boolean equals(Iterator<?> iterator1, Iterator<?> iterator2) {
		if(iterator1 == iterator2) {
			return true;
		}
		
		if(iterator1 == null || iterator2 == null) {
			return false;
		}
		
		while(iterator1.hasNext() && iterator2.hasNext()) {
			if(Objects.equals(iterator1.next(), iterator2.next()) == false) {
				return false;
			}
		}
		if(iterator1.hasNext() || iterator2.hasNext()) {
			return false;
		}
		return true;
	}

	public static boolean exists(Iterator<?> iterator, Object value) {
		Arguments.isNotNull(iterator);
		
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if(Objects.equals(obj, value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 迭代器存在满足谓词的元素。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param predicate 谓词
	 * @return 如果存在，则返回true
	 */
	public static <T> boolean existsIf(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj)) {
				return true;
			}
		}
		return false;
	}

	public static boolean existsReference(Iterator<?> iterator, Object value) {
		Arguments.isNotNull(iterator);
		
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if(obj == value) {
				return true;
			}
		}
		return false;
	}

	public static <T, TCollection extends Collection<T>> TCollection fillCollection(Iterator<T> iterator, TCollection collection) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(collection);
		
		while(iterator.hasNext()) {
			collection.add(iterator.next());
		}
		return collection;
	}

	public static <T> T first(Iterator<T> iterator) {
		Arguments.isNotNull(iterator);
		return iterator.next();
	}
	
	public static <T> T firstDuplicate(Iterator<T> iterator) {
		return firstDuplicateOrCreateDefault(iterator, ()->{
			throw new NoSuchElementException();
		});
	}

	public static <T> T firstDuplicateElementOrDefault(Iterator<T> iterator) {
		return firstDuplicateElementOrDefault(iterator, null);
	}

	public static <T> T firstDuplicateElementOrDefault(Iterator<T> iterator, T def) {
		Arguments.isNotNull(iterator);
		
		HashSet<T> set = new HashSet<>();
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(set.add(obj) == false) {
				return obj;
			}
		}
		return def;
	}

	public static <T> T firstDuplicateOrCreateDefault(Iterator<T> iterator, IFunction<? extends T> defProvider){
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(defProvider);
		
		HashSet<T> set = new HashSet<>();
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(set.add(obj) == false) {
				return obj;
			}
		}
		return defProvider.invoke();
	}

	public static <T> T firstIf(Iterator<T> iterator, IPredicate<? super T> predicate){
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		while(iterator.hasNext()) {
			T current = iterator.next();
			if(predicate.is(current)) {
				return current;
			}
		}
		throw new NoSuchElementException();
	}

	public static <T> int firstIndexIf(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
	
		int index = 0;
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static <T> int firstIndexOf(Iterator<T> iterator, T value) {
		Arguments.isNotNull(iterator);
		
		int index = 0;
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(Objects.equals(obj, value)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static <T> int firstIndexOfReference(Iterator<T> iterator, T value) {
		Arguments.isNotNull(iterator);
		
		int index = 0;
		while(iterator.hasNext()) {
			T val = iterator.next();
			if(val == value) {
				return index; 
			}
			++index;
		}
		return -1;
	}
	
	public static <T> T firstOrCreateDefault(Iterator<T> iterator, IFunction<? extends T> defaultValueProvider) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(defaultValueProvider);
		if(iterator.hasNext()) {
			return iterator.next();
		}
		return defaultValueProvider.invoke();
	}

	public static <T> T firstOrCreateDefaultIf(Iterator<T> iterator, IPredicate<? super T> predicate, IFunction<? extends T> defaultValueProvider) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		Arguments.isNotNull(defaultValueProvider);
		
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj)) {
				return obj;
			}
		}
		return defaultValueProvider.invoke();
	}

	public static <T> T firstOrDefault(Iterator<T> iterator) {
		Arguments.isNotNull(iterator);
		if(iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}

	public static <T> T firstOrDefault(Iterator<T> iterator, T defaultValue) {
		if(iterator.hasNext()) {
			return iterator.next();
		}
		return defaultValue;
	}

	public static <T> T firstOrDefaultIf(Iterator<T> iterable, IPredicate<? super T> predicate) {
		return firstOrDefaultIf(iterable, predicate, null);
	}

	public static <T> T firstOrDefaultIf(Iterator<T> iterator, IPredicate<? super T> predicate, T def) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj)) {
				return obj;
			}
		}
		return def;
	}

	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param action 对每个元素执行的操作
	 * @return 执行的次数
	 */
	public static <T> int foreach(Iterator<T> iterator, IAction1<? super T> action) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(action);
		
		int count = 0;
		while(iterator.hasNext()) {
			action.invoke(iterator.next());
			count++;
		}
		return count;
	}

	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param action 对每个元素执行的操作，参数包含当前元素及其下标
	 * @return 执行的次数
	 */
	public static <T> int foreach(Iterator<T> iterator, IForeachAction<? super T> action) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(action);
		
		int count = 0;
		while(iterator.hasNext()) {
			action.invoke(iterator.next(), count++);
		}
		return count;
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param function 对每个元素执行的操作，参数包含当前元素及其下标，返回false表示break
	 * @return true表示循环完毕，false表示break退出
	 */
	public static <T> boolean foreach2(Iterator<T> iterator, IForeachFunction<? super T> function) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(function);
		
		int count = 0;
		while(iterator.hasNext()) {
			boolean next = function.invoke(iterator.next(), count++);
			if(!next) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param predicate 对每个元素执行的操作，返回false表示break
	 * @return true表示循环完毕，false表示break退出
	 */
	public static <T> boolean foreach2(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		while(iterator.hasNext()) {
			boolean next = predicate.invoke(iterator.next());
			if(!next) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasDuplicate(Iterator<?> iterator) {
		Arguments.isNotNull(iterator);
	
		HashSet<Object> set = new HashSet<>();
		while(iterator.hasNext()) {
			if(set.add(iterator.next()) == false) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEmpty(Iterator<?> iterator) {
		Arguments.isNotNull(iterator);
		return iterator.hasNext() == false;
	}

	public static boolean isNotEmpty(Iterator<?> iterable) {
		return isEmpty(iterable) == false;
	}

	public static boolean isNotExist(Iterator<?> iterator, Object value){
		Arguments.isNotNull(iterator);

		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if(Objects.equals(obj, value)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> T last(Iterator<T> iterator) {
		Arguments.isNotNull(iterator);
		
		if(!iterator.hasNext()) {
			throw new NoSuchElementException();
		}
		T current = iterator.next();
		while(iterator.hasNext()) {
			current = iterator.next();
		}
		return current;
	}

	public static <T> T lastOrCreateDefault(Iterator<T> iterator, IFunction<? extends T> defaultValueProvider) {
		Arguments.isNotNull(iterator);

		if(!iterator.hasNext()) {
			return defaultValueProvider.invoke();
		}
		T current = iterator.next();
		while(iterator.hasNext()) {
			current = iterator.next();
		}
		return current;
	}

	public static <T> T lastOrDefault(Iterator<T> iterator) {
		Arguments.isNotNull(iterator);
		
		T current = null;
		while(iterator.hasNext()) {
			current = iterator.next();
		}
		return current;
	}
	
	public static <T> T lastOrDefault(Iterator<T> iterator, T defaultValue) {
		Arguments.isNotNull(iterator);
		
		T current = defaultValue;
		while(iterator.hasNext()) {
			current = iterator.next();
		}
		return current;
	}
	
	/**
	 * 迭代器非所有元素都满足谓词。
	 * @param <T> 泛型参数
	 * @param iterator 迭代器
	 * @param predicate 谓词
	 * @return 如果非所有元素都满足谓词，返回true
	 */
	public static <T> boolean notAll(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);
		
		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj) == false) {
				return true;
			}
		}
		return false;
	}

	public static boolean notExistsAnyOf(Iterator<?> iterator, Object...values) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(values);
		
		if(values.length <= 16) {
			return notExistsIf(iterator, (Object obj)->LinearSearch.isExist(values, obj));
		}
		
		HashSet<Object> set = new HashSet<>();
		for(Object value : values) {
			set.add(value);
		}
		return notExistsIf(iterator, (Object obj)->set.contains(obj));
	}
	
	public static <T> boolean notExistsIf(Iterator<T> iterator, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterator);
		Arguments.isNotNull(predicate);

		while(iterator.hasNext()) {
			T obj = iterator.next();
			if(predicate.is(obj)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean notExistsReference(Iterator<?> iterator, Object value) {
		Arguments.isNotNull(iterator);

		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if(obj == value) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> Iterator<T> of(T[] array){
		return new Iterator<T>() {

			private int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < array.length;
			}	

			@Override
			public T next() {
				return array[i++];
			}
		};
	}
	
	public static <T> Object[] toArray(Iterator<T> iterator) {
		Arguments.isNotNull(iterator);
		
		List<T> list = toList(iterator);
		return list.toArray();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Iterator<T> iterator, Class<T> type) {
		Arguments.isNotNull(type);
		
		List<T> list = toList(iterator);
		T[] array = (T[]) Array.newInstance(type, list.size());
		return list.toArray(array);
	}

	public static <T> T[] toArray(Iterator<T> iterator, T[] array) {
		Arguments.isNotNull(array);
		
		List<T> list = toList(iterator); 
		return list.toArray(array);
	}

	public static <T> List<T> toList(Iterator<T> iterator){
		return fillCollection(iterator, new ArrayList<>());
	}
	
	public static <T> Set<T> toSet(Iterator<T> iterator){
		return fillCollection(iterator, new HashSet<>());
	}

}
