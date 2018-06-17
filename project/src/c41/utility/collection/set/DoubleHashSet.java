
package  c41.utility.collection.set;

import java.util.HashSet;

public class DoubleHashSet{

	private final HashSet<Double> set = new HashSet<>();

	public DoubleHashSet(){
	
	}

	public boolean add(double value){
		return set.add(value);
	}

}