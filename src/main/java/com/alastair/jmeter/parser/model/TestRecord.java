package com.alastair.jmeter.parser.model;

public class TestRecord {

	private final String testName;
	private final Integer elapsed;

	public TestRecord(String testName, Integer elapsed) {
		this.testName = testName;
		this.elapsed = elapsed;
	}

	public String getTestName() {
		return testName;
	}

	public Integer getElapsed() {
		return elapsed;
	}

}
