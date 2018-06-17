
package  c41.utility.collection.set;

import java.util.HashSet;

public class CharHashSet{

	private final HashSet<Character> set = new HashSet<>();

	public CharHashSet(){
	
	}

	public boolean add(char value){
		return set.add(value);
	}

}