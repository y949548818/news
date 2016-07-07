package com.news.dao;


import com.news.entity.User;

public interface IAdminDAO {
	/**
	 * 根据adminname查询管理员用户
	 * @param adminname
	 * @return
	 * @throws Exception
	 */
	public User findByName(String adminname);
	
	/**
	 * 根据admin_id查询管理员用户
	 * @param adminname
	 * @return
	 * @throws Exception
	 */
	public User findById(int admin_id);
	

}
