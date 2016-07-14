package mn.problem2;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author niemar
 *
 */
public class PlotsReader {
	public Scanner sc;
	
	public PlotsReader(InputStream inputStream) {
		if(inputStream == null) {
			throw new IllegalArgumentException("Input stream cannot be null !");
		}
		sc = new Scanner(inputStream);
	}
	
	public int[] read() {
		int length = sc.nextInt();
		if(length < 0)
			return null;
		int [] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		return array;
	}
}
