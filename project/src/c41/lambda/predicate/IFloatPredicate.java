/*
 * This file is generated by ITPredicate.java.template
 */

package c41.lambda.predicate;

public interface IFloatPredicate extends IPredicate<Float>{

	public boolean is(float val);
	
	@Override
	public default boolean is(Float val) {
		return is((float)val);
	}
	
}