package com.news.dao;


import com.news.entity.User;

public interface IAdminDAO {
	/**
	 * ����adminname��ѯ����Ա�û�
	 * @param adminname
	 * @return
	 * @throws Exception
	 */
	public User findByName(String adminname);
	
	/**
	 * ����admin_id��ѯ����Ա�û�
	 * @param adminname
	 * @return
	 * @throws Exception
	 */
	public User findById(int admin_id);
	

}
