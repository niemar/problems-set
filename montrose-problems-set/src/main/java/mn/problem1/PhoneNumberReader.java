package mn.problem1;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author niemar
 *
 */
public class PhoneNumberReader {
	
	public Scanner sc;
	
	public PhoneNumberReader(InputStream inputStream) {
		if(inputStream == null) {
			throw new IllegalArgumentException("Input stream cannot be null !");
		}
		sc = new Scanner(inputStream);
	}
	
	public String read() {
		String line = sc.nextLine();
		return line;
	}


}
