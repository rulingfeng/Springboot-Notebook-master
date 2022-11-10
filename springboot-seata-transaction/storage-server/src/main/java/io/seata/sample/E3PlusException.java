package io.seata.sample;

/**
 * @author jinguo
 */
public class E3PlusException extends GlobalException {

	private static final long serialVersionUID = -7219505447612569684L;

	public E3PlusException(String message) {
		super(999999, message);
	}

	public static void isTrue(boolean expression, String message) {
		if (expression) {
			throw new E3PlusException(message);
		}
	}

}
