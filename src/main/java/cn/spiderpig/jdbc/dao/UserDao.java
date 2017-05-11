package cn.spiderpig.jdbc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cn.spiderpig.jdbc.Test;
import cn.spiderpig.jdbc.domain.DBConfig;
import cn.spiderpig.jdbc.domain.Result;
import cn.spiderpig.jdbc.domain.User;
import cn.spiderpig.jdbc.util.DBConfigUtil;
import cn.spiderpig.jdbc.util.DBUtil;
import cn.spiderpig.jdbc.util.ResultUtil;

public class UserDao {

	// 查一个用户
	public Result<User> getOne(Integer id) {

		Result result = ResultUtil.error(1, "error");
		DBConfig config = DBConfigUtil.getConfig();
		try {
			String sql = " SELECT * FROM user WHERE id = ? ";
			PreparedStatement prepareStatement = DBUtil.getConnection(config).prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			List<User> list = new ArrayList<User>();
			User user = null;
			if (resultSet.next()) {
				while (resultSet.next()) {
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
				}
				result = ResultUtil.success(user);
			}else{
				return result;
			}
		} catch (SQLException e) {
			System.out.println("创建声明失败");
		}
		return result;

	}

	// 查询所有用户
	public Result<List> getAll() {

		Result result = ResultUtil.error(1, "error");
		DBConfig config = DBConfigUtil.getConfig();
		try {
			String sql = " SELECT * FROM user ";
			ResultSet resultSet = DBUtil.getConnection(config).prepareStatement(sql).executeQuery();
			List<User> list = new ArrayList<User>();
			User user = null;
			if(resultSet.next()){
				while (resultSet.next()) {
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					list.add(user);
				}
				result = ResultUtil.success(list);
			}else{
				return result;
			}
		} catch (SQLException e) {
			System.out.println("创建声明失败");
		}
		return result;

	}

	// 增加一个用户
	public Result save(User user) {

		Result result = ResultUtil.error(1, "error");
		DBConfig config = DBConfigUtil.getConfig();
		try {
			String sql = " INSERT INTO user(username,password) VALUES(?,?) ";
			PreparedStatement prepareStatement = DBUtil.getConnection(config).prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			if (prepareStatement.executeUpdate() == 1) {
				result = ResultUtil.success();
			}
		} catch (SQLException e) {
			System.out.println("创建声明失败");
		}
		return result;

	}

	// 修改一个用户
	public Result update(User user){
		//和增加类似
		return null;
	}

	// 删除一个用户
	public Result delete(Integer id){
		
		Result result = ResultUtil.error(1, "error");
		DBConfig config = DBConfigUtil.getConfig();
		try {
			String sql = " DELETE FROM user WHERE id = ? ";
			PreparedStatement prepareStatement = DBUtil.getConnection(config).prepareStatement(sql);
			prepareStatement.setInt(1, id);
			if (prepareStatement.executeUpdate() == 1) {
				result = ResultUtil.success();
			}
		} catch (SQLException e) {
			System.out.println("创建声明失败");
		}
		return result;
		
	}

}
