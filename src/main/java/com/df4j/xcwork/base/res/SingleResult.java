package com.df4j.xcwork.base.res;

public class SingleResult<T, N> extends Result<T, N> {

    public SingleResult(N errorCode, String errorMsg) {
        this(errorCode, errorMsg, null);
    }

    public SingleResult(N errorCode, String errorMsg, T result) {
        super(errorCode, errorMsg, result, false, false, 1, 1, 1);
    }
}
