package c41.lambda.selector;

@FunctionalInterface
public interface IByteConverter<T> extends ISelector<T, Byte>{

	public byte convert(T value);
	
	@Override
	public default Byte select(T value) {
		return convert(value);
	}
	
}
