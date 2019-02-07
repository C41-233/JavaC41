package c41.utility.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import c41.core.assertion.Arguments;
import c41.lambda.action.IAction1;
import c41.lambda.action.IForeachAction;
import c41.lambda.function.IForeachFunction;
import c41.lambda.function.IFunction;
import c41.lambda.predicate.IPredicate;
import c41.reflect.StaticClassException;

/**
 * 
 * {@code Iterable}的工具类型，大部分用于为Linq提供默认实现。
 */
public final class Iterables {

	private Iterables() {
		throw new StaticClassException();
	}
	
	/**
	 * 所有元素都满足谓词。
	 * @param <T> 泛型参数
	 * @param iterable 容器
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 */
	public static <T> boolean all(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.all(iterable.iterator(), predicate);
	}
	
	public static <T> T at(Iterable<T> iterable, int index) {
		Arguments.isNotNull(iterable);
		return Iterators.at(iterable.iterator(), index);
	}

	public static int count(Iterable<?> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.count(iterable.iterator());
	}

	public static <T> int countIf(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.countIf(iterable.iterator(), predicate);
	}

	public static boolean equals(Iterable<?> iterable1, Iterable<?> iterable2) {
		if(iterable1 == iterable2) {
			return true;
		}
		if(iterable1 == null || iterable2 == null) {
			return false;
		}
		return Iterators.equals(iterable1.iterator(), iterable2.iterator());
	}

	public static boolean exists(Iterable<?> iterable, Object value) {
		Arguments.isNotNull(iterable);
		return Iterators.exists(iterable.iterator(), value);
	}
	
	/**
	 * 存在满足谓词的元素。
	 * @param <T> 泛型参数
	 * @param iterable 容器
	 * @param predicate 谓词
	 * @return 如果存在，则返回true
	 */
	public static <T> boolean existsIf(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.existsIf(iterable.iterator(), predicate);
	}

	public static boolean existsReference(Iterable<?> iterable, Object value) {
		Arguments.isNotNull(iterable);
		return Iterators.existsReference(iterable.iterator(), value);
	}
	
	public static <T, TCollection extends Collection<T>> TCollection fillCollection(Iterable<T> iterable, TCollection collection) {
		Arguments.isNotNull(iterable);
		return Iterators.fillCollection(iterable.iterator(), collection);
	}

	public static <T> T first(Iterable<T> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.first(iterable.iterator());
	}
	
	public static <T> T firstDuplicate(Iterable<T> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.firstDuplicate(iterable.iterator());
	}

	public static <T> T firstDuplicateOrCreateDefault(Iterable<T> iterable, IFunction<? extends T> defProvider){
		Arguments.isNotNull(iterable);
		return Iterators.firstDuplicateOrCreateDefault(iterable.iterator(), defProvider);
	}
	
	public static <T> T firstDuplicateOrDefault(Iterable<T> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.firstDuplicateOrDefault(iterable.iterator());
	}
	
	public static <T> T firstDuplicateOrDefault(Iterable<T> iterable, T def) {
		Arguments.isNotNull(iterable);
		return Iterators.firstDuplicateOrDefault(iterable.iterator(), def);
	}

	public static <T> T firstIf(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.fisrtIf(iterable.iterator(), predicate);
	}

	public static <T> int firstIndexIf(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.firstIndexIf(iterable.iterator(), predicate);
	}

	public static <T> int firstIndexOf(Iterable<T> iterable, T value) {
		Arguments.isNotNull(iterable);
		return Iterators.firstIndexOf(iterable.iterator(), value);
	}

	public static <T> int firstIndexOfReference(Iterable<T> iterable, T value) {
		Arguments.isNotNull(iterable);
		return Iterators.firstIndexOfReference(iterable.iterator(), value);
	}
	
	public static <T> T firstOrCreateDefaultIf(Iterable<T> iterable, IPredicate<? super T> predicate, IFunction<? extends T> defProvider) {
		Arguments.isNotNull(iterable);
		return Iterators.firstOrCreateDefaultIf(iterable.iterator(), predicate, defProvider);
	}
	
	public static <T> T firstOrDefaultIf(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.firstOrDefaultIf(iterable.iterator(), predicate);
	}
	
	public static <T> T firstOrDefaultIf(Iterable<T> iterable, IPredicate<? super T> predicate, T def) {
		Arguments.isNotNull(iterable);
		return Iterators.firstOrDefaultIf(iterable.iterator(), predicate, def);
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterable 迭代器
	 * @param action 对每个元素执行的操作
	 * @return 执行的次数
	 */
	public static <T> int foreach(Iterable<T> iterable, IAction1<? super T> action) {		
		Arguments.isNotNull(iterable);
		return Iterators.foreach(iterable.iterator(), action);
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterable 迭代器
	 * @param action 对每个元素执行的操作，参数包含当前元素及其下标
	 * @return 执行的次数
	 */
	public static <T> int foreach(Iterable<T> iterable, IForeachAction<? super T> action) {	
		Arguments.isNotNull(iterable);
		return Iterators.foreach(iterable.iterator(), action);
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterable 迭代器
	 * @param predicate 对每个元素执行的操作，返回false表示break
	 * @return true表示循环完毕，false表示break退出
	 */
	public static <T> boolean foreach2(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.foreach2(iterable.iterator(), predicate);
	}

	/**
	 * 对每个元素执行操作。
	 * @param <T> 泛型参数
	 * @param iterable 迭代器
	 * @param function 对每个元素执行的操作，参数包含当前元素及其下标，返回false表示break
	 * @return true表示循环完毕，false表示break退出
	 */
	public static <T> boolean foreach2(Iterable<T> iterable, IForeachFunction<? super T> function) {
		Arguments.isNotNull(iterable);
		return Iterators.foreach2(iterable.iterator(), function);
	}

	public static boolean hasDuplicateElement(Iterable<?> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.hasDuplicate(iterable.iterator());
	}

	public static boolean isEmpty(Iterable<?> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.isEmpty(iterable.iterator());
	}

	public static boolean isNotEmpty(Iterable<?> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.isNotEmpty(iterable.iterator());
	}
	
	/**
	 * 非所有元素都满足谓词。
	 * @param <T> 泛型参数
	 * @param iterable 容器
	 * @param predicate 谓词
	 * @return 如果非所有元素都满足谓词，返回true
	 */
	public static <T> boolean notAll(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.notAll(iterable.iterator(), predicate);
	}
	
	public static boolean notExists(Iterable<?> iterable, Object value) {
		Arguments.isNotNull(iterable);
		return Iterators.isNotExist(iterable.iterator(), value);
	}
	
	public static boolean notExistsAnyOf(Iterable<?> iterable, Object...values) {
		Arguments.isNotNull(iterable);
		return Iterators.notExistsAnyOf(iterable.iterator(), values);
	}
	
	public static <T> boolean notExistsIf(Iterable<T> iterable, IPredicate<? super T> predicate) {
		Arguments.isNotNull(iterable);
		return Iterators.notExistsIf(iterable.iterator(), predicate);
	}
	
	public static boolean notExistsReference(Iterable<?> iterable, Object value) {
		Arguments.isNotNull(iterable);
		return Iterators.notExistsReference(iterable.iterator(), value);
	}
	
	public static <T> Iterable<T> of(T[] array){
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				return Iterators.of(array);
			}
		};
	}
	
	public static <T> Object[] toArray(Iterable<T> iterable) {
		Arguments.isNotNull(iterable);
		return Iterators.toArray(iterable.iterator());
	}
	
	public static <T> T[] toArray(Iterable<T> iterable, Class<T> cl) {
		Arguments.isNotNull(iterable);
		return Iterators.toArray(iterable.iterator(), cl);
	}

	public static <T> T[] toArray(Iterable<T> iterable, T[] array) {
		Arguments.isNotNull(iterable);
		return Iterators.toArray(iterable.iterator(), array);
	}

	public static <T> List<T> toList(Iterable<T> iterable){
		Arguments.isNotNull(iterable);
		return Iterators.toList(iterable.iterator());
	}

	public static <T> Set<T> toSet(Iterable<T> iterable){
		Arguments.isNotNull(iterable);
		return Iterators.toSet(iterable.iterator());
	}
	
}
