package c41.lambda.selector;

@FunctionalInterface
public interface IDoubleSelector<V> extends ISelector<Double, V>{

	public V select(double ch);
	
	@Override
	public default V select(Double ch) {
		return select((double)ch);
	}
	
}
