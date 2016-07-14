package mn.problem2;

/**
 * @author niemar
 *
 */
public class Main {
	public static void main(String[] args) {
		PlotsReader reader = new PlotsReader(System.in);
		int plots[] = reader.read();
		SubArray subPlots = Plots.computeProfitability(plots);
		System.out.print(subPlots);
	}

}
