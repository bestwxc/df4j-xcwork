package com.df4j.xcwork.base.exception;

/**
 * 标准异常类型
 */
public class XcworkException extends RuntimeException {

    public XcworkException() {
    }

    public XcworkException(String message) {
        super(message);
    }

    public XcworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public XcworkException(Throwable cause) {
        super(cause);
    }

    public XcworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 重新包装异常
     *
     * @param t
     * @return
     */
    public static XcworkException repack(Throwable t) {
        if (t == null) {
            return new XcworkException("传入的异常为空");
        }
        if (t instanceof XcworkException) {
            return (XcworkException) t;
        } else {
            return new XcworkException(t);
        }
    }

    public static XcworkException pack(String msg) {
        return new XcworkException(msg);
    }

    public static XcworkException repack(Throwable t, String msg) {
        if (t == null) {
            return new XcworkException(msg);
        }
        if (t instanceof XcworkException) {
            return (XcworkException) t;
        } else {
            return new XcworkException(msg, t);
        }
    }
}
