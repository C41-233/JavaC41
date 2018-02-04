/*
 * This file is generated by ITAction.java.template
 */

package c41.lambda.action;

@FunctionalInterface
public interface IDoubleAction extends IAction1<Double>{

	public void invoke(double val);
	
	@Override
	public default void invoke(Double val) {
		invoke((double)val);
	}
	
}
