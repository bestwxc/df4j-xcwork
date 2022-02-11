package com.df4j.xcwork.base.res;

/**
 * 结果集包装类接口
 *
 * @param <T> 结果集类型
 * @param <N> 结果代码类型
 */
public abstract class AbstractResult<T, N> {

    protected AbstractResult() {

    }

    protected AbstractResult(N errorCode, String errorMsg) {
        this.setErrorCode(errorCode);
        this.setErrorMsg(errorMsg);
    }

    protected AbstractResult(N errorCode, String errorMsg, T result, boolean multiple, boolean page, int total, int pageNum, int pageSize) {
        this.setMultiple(multiple);
        this.setPage(page);
        this.setTotal(total);
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
    }

    /**
     * 设置结果代码
     *
     * @param errorCode 结果代码
     */
    public abstract void setErrorCode(N errorCode);

    /**
     * 获取结果代码
     *
     * @return 结果代码
     */
    public abstract N getErrorCode();

    /**
     * 设置错误信息
     *
     * @param errorMsg 错误信息
     */
    public abstract void setErrorMsg(String errorMsg);

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    public abstract String getErrorMsg();

    /**
     * 设置结果集
     *
     * @param result 结果集
     */
    public abstract void setResult(T result);

    /**
     * 获取结果集
     *
     * @return 结果集
     */
    public abstract T getResult();

    /**
     * 设置是否为多结果集
     *
     * @param multiple 是否为多结果集
     */
    public void setMultiple(boolean multiple) {

    }

    /**
     * 获取是否为多结果集
     *
     * @return 是否为多结果集
     */
    public boolean isMultiple() {
        return false;
    }

    /**
     * 设置结果集是否为分页结果集
     *
     * @param page 结果集是否为分页结果集
     */
    public void setPage(boolean page) {

    }

    /**
     * 获取结果集是否为分页结果集
     *
     * @return 结果集是否为分页结果集
     */
    public boolean isPage() {
        return false;
    }

    /**
     * 设置分页结果集总数
     *
     * @param total 分页结果集总数
     */
    public void setTotal(int total) {

    }

    /**
     * 获取分页结果集总数
     *
     * @return 分页结果集总数
     */
    public int getTotal() {
        return 1;
    }

    /**
     * 设置当前分页结果集页数
     *
     * @param pageNum 分页结果集当前页数
     */
    public void setPageNum(int pageNum) {

    }

    /**
     * 获取分页结果集当前页数
     *
     * @return 分页结果集当前页数
     */
    public int getPageNum() {
        return 1;
    }

    /**
     * 设置分页结果集分页数量
     *
     * @param pageSize 分页结果集分页数量
     */
    public void setPageSize(int pageSize) {

    }

    /**
     * 获取 分页结果集分页数量
     *
     * @return 分页结果集分页数量
     */
    public int getPageSize() {
        return 1;
    }

}
