package net.sasconsul.Intervals;

import java.util.ArrayList;
import java.util.Collections;

public class MinSegments {

    public static int minimumDivision(ArrayList<Interval> intervalArrayList, int k) {
        int ans = -1;

        if (intervalArrayList.size() == 0)
            return -1;
        if (intervalArrayList.size() == 1)
            return -1;

        Collections.sort(intervalArrayList, new IntervalComparator());

        Interval first = intervalArrayList.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Interval> result = new ArrayList<Interval>();



        return ans;
    }

    ArrayList<Interval> connectedSegments(ArrayList<Interval> intervalArrayList) {

        return intervalArrayList;
    }


}
