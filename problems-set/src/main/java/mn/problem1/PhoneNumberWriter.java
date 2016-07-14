package mn.problem1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niemar
 *
 */
public class PhoneNumberWriter {
	private static Map<Character, List<Character>> MAPPING = createMapping();
	
	private String phoneNumber;

	public PhoneNumberWriter(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void write() {
		if(!isCorrectNumberFormat()) {
			System.out.print("ERROR");
			return;
		}
		write(phoneNumber, 0);
	}
	
	private boolean isCorrectNumberFormat() {
		return hasCorrectLength() && hasOnlyDigits();
	}

	private boolean hasCorrectLength() {
		return phoneNumber != null && phoneNumber.length() == 9;
	}
	
	private boolean hasOnlyDigits() {
		char[] chars = phoneNumber.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(!isDigit(chars[i])) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isDigit(char c) {
		int numericValue = Character.getNumericValue(c);
		return numericValue >= 0 && numericValue <= 9;
	}

	private void write(String number, int index) {
		if(index == number.length()) {
			System.out.println(number);
			return;
		}
		List<Character> letters = MAPPING.get(number.charAt(index));
		if(!letters.isEmpty()) {
			for (Character letter : letters) {
				write(replaceDigitWithLetter(number, index, letter), index + 1);
			}
		}
		else {
			write(number, index + 1);
		}
	}

	private String replaceDigitWithLetter(String number, int digitIndex, char letter) {
		return number.substring(0, digitIndex) + letter + number.substring(digitIndex + 1);
	}

	private static Map<Character, List<Character>> createMapping() {
		Map<Character, List<Character>> mapping = new HashMap<Character, List<Character>>();
		mapping.put('0', Collections.emptyList());
		mapping.put('1', Collections.emptyList());
		mapping.put('2', Arrays.asList(new Character[] { 'A', 'B', 'C' }));
		mapping.put('3', Arrays.asList(new Character[] { 'D', 'E', 'F' }));
		mapping.put('4', Arrays.asList(new Character[] { 'G', 'H', 'I' }));
		mapping.put('5', Arrays.asList(new Character[] { 'J', 'K', 'L' }));
		mapping.put('6', Arrays.asList(new Character[] { 'M', 'N', 'O' }));
		mapping.put('7', Arrays.asList(new Character[] { 'P', 'R', 'S' }));
		mapping.put('8', Arrays.asList(new Character[] { 'T', 'U', 'V' }));
		mapping.put('9', Arrays.asList(new Character[] { 'W', 'X', 'Y' }));
		return mapping;
	}

}
