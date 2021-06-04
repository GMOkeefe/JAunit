package com.jaunit.flow;

public class True extends ConditionException {
    public True(String condition) {
        super("'" + condition + "' is true");
    }
}
