package c41.lambda.selector;

@FunctionalInterface
public interface ILongSelector<V> extends ISelector<Long, V>{

	public V select(long ch);
	
	@Override
	public default V select(Long ch) {
		return select((long)ch);
	}
	
}
