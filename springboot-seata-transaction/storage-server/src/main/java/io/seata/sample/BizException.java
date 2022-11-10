package io.seata.sample;


import org.apache.commons.lang.StringUtils;

/**
 * @author yingyongzhi
 */
public class BizException extends GlobalException {

    private static final long serialVersionUID = -7219505447612569684L;

    public BizException(String message) {
        this(message, ResultEnum.DEFAULT_ERROR_CODE.getCode());
    }

    public BizException(String message, Integer code) {
        super(code, message);
    }

    public static void isTrue(boolean expression, String message) {
        if (expression) {
            throw new BizException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new BizException(message);
        }
    }

    public static void isNull(Object obj) {
        isNull(obj, "参数不能为空");
    }

    public static void isBlank(String text, String message) {
        if (StringUtils.isBlank(text)) {
            throw new BizException(message);
        }
    }

    public static void isBlank(String text) {
        isBlank(text, "参数不能为空");
    }
}
