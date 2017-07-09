package com.alastair.jmeter.parser;

import com.alastair.jmeter.parser.service.FileParserService;
import com.alastair.jmeter.parser.service.FileReaderService;
import com.alastair.jmeter.parser.service.FileWriterService;
import com.alastair.jmeter.parser.service.LineParser;

public class App {
	public static void main(String[] args) throws Exception {
		new JmeterLogParser(new FileReaderService(new LineParser()), new FileParserService(), new FileWriterService())
				.parse("Full.log");
	}
}
