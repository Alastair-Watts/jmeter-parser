package com.alastair.jmeter.parser.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alastair.jmeter.parser.model.TestRecord;

public class FileReaderService {

	private LineParser lineParser;

	public FileReaderService(LineParser lineParser) {
		this.lineParser = lineParser;
	}

	public List<TestRecord> readFrom(String fileName) throws IOException, URISyntaxException {
		File file = new File(fileName);
		URI resourceLocation = null;
		if (file.exists()) {
			resourceLocation = file.toURI();
		} else if (ClassLoader.getSystemResource(fileName) != null) {
			resourceLocation = ClassLoader.getSystemResource(fileName).toURI();
		} else {
			throw new IllegalStateException("cannot find file");
		}

		try (Stream<String> allLines = Files.lines(Paths.get(resourceLocation))) {
			return allLines.skip(1L).map(lineParser::parse).collect(Collectors.toList());
		}
	}
}
