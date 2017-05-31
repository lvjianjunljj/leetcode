package question.question200_299;
//网上给的binary search的做法。耗时确实要短一些（因为已经排好序了，其实）
public class Question275_others {
	public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (citations[mid] == len - mid)
                return len - mid;
            else if (citations[mid] < len - mid)
                lo = mid + 1;
            else 
                hi = mid - 1;
        }
        //最后这个返回值你要想清楚
        return len - lo;
    }
}
