package com.jaunit.flow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Loop<E> {
    private Iterable<E> iter;

    public Loop(Iterable<E> i) {
        iter = i;
    }

    public static Loop<Integer> fromRange(int start, int end) {
        return new Loop<Integer>(new Range(start, end));
    }

    private <T> List<T> forEach(OperantFunction<E, T> f, Iterator<E> iter)
    {
        List<T> out = new ArrayList<>();

        try
        {
            out.add(f.apply(iter.next()));
            out.addAll(forEach(f, iter));

            return out;
        }
        catch (NoSuchElementException e) {
            return out;
        }
    }

    public <T> List<T> forEach(OperantFunction<E, T> f) {
        List<T> out;
        Iterator<E> values = iter.iterator();

        out = forEach(f, values);

        return out;
    }

    private void forEach(NonOperantFunction<E> f, Iterator<E> iter) throws LoopFinishedException {
        try {
            f.apply(iter.next());
            forEach(f, iter);
        }
        catch (NoSuchElementException e) {
            throw new LoopFinishedException();
        }
    }

    public void forEach(NonOperantFunction<E> f) {
        Iterator<E> values = iter.iterator();

        try {
            forEach(f, values);
        }
        catch (LoopFinishedException e) {}
    }
}
