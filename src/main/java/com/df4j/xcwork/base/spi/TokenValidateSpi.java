package com.df4j.xcwork.base.spi;


/**
 * 验证token(短信验证码、图形验证码等都属于该类)的接口
 */
public interface TokenValidateSpi {

    /**
     * 设置验证值
     *
     * @param key
     * @param value
     */
    default void setValidateValue(String key, String value) {

    }

    /**
     * 验证token
     *
     * @param key
     * @param token
     * @return
     */
    default boolean verify(String key, String token) {
        return true;
    }
}
