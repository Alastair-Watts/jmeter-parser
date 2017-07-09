package com.alastair.jmeter.parser.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.alastair.jmeter.parser.model.TestRecord;

public class FileReaderServiceTest {

	private LineParser parser = new LineParser();
	private FileReaderService fileReaderService = new FileReaderService(parser);

	@Test
	public void read_MakesEveryLineAfterFirstAString() throws Exception {

		List<TestRecord> listOfFile = fileReaderService.readFrom("smallSample.log");
		TestRecord[] expectedContent = new TestRecord[] { new TestRecord("Home_GotoLoginPage", 646),
				new TestRecord("Home_Login", 1053), new TestRecord("Home_GotoHomePage", 393),
				new TestRecord("MkDt_GotoFXRatePage", 10554), };

		matchRecords(expectedContent, listOfFile.toArray());
	}

	private void matchRecords(TestRecord[] expectedContent, Object[] array) {
		for (int i = 0; i < array.length; i++) {
			TestRecord actual = (TestRecord) array[i];
			assertEquals(expectedContent[i].getElapsed(), actual.getElapsed());
			assertEquals(expectedContent[i].getTestName(), actual.getTestName());
		}
	}
}
