/*
 * This file is generated by ITAction.java.template
 */

package c41.lambda.action;

@FunctionalInterface
public interface ICharAction extends IAction1<Character>{

	public void invoke(char val);
	
	@Override
	public default void invoke(Character val) {
		invoke((char)val);
	}
	
}