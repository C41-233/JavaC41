package c41.lambda.selector;

@FunctionalInterface
public interface IIntSelector<V> extends ISelector<Integer, V>{

	public V select(int ch);
	
	@Override
	public default V select(Integer ch) {
		return select((int)ch);
	}
	
}
