package com.subhav.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ApiReader {
	
	public Dataset<Row> readSourceFile(String filePath);

}
