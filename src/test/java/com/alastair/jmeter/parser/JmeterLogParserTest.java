package com.alastair.jmeter.parser;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.alastair.jmeter.parser.model.ContentRow;
import com.alastair.jmeter.parser.model.TestRecord;
import com.alastair.jmeter.parser.service.FileParserService;
import com.alastair.jmeter.parser.service.FileReaderService;
import com.alastair.jmeter.parser.service.FileWriterService;

@RunWith(MockitoJUnitRunner.class)
public class JmeterLogParserTest {

	private static final String FILE_NAME = "fileName";
	@Mock
	private FileReaderService fileReaderService;
	@Mock
	private FileParserService fileParserService;
	@Mock
	private FileWriterService fileWriterService;
	@InjectMocks
	private JmeterLogParser parser;

	@Test
	public void parse_CallsAllServices() throws Exception {
		List<TestRecord> fileContents = new ArrayList<>();
		List<ContentRow> result = new ArrayList<>();

		when(fileReaderService.readFrom(FILE_NAME)).thenReturn(fileContents);
		when(fileParserService.parse(fileContents)).thenReturn(result);

		parser.parse(FILE_NAME);

		Mockito.verify(fileWriterService).writeToFile(result);
	}

}
