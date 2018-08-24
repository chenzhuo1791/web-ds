package com.chen.testService;

import com.chen.enums.DataSources;
import com.chen.km.dao.UserMapper;
import com.chen.kmBase.dao.UserBaseMapper;
import com.chen.service.UserService;
import com.chen.test.SpringTest;
import com.chen.util.DataSourceSwitch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Created by chenzhuo_m on 2018/8/24.**/

public class TestAUserService extends SpringTest {

	@Autowired
	private UserService userService ;

	@Autowired
	private UserBaseMapper userBaseMapper ;

	@Autowired
	private UserMapper userMapper ;

//  4	 ===========================================================================================
	@Test
	public void testD() throws Exception {

		System.out.println("\n\n");
	}

//  3	 ===========================================================================================
	@Test
	public void testCuserNumber() throws Exception {
		userService.userNumberInBases();
		System.out.println("\n\n");
	}

//  2	 ===========================================================================================
	@Test
	public void testBcountUserBase() throws Exception {
		DataSourceSwitch.setDataSource(DataSources.SLAVE);
		Integer number = userBaseMapper.countUserBase() ;
		System.out.println("  ##  number : " + number);
		System.out.println("\n\n");
	}

//  1	 ===========================================================================================
	@Test
	public void testAcounUser() throws Exception {
		Integer number = userMapper.countUser() ;
		System.out.println("  ##  number : " + number);
		System.out.println("\n\n");
	}


//  0	 ===========================================================================================
	@Test
	public void test() throws Exception {
		System.out.println();
	}

//  ===========================================================================================
	@Test
	public void testInit() throws Exception {
		System.out.println("## userMapper : " + userMapper);
		System.out.println("\n\n");
	}



}
