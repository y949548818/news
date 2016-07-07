package com.news.dao;

import java.util.List;

import com.news.entity.User;

public interface IUserDAO {
	/**
	 * �����û�
	 * @param �û�ʵ��
	 * @return true �ɹ� false ʧ��
	 * @throws Exception
	 */
	public boolean doCreate(User user)throws Exception;
	
	/**
	 * ����id ɾ���û�
	 * @param �û�id
	 * @return true �ɹ� false ʧ��
	 * @throws Exception
	 */
	public boolean doDelete(int id)throws Exception;
	
	
	/**
	 * ���ݹؼ���ģ����ѯ
	 * @param username�ؼ���
	 * @return ��ѯ����<User>����
	 * @throws Exception
	 */
	public List<User> findAll()throws Exception;
	
	/**
	 * ����id ��ѯ�û�
	 * @param userId
	 * @return �û�ʵ��
	 * @throws Exception
	 */
	public User findById(int userId)throws Exception;
	
	/**
	 * ����username ��ѯ�û�
	 * @param username
	 * @return �û�ʵ��
	 * @throws Exception
	 */
	public User findByName(String username)throws Exception;
	
	/**
	 * ����userid �����û�
	 * @param userid
	 * @return true �ɹ� false ʧ��
	 * @throws Exception
	 */
	public boolean setUserLocked(int  userId)throws Exception;
	
	/**
	 * ����userid �����û�
	 * @param userid
	 * @return true �ɹ� false ʧ��
	 * @throws Exception
	 */
	public boolean setUserActive(int  userId)throws Exception;

}
