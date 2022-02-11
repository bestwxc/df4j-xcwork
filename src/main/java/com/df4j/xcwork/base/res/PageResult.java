package com.df4j.xcwork.base.res;

import java.util.List;

public class PageResult<T, N> extends MultipleResult<T, N> {
    public PageResult(N errorCode, String errorMsg, List<T> result, int total, int pageNum, int pageSize) {
        super(errorCode, errorMsg, result, true, total, pageNum, pageSize);
    }
}
