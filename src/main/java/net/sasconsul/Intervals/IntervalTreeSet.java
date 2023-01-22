package net.sasconsul.Intervals;

import java.util.Collection;
import java.util.TreeSet;

public class IntervalTreeSet extends TreeSet<Interval> {
    @Override
    public boolean add(Interval interval) {
        return super.add(interval);
    }

    @Override
    public boolean addAll(Collection<? extends Interval> c) {
        return super.addAll(c);
    }
}
