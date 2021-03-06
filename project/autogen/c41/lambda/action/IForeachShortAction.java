/*
 * This file is generated by IForeachTAction.java.template
 */

package c41.lambda.action;

@FunctionalInterface
public interface IForeachShortAction extends IForeachAction<Short>{

	public void invoke(short ch, int i);
	
	@Override
	public default void invoke(Short ch, int i) {
		invoke((short)ch, i);
	}
	
}
