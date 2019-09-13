package com.stackroute.datamunger.reader;

import java.io.*;
import java.util.Arrays;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	private String Filename;
	private Header h;
	// Parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		BufferedReader Buff = new BufferedReader(new FileReader(fileName));
		this.Filename=fileName;
		this.h = new Header();
	}
	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 * Note: Return type of the method will be Header
	 */

	@Override
	public Header getHeader() throws IOException {
		//Header h=new Header();
		BufferedReader Buff = new BufferedReader(new FileReader(this.Filename));
		String text = Buff.readLine();
		String[] columns=text.split(",");
		h.setFileds(columns);
		// read the first line
		// populate the header object with the String array containing the header names
		return h;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */
	
	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. 
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		DataTypeDefinitions data=new DataTypeDefinitions();
		BufferedReader Buff = new BufferedReader(new FileReader(this.Filename));
		String text = Buff.readLine();
		String[] column1 = text.split(",");
		h.setFileds(column1);
		String[] dataType = {""};
		String[] s3 = h.getHeaders();
		String[] columns;
		if ((text = Buff.readLine()) != null) {
			columns = text.split(",", s3.length);
			dataType = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				try {
					int t = Integer.parseInt(columns[i]);
					Object o = t;
					String s = o.getClass().getName();
					dataType[i] = s;
				} catch (NumberFormatException e) {
					String s1 = columns[i].getClass().getName();
					dataType[i] = s1;
				}
			}
		}
		data.setDatatype(dataType);
		return data;
	}
}
