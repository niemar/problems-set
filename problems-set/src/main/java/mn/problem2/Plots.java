package mn.problem2;

/**
 * @author niemar
 *
 */
public class Plots {
	
	/**
	 * Implementation based on Maximum subarray problem 
	 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
	 * @param plots plots profitabilities
	 * @return subarray containinig array range and computed profitability
	 */
	public static SubArray computeProfitability(int[] plots) {
		if (isEmpty(plots))
			return null;

		int localSum = plots[0], localFromIndex = 0, localToIndex = 0;
		int maxSum = plots[0], maxFromIndex = 0, maxToIndex = 0;

		for (int i = 1; i < plots.length; i++) {
			if (plots[i] >= localSum + plots[i]) {
				localSum = plots[i];
				localFromIndex = localToIndex = i;
			} else {
				localSum = localSum + plots[i];
				localToIndex = i;
			}
			if (localSum > maxSum || (maxSum == localSum
					&& isLocalSubArrayShorterThanMax(localToIndex - localFromIndex, maxToIndex - maxFromIndex))) {
				maxSum = localSum;
				maxFromIndex = localFromIndex;
				maxToIndex = localToIndex;
			}
		}
		// add one to indexes to keep indexing start with one
		return new SubArray(maxFromIndex + 1, maxToIndex + 1, maxSum);
	}

	private static boolean isLocalSubArrayShorterThanMax(int localSubArrayLength, int maxSubArrayLength) {
		return (localSubArrayLength) < (maxSubArrayLength);
	}

	private static boolean isEmpty(int[] plots) {
		return plots == null || plots.length <= 0;
	}
}
