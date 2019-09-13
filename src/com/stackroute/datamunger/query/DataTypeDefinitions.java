package com.stackroute.datamunger.query;

import java.util.Arrays;

public class DataTypeDefinitions {
	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */
	private String[] datatype;
	public void setDatatype(String[] datatype) {
		this.datatype = datatype;
	}

	@Override
	public String toString() {
		return "DataTypeDefinitions{" +
				"datatype=" + Arrays.toString(datatype) +
				'}';
	}

	public String[] getDataTypes() {
		return datatype;
	}
}
