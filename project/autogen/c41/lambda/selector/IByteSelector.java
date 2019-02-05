package c41.lambda.selector;

@FunctionalInterface
public interface IByteSelector<V> extends ISelector<Byte, V>{

	public V select(byte ch);
	
	@Override
	public default V select(Byte ch) {
		return select((byte)ch);
	}
	
}
