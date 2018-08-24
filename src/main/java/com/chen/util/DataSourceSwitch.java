package com.chen.util;

import com.chen.enums.DataSources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**	Created by chenzhuo_m on 2018/8/24. **/

public class DataSourceSwitch {

	private static final ThreadLocal<DataSources> dataSourceTypes = new ThreadLocal<DataSources>(){
		@Override
		protected DataSources initialValue(){
			return DataSources.MASTER;
		}
	};

	private static final Logger logger = LoggerFactory.getLogger(DataSourceSwitch.class);

	public static DataSources getDataSource(){
		return dataSourceTypes.get();
	}

	public static void setDataSource(DataSources dataSourceType){
		logger.info("## MASTER-km ---> SLAVE-km_base");
		dataSourceTypes.set(dataSourceType);
	}

	public static void resetDataSource(){
		logger.info("SLAVE-km_base ---> MASTER-km ## ");
		dataSourceTypes.set(DataSources.MASTER);
	}


}
