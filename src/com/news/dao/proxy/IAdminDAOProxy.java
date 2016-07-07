package com.news.dao.proxy;

import java.sql.SQLException;

import com.news.dao.IAdminDAO;
import com.news.dao.impl.AdminDAOimp1;
import com.news.dao.impl.UserDAOImp1;
import com.news.entity.User;
import com.news.utils.Utils;

public class IAdminDAOProxy implements IAdminDAO{

	private Utils dbc=null;
	private IAdminDAO dao=null;
	
	public IAdminDAOProxy(){
		this.dbc = new Utils();
		this.dao = new AdminDAOimp1(this.dbc.getConnection());
	}
	
	@Override
	public User findByName(String adminname) {
		User u1=null;
		u1=dao.findByName(adminname);
		try {
			dbc.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public User findById(int admin_id) {
		User u1=null;
		u1=dao.findById(admin_id);
		try {
			dbc.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
	}

}
