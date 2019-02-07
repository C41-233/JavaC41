package c41.lambda.selector;

@FunctionalInterface
public interface IShortConverter<T> extends ISelector<T, Short>{

	public short convert(T value);
	
	@Override
	public default Short select(T value) {
		return convert(value);
	}
	
}
