package com.alastair.jmeter.parser.model;

public class TestCount {

	private Integer count;
	private Integer total;

	public TestCount(Integer count, Integer total) {
		this.count = count;
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void addTestTime(Integer time) {
		count++;
		total = total + time;
	}
}
