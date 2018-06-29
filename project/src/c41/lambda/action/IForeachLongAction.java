/*
 * This file is generated by IForeachTAction.java.template
 */

package c41.lambda.action;

@FunctionalInterface
public interface IForeachLongAction extends IForeachAction<Long>{

	public void invoke(long ch, int i);
	
	@Override
	public default void invoke(Long ch, int i) {
		invoke((long)ch, i);
	}
	
}
