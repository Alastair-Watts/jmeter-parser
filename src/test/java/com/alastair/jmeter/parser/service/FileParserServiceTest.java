package com.alastair.jmeter.parser.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alastair.jmeter.parser.model.ContentRow;
import com.alastair.jmeter.parser.model.TestRecord;

public class FileParserServiceTest {

	private FileParserService fileParserService = new FileParserService();

	@Test
	public void parse_TransfromsRecordsIntoContent() {
		String testOne = "Home_Login";
		String testTwo = "Home_GotToHome";
		String testThree = "Login_Home";

		List<TestRecord> fileContents = new ArrayList<>();
		fileContents.add(new TestRecord(testOne, 10));
		fileContents.add(new TestRecord(testTwo, 100));
		fileContents.add(new TestRecord(testTwo, 150));
		fileContents.add(new TestRecord(testThree, 5));
		fileContents.add(new TestRecord(testThree, 10));
		fileContents.add(new TestRecord(testThree, 15));
		fileContents.add(new TestRecord(testOne, 20));

		List<ContentRow> parsedResult = fileParserService.parse(fileContents);

		assertEquals(3, parsedResult.size());
		assertTrue(parsedResult.stream().allMatch(row -> {
			String testName = row.getLabel();
			if (testOne.equals(testName)) {
				return 15 == row.getAverage() && 2 == row.getCount();
			}
			if (testTwo.equals(testName)) {
				return 125 == row.getAverage() && 2 == row.getCount();
			}
			if (testThree.equals(testName)) {
				return 10 == row.getAverage() && 3 == row.getCount();
			}
			return false;
		}));
	}

}
