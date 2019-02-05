
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class ByteHashSet implements IByteCollection{

	private final HashSet<Byte> set = new HashSet<>();

	public ByteHashSet(){
	
	}

	@Override
	public boolean add(byte value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public IByteEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr extends ByteEnumeratorBase{
	
		private final Iterator<Byte> iterator = set.iterator();
		private Byte current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		protected byte doNext() {
			return current;
		}
	
	}
	
}