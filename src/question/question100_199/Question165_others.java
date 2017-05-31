package question.question100_199;

/*
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
//这个题一点意思都没有，“.”不代表小数点，而是各个数的分隔符，然后比较两个数组中的各个数
public class Question165_others {
	public int compareVersion(String version1, String version2) {
		String[] nums1 = version1.split("\\.");
		String[] nums2 = version2.split("\\.");
		for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
			Integer num1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
			Integer num2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
			int compare = num1.compareTo(num2);
			if (compare != 0)
				return compare;
		}
		return 0;
	}
}
