package com.alastair.jmeter.parser.model;

public class ContentRow {

	private static final String SEPERATOR = ", ";
	private String label;
	private Integer count;
	private Integer average;

	public ContentRow(String label, Integer count, Integer average) {
		this.label = label;
		this.count = count;
		this.average = average;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getAverage() {
		return average;
	}

	public void setAverage(Integer average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return label + SEPERATOR + count + SEPERATOR + average;
	}
}
