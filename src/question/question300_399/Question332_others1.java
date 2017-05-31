package question.question300_399;

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//思路和我一样，但是需要有一个addList方法才能真正实现这道题，我还是没有想到（带环的DFS的一种做法）
public class Question332_others1 {
	public List<String> findItinerary(String[][] tickets) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < tickets.length; i++) {
			if (map.containsKey(tickets[i][0]))
				addList(tickets[i][1], map.get(tickets[i][0]));
			else {
				map.put(tickets[i][0], new ArrayList<String>());
				map.get(tickets[i][0]).add(tickets[i][1]);
			}
		}
		int sum = tickets.length + 1;
		List<String> res = new ArrayList<String>();
		res.add("JFK");
		dfs(map, res, "JFK", 1, sum);
		return res;
	}

	private boolean dfs(HashMap<String, ArrayList<String>> map,
			List<String> res, String city, int n, int sum) {
		if (n == sum)
			return true;
		if (!map.containsKey(city) || map.get(city).size() == 0)
			return false;
		List<String> array = map.get(city);
		for (int i = 0; i < array.size(); i++) {
			String next = array.remove(i);
			res.add(next);
			if (dfs(map, res, next, n + 1, sum))
				return true;
			res.remove(res.size() - 1);
			//这里完全可以用这句话代替
//			array.add(i, next);
			addList(next, array);
		}
		return false;
	}

	private void addList(String str, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (str.compareTo(list.get(i)) <= 0) {
				list.add(i, str);
				return;
			}
		}
		list.add(str);
	}
}
