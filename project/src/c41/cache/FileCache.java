package c41.cache;

import java.io.File;

import c41.lambda.function.IFunction;
import c41.lambda.function.IFunction1;

public class FileCache<V>{

	private final File file;
	private final IFunction1<V, File> provider;
	
	private long lastTime;
	private V cache;
	
	public FileCache(File file, IFunction<V> provider) {
		this(file, f -> provider.invoke());
	}
	
	public FileCache(File file, IFunction1<V, File> provider) {
		this.file = file;
		this.provider = provider;
	}
	
	public V get() {
		long now = file.lastModified();
		if(now > lastTime) {
			cache = provider.invoke(file);
			lastTime = now;
		}
		return cache;
	}

}
