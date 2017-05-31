package question.question300_399;

/*
 * Design a simplified version of Twitter where users can post tweets, 
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
 * Your design should support the following methods:
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. 
 * Each item in the news feed must be posted by users who the user followed or by the user herself. 
 * Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//用一个二维数组存储userId,tweetId，getNewsFeed方法中倒序查找以找到最近的发布tweet，耗时还是很高的
//网上给的思路是封装两个类用于维护user和tweet然后将每个user的tweet封装成类似于链表的结构
//（tweet中带一个next变量，同时还有一个time变量存储发表时间）——这里就不写了
public class Question355_own {
	HashMap<Integer, HashSet<Integer>> follow;
	List[] lists;

	/** Initialize your data structure here. */
	public Question355_own() {
		follow = new HashMap<Integer, HashSet<Integer>>();
		lists = new ArrayList[2];
		lists[0] = new ArrayList<Integer>();
		lists[1] = new ArrayList<Integer>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		lists[0].add(userId);
		lists[1].add(tweetId);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new ArrayList<Integer>();
		int k = lists[0].size() - 1;
		while (k >= 0 && res.size() < 10) {
			if ((Integer) lists[0].get(k) == userId
					|| (follow.containsKey(userId) && follow.get(userId)
							.contains(lists[0].get(k))))
				res.add((Integer) lists[1].get(k));
			k--;
		}
		return res;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (follow.containsKey(followerId))
			follow.get(followerId).add(followeeId);
		else {
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(followeeId);
			follow.put(followerId, set);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (follow.containsKey(followerId))
			follow.get(followerId).remove(followeeId);
	}
}
/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
