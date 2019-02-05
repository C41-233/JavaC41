package c41.lambda.selector;

@FunctionalInterface
public interface IFloatSelector<V> extends ISelector<Float, V>{

	public V select(float ch);
	
	@Override
	public default V select(Float ch) {
		return select((float)ch);
	}
	
}
