package c41.lambda.selector;

@FunctionalInterface
public interface IDoubleConverter<T> extends ISelector<T, Double>{

	public double convert(T value);
	
	@Override
	public default Double select(T value) {
		return convert(value);
	}
	
}
