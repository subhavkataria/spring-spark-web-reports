package com.subhav.service.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import com.subhav.service.ApiReader;

@Service
public class ApiReaderServiceImpl implements ApiReader {
	
	private final SparkSession sparkSession;
	
	public ApiReaderServiceImpl(SparkSession sparkSession){
		this.sparkSession = sparkSession;
		
	}
	
	public Dataset<Row> readSourceFile(String filePath){
		Dataset<Row> dataSet = sparkSession.read().option("header","true").csv(filePath);
		dataSet.show();
		return dataSet;
		
	}

}
