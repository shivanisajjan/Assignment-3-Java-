package com.stackroute.datamunger.query;

import java.util.Arrays;

public class Header {

	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the headers.
	 */
	String[] fileds;

	public void setFileds(String[] fileds) {
		this.fileds = fileds;
	}

	public String[] getHeaders() {
		return this.fileds;
	}

	@Override
	public String toString() {
		return "Header{" +
				"fileds=" + Arrays.toString(fileds) +
				'}';
	}
}
