package c41.utility.collection.set;

public final class Flags <T extends Enum<T>> {

	private int value;
	
	public Flags() {}
	
	public void add(T t) {
		value |= 1 << t.ordinal();
	}
	
	public void remove(T t) {
		value &= ~(1 << t.ordinal());
	}
	
	@SafeVarargs
	public static <T extends Enum<T>> Flags of(T...t) {
		Flags<T> flags = new Flags<>();
		for(T e : t) {
			flags.add(e);
		}
		return flags;
	}
	
	public boolean has(T t) {
		int flag = 1 << t.ordinal();
		return (value & flag) != 0;
	}
	
	public int getMask() {
		return this.value;
	}
	
}
