package question.question1_99;

import java.util.LinkedList;
import java.util.List;
//我与他的思路基本是一致的，但是他的思路更加清晰简洁，但是耗时多一些。。。我就是想说他太菜
public class Question57_others {
	public List<Interval2> insert(List<Interval2> intervals, Interval2 newInterval) {
	    List<Interval2> result = new LinkedList<Interval2>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
	        result.add(intervals.get(i++));
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval2( // we could mutate newInterval here also
	                Math.min(newInterval.start, intervals.get(i).start),
	                Math.max(newInterval.end, intervals.get(i).end));
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
	}
}
//同一个class就算不是public只要定义了在同一个package都能调用
//Interval在Question57_own已经定义了