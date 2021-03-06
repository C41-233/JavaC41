package c41.utility.linq;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import c41.utility.Convert;
import c41.utility.collection.Iterables;
import c41.utility.linq.enumerator.IEnumerator;

/**
 * Enumerable的基接口。
 * @param <T> 查询元素
 */
public interface IEnumerable<T> extends Iterable<T>{

	/**
	 * 将元素强制类型转换。
	 * @param <V> 转化类型
	 * @return 转换后的Enumerable。
	 */
	@SuppressWarnings("unchecked")
	public default <V> IReferenceEnumerable<V> cast(){
		return (IReferenceEnumerable<V>) this;
	}
	
	/**
	 * 返回元素的个数。
	 * @return 元素个数
	 */
	public default int count() {
		return Iterables.count(this);
	}
	
	/**
	 * 将所有元素添加到Collection中，元素被加入的顺序与迭代器的顺序一致。
	 * @param <TCollection> 集合类型
	 * @param collection 集合
	 * @return collection
	 */
	public default <TCollection extends Collection<T>> TCollection fillCollection(TCollection collection) {
		return Iterables.fillCollection(this, collection);
	}
	
	/**
	 * 是否存在重复元素。
	 * @return 如果存在重复元素，则返回true
	 */
	public default boolean hasDuplicateElement() {
		return Iterables.hasDuplicateElement(this);
	}

	/**
	 * 是否是一个空查询（元素的个数为0）。
	 * @return 如果是一个空查询，则返回true
	 */
	public default boolean isEmpty() {
		return Iterables.isEmpty(this);
	}

	/**
	 * 是否是一个非空查询（元素的个数不为0）。
	 * @return 如果是一个非空查询，则返回true
	 */
	public default boolean isNotEmpty() {
		return Iterables.isNotEmpty(this);
	}
	
	@Override
	public IEnumerator<T> iterator();

	/**
	 * 跳过前n个元素。
	 * @param n 跳过的元素个数
	 * @return 跳过后的查询
	 */
	public default IEnumerable<T> skip(int n){
		return new ReferenceSkipEnumerable<>(this, n);
	}

	/**
	 * 将元素转换为byte。
	 * @return IByteEnumerable
	 */
	public default IByteEnumerable toByte() {
		return new ConvertByteEnumerable<>(this, value -> Convert.toByte(value));
	}
	
	/**
	 * 将元素转换为double。
	 * @return IDoubleEnumerable
	 */
	public default IDoubleEnumerable toDouble() {
		return new ConvertDoubleEnumerable<>(this, value -> Convert.toDouble(value));
	}

	/**
	 * 将元素转换为float。
	 * @return IFloatEnumerable
	 */
	public default IFloatEnumerable toFloat() {
		return new ConvertFloatEnumerable<>(this, value -> Convert.toFloat(value));
	}
	
	/**
	 * 将元素转换为int。
	 * @return IIntEnumerable
	 */
	public default IIntEnumerable toInt() {
		return new ConvertIntEnumerable<>(this, value -> Convert.toInt(value));
	}

	/**
	 * 将所有元素以List的形式返回，元素的顺序与迭代器的顺序一致。
	 * @return List
	 */
	public default List<T> toList(){
		return Iterables.toList(this);
	}

	/**
	 * 将元素转换为long。
	 * @return ILongEnumerable
	 */
	public default ILongEnumerable toLong() {
		return new ConvertLongEnumerable<>(this, value -> Convert.toLong(value));
	}
	
	/**
	 * 将所有元素以Set的形式返回。
	 * @return Set
	 */
	public default Set<T> toSet(){
		return Iterables.toSet(this);
	}
	
	/**
	 * 将元素转换为short。
	 * @return IShortEnumerable
	 */
	public default IShortEnumerable toShort() {
		return new ConvertShortEnumerable<>(this, value -> Convert.toShort(value));
	}
	
}
