package com.df4j.xcwork.base.uid;

import java.util.UUID;

/**
 * 默认的UniqueId生成器
 */
public class DefaultUidGenerator implements UidGenerator<String> {
    @Override
    public String generator(Object... args) {
        return UUID.randomUUID().toString();
    }
}
