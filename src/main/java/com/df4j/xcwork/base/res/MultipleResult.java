package com.df4j.xcwork.base.res;

import java.util.List;

public class MultipleResult<T, N> extends Result<List<T>, N> {

    public MultipleResult(N errorCode, String errorMsg, List<T> result) {
        this(errorCode, errorMsg, result, false, result == null ? 0 : result.size(), 1, result == null ? 0 : result.size());
    }

    public MultipleResult(N errorCode, String errorMsg, List<T> result, boolean page, int total, int pageNum, int pageSize) {
        super(errorCode, errorMsg, result, true, page, total, pageNum, pageSize);
    }

}
