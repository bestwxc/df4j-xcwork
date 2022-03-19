package com.df4j.xcwork.base.uid;

/**
 * UniqueId generator
 *
 * @param <T>
 */
public interface UidGenerator<T> {
    /**
     * 生成uid
     *
     * @param args
     * @return
     */
    T generator(Object... args);
}
