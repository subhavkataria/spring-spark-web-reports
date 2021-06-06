package com.subhav.configuration;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class ReportsConfiguration {

	
	@Autowired
    private Environment env;

    @Value("${app.name:spring-subhav}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri:local}")
    private String masterUri;

    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setSparkHome(sparkHome)
                .setMaster(masterUri)
                .set("spark.databricks.io.cache.enabled", "true");
                /*.set("spark.mongodb.input.uri", "mongodb://localhost/DB.Collection")		 
        		.set("spark.mongodb.output.uri","mongodb://localhost/DB.Collection");*/
         
        return sparkConf;
    }

    @Bean
    public SparkContext sparkContext() {
        return new SparkContext(sparkConf());
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .sparkContext(sparkContext())
                .appName(appName)
                .getOrCreate();
    }
    
    
    @Bean
    @Profile("cluster")
    public SparkConf sparkConfCluster() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setSparkHome(sparkHome)
                .setMaster(masterUri)
                .set("spark.databricks.io.cache.enabled", "true")
        		.set("hive.exec.dynamic.partition", "nonstrict")
        		.set("spark..sql.catalogImplemantation", "hive");
                /*.set("spark.mongodb.input.uri", "mongodb://localhost/DB.Collection")		 
        		.set("spark.mongodb.output.uri","mongodb://localhost/DB.Collection");*/
        return sparkConf;
    }
    

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}