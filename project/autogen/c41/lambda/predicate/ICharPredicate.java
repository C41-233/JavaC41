/*
 * This file is generated by ITPredicate.java.template
 */

package c41.lambda.predicate;

public interface ICharPredicate extends IPredicate<Character>{

	public boolean is(char val);
	
	@Override
	public default boolean is(Character val) {
		return is((char)val);
	}
	
}