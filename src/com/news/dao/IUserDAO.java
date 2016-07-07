package com.news.dao;

import java.util.List;

import com.news.entity.User;

public interface IUserDAO {
	/**
	 * 创建用户
	 * @param 用户实例
	 * @return true 成功 false 失败
	 * @throws Exception
	 */
	public boolean doCreate(User user)throws Exception;
	
	/**
	 * 根据id 删除用户
	 * @param 用户id
	 * @return true 成功 false 失败
	 * @throws Exception
	 */
	public boolean doDelete(int id)throws Exception;
	
	
	/**
	 * 根据关键字模糊查询
	 * @param username关键字
	 * @return 查询集合<User>类型
	 * @throws Exception
	 */
	public List<User> findAll()throws Exception;
	
	/**
	 * 根据id 查询用户
	 * @param userId
	 * @return 用户实例
	 * @throws Exception
	 */
	public User findById(int userId)throws Exception;
	
	/**
	 * 根据username 查询用户
	 * @param username
	 * @return 用户实例
	 * @throws Exception
	 */
	public User findByName(String username)throws Exception;
	
	/**
	 * 根据userid 锁定用户
	 * @param userid
	 * @return true 成功 false 失败
	 * @throws Exception
	 */
	public boolean setUserLocked(int  userId)throws Exception;
	
	/**
	 * 根据userid 激活用户
	 * @param userid
	 * @return true 成功 false 失败
	 * @throws Exception
	 */
	public boolean setUserActive(int  userId)throws Exception;

}
