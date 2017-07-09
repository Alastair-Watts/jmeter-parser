package com.alastair.jmeter.parser.service;

import com.alastair.jmeter.parser.model.TestRecord;

public class LineParser {

	public TestRecord parse(String text) {
		String[] values = text.split(",");
		return new TestRecord(values[2], Integer.valueOf(values[1]));
	}
}
