package montrose.problem1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mn.problem1.PhoneNumberWriter;

/**
 * @author niemar
 *
 */
public class PhoneNumberWriterTest {

	private static String ERROR = "ERROR";
	private static String NEW_LINE = System.getProperty("line.separator");
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void printErrorWhenNumberIsNull() {
		String phoneNumber = null;
		
		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
		
		assertEquals(ERROR, outContent.toString());
	}
	
	@Test
	public void printErrorWhenNumberHasIncorrectLength() {
		String phoneNumber = "1234567";
		
		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
		
		assertEquals(ERROR, outContent.toString());
	}
	
	@Test
	public void printErrorWhenNumberContainsNoDigit() {
		String phoneNumber = "12345678a";
		
		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
		
		assertEquals(ERROR, outContent.toString());
	}
	
	@Test
	public void test1() {
		String phoneNumber = "110015010";
		String expectedOutput = "11001J010" + NEW_LINE + 
								"11001K010" + NEW_LINE + 
								"11001L010" + NEW_LINE;
		
		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
		String output = outContent.toString();
		
		assertEquals(expectedOutput, output);
		compareLexicographically(output.split(NEW_LINE));
	}
	
	@Test
	public void test2() {
		String phoneNumber  = "213101011";
		String expectedOutput = "A1D101011" + NEW_LINE + 
								"A1E101011" + NEW_LINE +
								"A1F101011" + NEW_LINE + 
								"B1D101011" + NEW_LINE +
								"B1E101011" + NEW_LINE + 
								"B1F101011" + NEW_LINE + 
								"C1D101011" + NEW_LINE + 
								"C1E101011" + NEW_LINE + 
								"C1F101011" + NEW_LINE;

		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
		String output = outContent.toString();
		
		assertEquals(expectedOutput, output);
		compareLexicographically(output.split(NEW_LINE));
	}
	
	@Test
	public void test3() {
		String phoneNumber  = "023451234";

		PhoneNumberWriter writer = new PhoneNumberWriter(phoneNumber);
		writer.write();
		String output = outContent.toString();
		
		compareLexicographically(output.split(NEW_LINE));
	}

	private void compareLexicographically(String[] numbers) {
		String previous = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			assertTrue(numbers[i].compareTo(previous) > 0);
			previous = numbers[i];
		}
	}

}
