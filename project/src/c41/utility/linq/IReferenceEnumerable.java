package c41.utility.linq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import c41.core.assertion.Arguments;
import c41.lambda.action.IAction1;
import c41.lambda.action.IForeachAction;
import c41.lambda.function.IForeachFunction;
import c41.lambda.function.IFunction;
import c41.lambda.function.IJoiner;
import c41.lambda.predicate.ICharPredicate;
import c41.lambda.predicate.IIntPredicate;
import c41.lambda.predicate.IPredicate;
import c41.lambda.selector.ISelector;
import c41.lambda.selector.ISelectorEx;
import c41.utility.collection.Iterables;
import c41.utility.collection.tuple.Tuple2;
import c41.utility.collection.tuple.Tuples;
import c41.utility.comparator.Comparators;
import c41.utility.linq.enumerator.IEnumerator;

/**
 * 引用类型的Enumerable。
 * @param <T> 元素类型
 */
public interface IReferenceEnumerable<T> extends IEnumerable<T>{

	/**
	 * 所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果所有元素都满足谓词，则返回true
	 * @see ICharEnumerable#all(ICharPredicate)
	 * @see IIntEnumerable#all(IIntPredicate)
	 */
	public default boolean all(IPredicate<? super T> predicate) {
		return Iterables.all(this, predicate);
	}

	/**
	 * 查询指定下标的元素。
	 * @param index 下标
	 * @return 指定元素
	 * @throws IllegalArgumentException index &lt; 0
	 * @throws NoSuchElementException 下标超出迭代器范围
	 */
	public default T at(int index) {
		return Iterables.at(this, index);
	}

	/**
	 * 返回满足条件的元素数量。
	 * @param predicate 谓词
	 * @return 数量
	 */
	public default int countIf(IPredicate<? super T> predicate) {
		return Iterables.countIf(this, predicate);
	}
	
	/**
	 * 存在与{@code value}相等的元素。
	 * <p>比较以{@code equals}的方式进行。</p>
	 * @param value 元素
	 * @return 如果存在，则返回true
	 */
	public default boolean exists(T value) {
		return Iterables.exists(this, value);
	}

	/**
	 * 存在满足谓词的元素。
	 * @param predicate 谓词
	 * @return 如果存在，则返回true
	 */
	public default boolean existsIf(IPredicate<? super T> predicate) {
		return Iterables.existsIf(this, predicate);
	}
	
	/**
	 * 存在与@{code value}引用相同的元素。
	 * @param value 元素
	 * @return 如果存在，则返回true
	 */
	public default boolean existsReference(T value) {
		return Iterables.existsReference(this, value);
	}
	
	/**
	 * 获取第一个元素。
	 * @return 第一个元素
	 * @exception NoSuchElementException 如果不存在元素
	 */
	public default T first() {
		return Iterables.first(this);
	}

	/**
	 * 返回第一个重复的元素，重复元素按照@{code equals}方式比较。
	 * @return 重复元素
	 */
	public default T firstDuplicateElement() {
		return Iterables.firstDuplicate(this);
	}
	
	/**
	 * 返回第一个重复的元素。如果不存在，就返回默认值。
	 * @param defProvider 默认值工厂
	 * @return 第一个重复元素或默认值
	 */
	public default T firstDuplicateElementOrCreateDefault(IFunction<? extends T> defProvider) {
		return Iterables.firstDuplicateOrCreateDefault(this, defProvider);
	}

	/**
	 * 返回第一个重复元素。如果不存在，则返回null。
	 * @return 第一个重复元素或null。
	 */
	public default T firstDuplicateElementOrDefault() {
		return Iterables.firstDuplicateElementOrDefault(this);
	}
	
	/**
	 * 返回第一个重复的元素。如果不存在，返回默认值。
	 * @param def 默认值
	 * @return 第一个重复元素或默认值。
	 */
	public default T firstDuplicateElementOrDefault(T def) {
		return Iterables.firstDuplicateElementOrDefault(this, def);
	}
	
	/**
	 * 返回第一个满足条件的元素。
	 * @param predicate 谓词
	 * @return 第一个满足的元素
	 * @exception NoSuchElementException 没有满足条件的元素
	 */
	public default T firstIf(IPredicate<? super T> predicate) {
		return Iterables.firstIf(this, predicate);
	}

	/**
	 * 返回第一个满足条件的下标。如果不存在，则返回-1。
	 * @param predicate 谓词
	 * @return 下标。
	 */
	public default int firstIndexIf(IPredicate<? super T> predicate) {
		return Iterables.firstIndexIf(this, predicate);
	}
	
	/**
	 * 返回元素value的下标。如果不存在，则返回-1。
	 * <p>比较以@{code equals}的方式进行。</p>
	 * @param value 目标元素
	 * @return 下标
	 */
	public default int firstIndexOf(T value) {
		return Iterables.firstIndexOf(this, value);
	}

	/**
	 * 返回元素value的下标。如果不存在，则返回-1。
	 * <p>比较以引用比较的方式进行。</p>
	 * @param value 目标元素
	 * @return 下标
	 */
	public default int firstIndexOfReference(T value) {
		return Iterables.firstIndexOfReference(this, value);
	}
	
	public default T firstOrCreateDefault(IFunction<? extends T> defaultValueProvider) {
		return Iterables.firstOrCreateDefault(this, defaultValueProvider);
	}
	
	/**
	 * 返回第一个满足条件的元素。如果不存在，则返回默认值。
	 * @param predicate 谓词
	 * @param defaultValueProvider 默认值
	 * @return 第一个满足条件的元素或默认值
	 */
	public default T firstOrCreateDefaultIf(IPredicate<? super T> predicate, IFunction<? extends T> defaultValueProvider) {
		return Iterables.firstOrCreateDefaultIf(this, predicate, defaultValueProvider);
	}

	public default T firstOrDefault() {
		return Iterables.firstOrDefault(this);
	}

	public default T firstOrDefault(T defaultValue) {
		return Iterables.firstOrDefault(this, defaultValue);
	}
	
	/**
	 * 返回第一个满足条件的元素。如果不存在，则返回null。
	 * @param predicate 谓词
	 * @return 第一个满足条件的元素或null
	 */
	public default T firstOrDefaultIf(IPredicate<? super T> predicate) {
		return Iterables.firstOrDefaultIf(this, predicate);
	}
	
	/**
	 * 返回第一个满足条件的元素。如果不存在，则返回默认值。
	 * @param predicate 谓词
	 * @param def 默认值
	 * @return 第一个满足条件的元素或默认值
	 */
	public default T firstOrDefaultIf(IPredicate<? super T> predicate, T def) {
		return Iterables.firstOrDefaultIf(this, predicate, def);
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param action 对每个元素执行的操作
	 * @return 执行的次数
	 */
	public default int foreach(IAction1<? super T> action) {
		return Iterables.foreach(this, action);
	}
	
	/**
	 * 对每个元素执行操作。
	 * @param action 对每个元素执行的操作，参数包含当前元素及其下标
	 * @return 执行的次数
	 */
	public default int foreach(IForeachAction<? super T> action) {
		return Iterables.foreach(this, action);
	}

	public default boolean foreach2(IForeachFunction<? super T> function) {
		return Iterables.foreach2(this, function);
	}

	public default boolean foreach2(IPredicate<? super T> predicate) {
		return Iterables.foreach2(this, predicate);
	}

	public default <K> IReferenceEnumerable<IReferenceGroup<K, T>> groupBy(ISelector<T, K> selector){
		return new ReferenceGroupByEnumerable<>(this, selector);
	}
	
	public default <V> IReferenceEnumerable<V> instanceOf(Class<V> cl){
		Arguments.isNotNull(cl);
		return where(c->cl.isInstance(c)).cast();
	}

	@Override
	public IEnumerator<T> iterator();

	/**
	 * 返回该Enumerable与other的笛卡尔积，针对每一个T和U的组合，生成一个Tuple2
	 * @param <U> 另一个类型
	 * @param other 另一个迭代器
	 * @return 合并后的Enumerable
	 */
	public default <U> IReferenceEnumerable<Tuple2<T, U>> join(Iterable<U> other){
		return new ReferenceJoinEnumerable<>(this, other, (t, u)->Tuples.make(t, u));
	}

	/**
	 * 返回该Enumerable与other的笛卡尔积，针对每一个T和U的组合，生成一个V。
	 * @param <U> 另一个类型
	 * @param <V> 返回的类型
	 * @param other 另一个迭代器
	 * @param joiner 合并T和U，生成一个V
	 * @return V的Enumerable
	 */
	public default <U, V> IReferenceEnumerable<V> join(Iterable<U> other, IJoiner<T, U, V> joiner){
		return new ReferenceJoinEnumerable<>(this, other, joiner);
	}

	public default <U, V> IReferenceEnumerable<V> join(U[] other, IJoiner<T, U, V> joiner){
		return new ReferenceJoinEnumerable<>(this, new ReferenceArrayEnumerable<>(other), joiner);
	}

	public default T last() {
		return Iterables.last(this);
	}
	
	public default T lastOrDefault() {
		return Iterables.lastOrDefault(this);
	}
	
	public default T lastOrDefault(T defaultValue) {
		return Iterables.lastOrDefault(this, defaultValue);
	}
	
	public default T lastOrCreateDefault(IFunction<? extends T> defaultValueProvider) {
		return Iterables.lastOrCreateDefault(this, defaultValueProvider);
	}
	
	public default IEnumerable<T> limit(int n){
		return new ReferenceLimitEnumerable<>(this, n);
	}

	/**
	 * 非所有元素都满足谓词。
	 * @param predicate 谓词
	 * @return 如果非所有元素都满足谓词，返回true
	 */
	public default boolean notAll(IPredicate<? super T> predicate) {
		return Iterables.notAll(this, predicate);
	}
	
	/**
	 * 不存在与{@code value}相等的元素。
	 * 比较以{@code equals}的方式进行。
	 * @param value 元素
	 * @return 如果不存在，则返回true
	 */
	public default boolean notExists(T value) {
		return Iterables.notExists(this, value);
	}
	
	/**
	 * 不存在与任何一个指定元素相等的元素。
	 * @param values 多个指定元素
	 * @return 如果不存在，则返回true
	 */
	public default boolean notExistsAnyOf(Object... values){
		return Iterables.notExistsAnyOf(this, values);
	}
	
	/**
	 * 不存在满足谓词的元素。
	 * @param predicate 谓词
	 * @return 如果不存在，则返回true
	 */
	public default boolean notExistsIf(IPredicate<? super T> predicate) {
		return Iterables.notExistsIf(this, predicate);
	}

	/**
	 * 不存在与{@code value}引用相同的元素。
	 * @param value 元素
	 * @return 如果不存在，则返回true
	 */
	public default boolean notExistsReference(T value) {
		return Iterables.notExistsReference(this, value);
	}

	public default IReferenceSortedEnumerable<T> orderBy(Comparator<? super T> comparator){
		return new ReferenceOrderByEnumerable<>(this, comparator);
	}
	
	public default <V extends Comparable<? super V>> IReferenceSortedEnumerable<T> orderBy(ISelector<? super T, V> selector){
		return new ReferenceOrderByEnumerable<>(this, (t1, t2)->Comparators.compare(selector.select(t1), selector.select(t2)));
	}
	
	/**
	 * 对元素按照条件排序，条件成立的排在前，条件不成立的排在后
	 * @param predicate 谓词
	 * @return 排序后的查询
	 */
	public default IReferenceSortedEnumerable<T> orderByCondition(IPredicate<T> predicate){
		Arguments.isNotNull(predicate);
		
		return new ReferenceOrderByEnumerable<>(this, (t1, t2)->{
			boolean b1 = predicate.is(t1);
			boolean b2 = predicate.is(t2);
			
			if(b1 && !b2) {
				return -1; 
			}
			if(b2 && !b1) {
				return 1;
			}
			return 0;
		});
	}

	/**
	 * 对元素进行自然排序
	 * @return 排序后的查询
	 */
	public default IReferenceSortedEnumerable<T> orderBySelf(){
		return new ReferenceOrderByEnumerable<>(this, (t1, t2)->{
			return Comparators.compareNatural(t1, t2);
		});
	}

	public default <V> IReferenceEnumerable<V> select(ISelector<? super T, ? extends V> selector){
		return new ReferenceSelectEnumerable<>(this, selector);
	}

	public default <V> IReferenceEnumerable<V> select(ISelectorEx<? super T, ? extends V> selector){
		return new ReferenceSelectEnumerable<>(this, selector);
	}
	
	public default <V> IReferenceEnumerable<V> selectMany(ISelector<? super T, ? extends Iterable<? extends V>> selector){
		return new ReferenceSelectManyEnumerable<>(this, selector);
	}
	
	/**
	 * 构造所有元素组成的数组
	 * @return 数组
	 */
	public default Object[] toArray() {
		return Iterables.toArray(this);
	}
	
	/**
	 * 构造所有元素组成的数组
	 * @param type 用于指定类型
	 * @return 数组
	 */
	public default T[] toArray(Class<T> type) {
		return Iterables.toArray(this, type);
	}
	
	/**
	 * 构造所有元素组成的数组
	 * @param array 数组
	 * @return 数组
	 */
	public default T[] toArray(T[] array) {
		return Iterables.toArray(this, array);
	}
	
	public default <K> Map<K, IReferenceEnumerable<T>> toMap(ISelector<T, K> selector){
		Arguments.isNotNull(selector);
		
		Map<K, ArrayList<T>> map = new HashMap<>();
		IEnumerator<T> enumerator = iterator();
		while(enumerator.hasNext()) {
			T obj = enumerator.next();
			K key = selector.select(obj);
			ArrayList<T> list = map.get(key);
			if(list == null) {
				list = new ArrayList<>();
				map.put(key, list);
			}
			list.add(obj);
		}
		
		Map<K, IReferenceEnumerable<T>> rst = new HashMap<>();
		for(Entry<K, ArrayList<T>> kv : map.entrySet()) {
			rst.put(kv.getKey(), new ArrayListEnumerable<>(kv.getValue()));
		}
		return rst;
	}

	public default IReferenceEnumerable<T> union(Iterable<? extends T> iterable){
		return new ReferenceUnionEnumerable<>(this, Linq.from(iterable));
	}

	public default IReferenceEnumerable<T> where(IPredicate<? super T> predicate){
		return new ReferenceWhereEnumerable<>(this, predicate);
	}
	
}