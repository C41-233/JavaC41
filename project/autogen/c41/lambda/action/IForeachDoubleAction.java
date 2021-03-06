/*
 * This file is generated by IForeachTAction.java.template
 */

package c41.lambda.action;

@FunctionalInterface
public interface IForeachDoubleAction extends IForeachAction<Double>{

	public void invoke(double ch, int i);
	
	@Override
	public default void invoke(Double ch, int i) {
		invoke((double)ch, i);
	}
	
}
