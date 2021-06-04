package com.jaunit.flow;

public interface OperantFunction<T, R> {
    R apply(T in);
}
