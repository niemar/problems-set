package mn.problem1;

import mn.problem1.PhoneNumberWriter;

/**
 * @author niemar
 *
 */
public class Main {
	public static void main(String[] args) {
		PhoneNumberReader reader = new PhoneNumberReader(System.in);
		String phoneNumber = reader.read();
		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
	}
}
