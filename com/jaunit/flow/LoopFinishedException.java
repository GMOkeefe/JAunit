package com.jaunit.flow;

public class LoopFinishedException extends Exception {
    public LoopFinishedException() {
        super("Loop complete");
    }
}
