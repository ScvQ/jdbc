package cn.spiderpig.jdbc;

import cn.spiderpig.jdbc.dao.UserDao;
import cn.spiderpig.jdbc.domain.Result;
import cn.spiderpig.jdbc.domain.User;
import junit.framework.TestCase;

public class Test extends TestCase {
	
	//通过id获得一个用户
	public void getOne() {
		Result result = new UserDao().getOne(243);
		System.out.println(result);
	}
	
	//获得所有用户
	public void getAll(){
		Result result = new UserDao().getAll();
		System.out.println(result);
	}
	
	//插入一个用户
	public void saveOne(){
		User user = new User();
		user.setUsername("2333");
		user.setPassword("2333");
		Result result = new UserDao().save(user);
		System.out.println(result);
	}
	
	//修改一个用户(和插入类似)
	
	//删除一个用户
	public void deleteOne(){
		Result result = new UserDao().delete(242);
		System.out.println(result);
	}

}
