package c41.lambda.selector;

@FunctionalInterface
public interface IFloatConverter<T> extends ISelector<T, Float>{

	public float convert(T value);
	
	@Override
	public default Float select(T value) {
		return convert(value);
	}
	
}
