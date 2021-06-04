package com.jaunit.flow;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator implements Iterator<Integer> {
    private int end;
    private int current;

    public RangeIterator(int start, int end) {
        this.end = end;
        this.current = start;
    }

    @Override
    public boolean hasNext() {
        return current < end;
    }

    @Override
    public Integer next() {
        try {
            Check.isTrue(hasNext());
            throw new IllegalStateException();
        }
        catch (True e) {
            return Integer.valueOf(current++);
        }
        catch (False e) {
            throw new NoSuchElementException();
        }
    }
}
