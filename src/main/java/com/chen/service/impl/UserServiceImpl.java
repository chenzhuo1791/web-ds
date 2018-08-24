package com.chen.service.impl;

import com.chen.enums.DataSources;
import com.chen.km.dao.UserMapper;
import com.chen.kmBase.dao.UserBaseMapper;
import com.chen.service.UserService;
import com.chen.util.DataSourceSwitch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**	Created by chenzhuo_m on 2018/8/24. **/
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserBaseMapper userBaseMapper ;

	@Autowired
	private UserMapper userMapper ;


	@Override
	public void userNumberInBases() {
		DataSourceSwitch.setDataSource(DataSources.SLAVE);
		Integer number = userBaseMapper.countUserBase();
		logger.info(" $$  km_base-t_user-number : " + number);
		DataSourceSwitch.resetDataSource();
		number = userMapper.countUser();
		logger.info(" $$  km-t_user_info-number : " + number);
	}

}
