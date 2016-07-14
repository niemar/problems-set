package mn.problem2;

/**
 * @author niemar
 *
 */
public class SubArray {
	private int fromIndex;
	private int toIndex;
	private int profitability;
	
	public SubArray(int fromIndex, int toIndex, int profitability) {
		super();
		this.fromIndex = fromIndex;
		this.toIndex = toIndex;
		this.profitability = profitability;
	}

	public int getFromIndex() {
		return fromIndex;
	}

	public int getToIndex() {
		return toIndex;
	}

	public int getProfitability() {
		return profitability;
	}

	@Override
	public String toString() {
		return "" + fromIndex + " " + toIndex + " " + profitability;
	}
	
}
