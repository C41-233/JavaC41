package c41.lambda.selector;

@FunctionalInterface
public interface ILongConverter<T> extends ISelector<T, Long>{

	public long convert(T value);
	
	@Override
	public default Long select(T value) {
		return convert(value);
	}
	
}
