package io.munkush.app.mapper;

public interface Mapper<F, T> {
    T map(F addSource);
}
