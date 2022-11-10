package io.seata.sample;

/**
 * @author jinguo
 */
public class PosException extends GlobalException {

	private static final long serialVersionUID = -7219505447612569684L;

	public PosException(String message) {
		super(0, message);
	}

	public static void isTrue(boolean expression, String message) {
		if (expression) {
			throw new PosException(message);
		}
	}

}
