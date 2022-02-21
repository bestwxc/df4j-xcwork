package com.df4j.xcwork.base.res;

/**
 * 结果集包装类接口
 *
 * @param <T> 结果集类型
 * @param <N> 结果代码类型
 */
public interface ResultSpi<T, N> {

    /**
     * 设置结果代码
     *
     * @param errorCode 结果代码
     */
    void setErrorCode(N errorCode);

    /**
     * 获取结果代码
     *
     * @return 结果代码
     */
    N getErrorCode();

    /**
     * 设置错误信息
     *
     * @param errorMsg 错误信息
     */
    void setErrorMsg(String errorMsg);

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getErrorMsg();

    /**
     * 设置结果集
     *
     * @param result 结果集
     */
    void setResult(T result);

    /**
     * 获取结果集
     *
     * @return 结果集
     */
    T getResult();

    /**
     * 设置是否为多结果集
     *
     * @param multiple 是否为多结果集
     */
    default void setMultiple(boolean multiple) {

    }

    /**
     * 获取是否为多结果集
     *
     * @return 是否为多结果集
     */
    default boolean isMultiple() {
        return false;
    }

    /**
     * 设置结果集是否为分页结果集
     *
     * @param page 结果集是否为分页结果集
     */
    default void setPage(boolean page) {

    }

    /**
     * 获取结果集是否为分页结果集
     *
     * @return 结果集是否为分页结果集
     */
    default boolean isPage() {
        return false;
    }

    /**
     * 设置分页结果集总数
     *
     * @param total 分页结果集总数
     */
    default void setTotal(int total) {

    }

    /**
     * 获取分页结果集总数
     *
     * @return 分页结果集总数
     */
    default int getTotal() {
        return 1;
    }

    /**
     * 设置当前分页结果集页数
     *
     * @param pageNum 分页结果集当前页数
     */
    default void setPageNum(int pageNum) {

    }

    /**
     * 获取分页结果集当前页数
     *
     * @return 分页结果集当前页数
     */
    default int getPageNum() {
        return 1;
    }

    /**
     * 设置分页结果集分页数量
     *
     * @param pageSize 分页结果集分页数量
     */
    default void setPageSize(int pageSize) {

    }

    /**
     * 获取 分页结果集分页数量
     *
     * @return 分页结果集分页数量
     */
    default int getPageSize() {
        return 1;
    }

}
