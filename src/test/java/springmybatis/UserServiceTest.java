package springmybatis;


import mybatis.UserMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserMapper userDao = (UserMapper)context.getBean("userMapper");
		System.out.println(userDao.getUser(2));
	}

}
