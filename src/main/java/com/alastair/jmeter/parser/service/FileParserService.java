package com.alastair.jmeter.parser.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.alastair.jmeter.parser.model.ContentRow;
import com.alastair.jmeter.parser.model.TestCount;
import com.alastair.jmeter.parser.model.TestRecord;

public class FileParserService {

	public List<ContentRow> parse(List<TestRecord> fileContents) {
		Set<String> labels = new HashSet<>();
		Map<String, TestCount> content = new HashMap<>();
		for (TestRecord testRecord : fileContents) {
			if (labels.add(testRecord.getTestName())) {
				content.put(testRecord.getTestName(), new TestCount(1, testRecord.getElapsed()));
			} else {
				content.get(testRecord.getTestName()).addTestTime(testRecord.getElapsed());
			}
		}
		return content.entrySet().stream().map(entry -> new ContentRow(entry.getKey(), entry.getValue().getCount(),
				entry.getValue().getTotal() / entry.getValue().getCount())).collect(Collectors.toList());
	}

}
