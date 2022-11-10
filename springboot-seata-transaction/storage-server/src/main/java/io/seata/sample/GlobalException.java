package io.seata.sample;


import lombok.extern.slf4j.Slf4j;

/**
 * @author yingyongzhi
 */
@Slf4j
public class GlobalException extends RuntimeException{

    private final int code;

    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        log.info(resultEnum.toString());
        this.code = resultEnum.getCode();
    }

    public GlobalException(int code, String message) {
        super(message);
        log.info("GlobalException.GlobalException.code:{},message:{}",code,message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
