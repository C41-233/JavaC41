package c41.lambda.selector;

@FunctionalInterface
public interface IShortSelector<V> extends ISelector<Short, V>{

	public V select(short ch);
	
	@Override
	public default V select(Short ch) {
		return select((short)ch);
	}
	
}
