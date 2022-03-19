package com.df4j.xcwork.base.exception;

import com.df4j.xcwork.base.constants.ErrorCode;

/**
 * 业务异常
 */
public class BizException extends XcworkException {

    // 异常代码
    private String errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.name());
        this.errorCode = String.valueOf(errorCode.getErrorNo());
    }

    public BizException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = String.valueOf(errorCode.getErrorNo());
    }

    public BizException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BizException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BizException(String errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public static BizException pack(String errorCode, String msg) {
        return new BizException(errorCode, msg);
    }

    public static BizException pack(ErrorCode errorCode, String msg) {
        return new BizException(errorCode, msg);
    }

    public static BizException pack(String errorCode, String msg, Throwable cause) {
        return new BizException(errorCode, msg, cause);
    }

    public static BizException pack(ErrorCode errorCode, String msg, Throwable cause) {
        return new BizException(String.valueOf(errorCode.getErrorNo()), msg, cause);
    }
}
