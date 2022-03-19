package com.df4j.xcwork.base.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;

import java.util.stream.Stream;

public class NullObjectProvider<T> implements ObjectProvider<T> {

    @Override
    public T getObject(Object... args) throws BeansException {
        return null;
    }

    @Override
    public T getIfAvailable() throws BeansException {
        return null;
    }

    @Override
    public T getIfUnique() throws BeansException {
        return null;
    }

    @Override
    public T getObject() throws BeansException {
        return null;
    }

    @Override
    public Stream<T> orderedStream() {
        return Stream.empty();
    }
}
