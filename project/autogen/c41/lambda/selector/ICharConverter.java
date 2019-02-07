package c41.lambda.selector;

@FunctionalInterface
public interface ICharConverter<T> extends ISelector<T, Character>{

	public char convert(T value);
	
	@Override
	public default Character select(T value) {
		return convert(value);
	}
	
}
