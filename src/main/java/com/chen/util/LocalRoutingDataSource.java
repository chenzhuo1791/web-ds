package com.chen.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**	Created by chenzhuo_m on 2018/8/24. **/

public class LocalRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSwitch.getDataSource();
	}


}
