package com.df4j.xcwork.base.res;

public class Result<T, N> extends AbstractResult<T, N> {

    public Result(N errorCode, String errorMsg, T result, boolean multiple,
                  boolean page, int total, int pageNum, int pageSize) {
        super(errorCode, errorMsg, result, multiple, page, total, pageNum, pageSize);
    }

    private N errorCode;
    private String errorMsg;
    private T result;
    private boolean multiple = false;
    private boolean page = false;
    private int total = 1;
    private int pageNum = 1;
    private int pageSize = 1;

    @Override
    public N getErrorCode() {
        return errorCode;
    }

    @Override
    public void setErrorCode(N errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public boolean isMultiple() {
        return multiple;
    }

    @Override
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    @Override
    public boolean isPage() {
        return page;
    }

    @Override
    public void setPage(boolean page) {
        this.page = page;
    }

    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
