package com.df4j.xcwork.base.res;

import com.df4j.xcwork.base.constants.ErrorCode;

public class SingleResult<T, N> extends Result<T, N> {

    public SingleResult() {
        super(false, false);
    }

    public SingleResult(N errorCode, String errorMsg) {
        this(errorCode, errorMsg, null);
    }

    public SingleResult(N errorCode, String errorMsg, T result) {
        super(errorCode, errorMsg, result, false, false, 1, 1, 1);
    }
}
