package com.jaunit.flow;

public abstract class ConditionException extends Exception {
    public ConditionException(String condition) {
        super("Conditional result: " + condition);
    }
}