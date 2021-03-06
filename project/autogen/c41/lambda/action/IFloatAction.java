/*
 * This file is generated by ITAction.java.template
 */

package c41.lambda.action;

@FunctionalInterface
public interface IFloatAction extends IAction1<Float>{

	public void invoke(float val);
	
	@Override
	public default void invoke(Float val) {
		invoke((float)val);
	}
	
}
