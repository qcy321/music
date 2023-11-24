package com.mu.exception;

import com.mu.responseUtil.ResultCodeEnum;
import lombok.Data;

@Data
public class BizException extends RuntimeException {

    private Integer code;
    /**
     * 错误信息
     */
    private String message;

    public BizException() {
        super();
    }

    public BizException(ResultCodeEnum resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BizException(ResultCodeEnum resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BizException(String message) {
        super(message);
        this.setCode(-1);
        this.message = message;
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
