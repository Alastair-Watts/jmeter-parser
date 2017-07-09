package com.alastair.jmeter.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.alastair.jmeter.parser.model.ContentRow;
import com.alastair.jmeter.parser.model.TestRecord;
import com.alastair.jmeter.parser.service.FileParserService;
import com.alastair.jmeter.parser.service.FileReaderService;
import com.alastair.jmeter.parser.service.FileWriterService;

public class JmeterLogParser {

	private FileReaderService fileReaderService;
	private FileParserService fileParserService;
	private FileWriterService fileWriterService;

	public JmeterLogParser(FileReaderService fileReaderService, FileParserService fileParserService,
			FileWriterService fileWriterService) {
		this.fileReaderService = fileReaderService;
		this.fileParserService = fileParserService;
		this.fileWriterService = fileWriterService;
	}

	public void parse(String fileName) throws IOException, URISyntaxException {
		List<TestRecord> fileContents = fileReaderService.readFrom(fileName);
		List<ContentRow> rowContents = fileParserService.parse(fileContents);
		fileWriterService.writeToFile(rowContents);
	}

}
