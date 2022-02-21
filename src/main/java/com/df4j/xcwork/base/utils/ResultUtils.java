package com.df4j.xcwork.base.utils;

import com.df4j.xcwork.base.res.ResultSpi;
import com.df4j.xcwork.base.res.MultipleResult;
import com.df4j.xcwork.base.res.SingleResult;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.List;

public class ResultUtils {

    private static final String SUCCESS_ERROR_CODE = "0";
    private static final String SUCCESS_ERROR_MSG = "success";

    public static <T, N> ResultSpi<T, N> error(N errorNo, String errorMsg) {
        return newSingleResult(errorNo, errorMsg, null);
    }

    public static <T> ResultSpi<T, String> success() {
        return newSingleResult(SUCCESS_ERROR_CODE, SUCCESS_ERROR_MSG, null);
    }

    public static <T> ResultSpi<T, String> success(T result) {
        if (result != null && result instanceof List) {
            return newMultipleResult(SUCCESS_ERROR_CODE, SUCCESS_ERROR_MSG, (List) result);
        } else {
            return newSingleResult(SUCCESS_ERROR_CODE, SUCCESS_ERROR_MSG, result);
        }
    }

    public static <T> ResultSpi<List<T>, String> success(List<T> result, int total, int pageNum, int pageSize) {
        return newPageResult(null, null, result, total, pageNum, pageSize);
    }


    public static <T, N> ResultSpi<T, N> newSingleResult(N errorCode, String errorMsg, T result) {
        return newSingleResult(SingleResult.class, errorCode, errorMsg, result);
    }

    public static <T, N> ResultSpi<List<T>, N> newMultipleResult(N errorCode, String errorMsg, List<T> result) {
        return newMultipleResult(MultipleResult.class, errorCode, errorMsg, result);
    }

    public static <T, N> ResultSpi<List<T>, N> newPageResult(N errorCode, String errorMsg, List<T> result,
                                                                  int total, int pageNum, int pageSize) {
        return newPageResult(errorCode, errorMsg, result, total, pageNum, pageSize);
    }

    public static <T, N> ResultSpi<T, N> newResult(Class<? extends ResultSpi> resultClass, N errorCode, String errorMsg, T result,
                                                        boolean multiple, boolean page, int total, int pageNum, int pageSize) {
        Assert.notNull(resultClass, "resultClass can not be null.");
        ResultSpi<T, N> resultObj = BeanUtils.instantiateClass(resultClass);
        resultObj.setErrorCode(errorCode);
        resultObj.setErrorMsg(errorMsg);
        resultObj.setResult(result);
        resultObj.setMultiple(multiple);
        resultObj.setPage(page);
        resultObj.setTotal(total);
        resultObj.setPageNum(pageNum);
        resultObj.setPageSize(pageSize);
        return resultObj;
    }

    public static <T, N> ResultSpi<T, N> newSingleResult(Class<? extends ResultSpi> resultClass,
                                                              N errorCode, String errorMsg, T result) {
        return newResult(resultClass, errorCode, errorMsg, result, false, false, 1, 1, 1);
    }

    public static <T, N> ResultSpi<List<T>, N> newMultipleResult(Class<? extends ResultSpi> resultClass,
                                                                      N errorCode, String errorMsg, List<T> result) {
        int size = result == null ? 0 : result.size();
        return newResult(resultClass, errorCode, errorMsg, result, true, false, size, 1, size);
    }

    public static <T, N> ResultSpi<List<T>, N> newPageResult(Class<? extends ResultSpi> resultClass, N errorCode,
                                                                  String errorMsg, List<T> result, int total, int pageNum, int pageSize) {
        return newResult(resultClass, errorCode, errorMsg, result, true, true, total, pageNum, pageSize);
    }
}
