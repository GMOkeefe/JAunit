package com.jaunit.flow;

public class False extends ConditionException {
    public False(String condition) {
        super("'" + condition + "' is false");
    }
}
