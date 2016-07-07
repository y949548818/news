package com.news.dao.proxy;

import java.sql.SQLException;
import java.util.List;

import com.news.dao.IUserDAO;
import com.news.dao.impl.UserDAOImp1;
import com.news.entity.User;
import com.news.utils.Utils;

public class IUserDAOProxy implements IUserDAO {
	private Utils dbc = null;
	private IUserDAO dao = null;

	public IUserDAOProxy(){
		this.dbc = new Utils();
		this.dao = new UserDAOImp1(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(User user)  {
		boolean b = false;
		try {
			if (this.dao.findByName(user.getUsername()) == null) {
				System.out.println(user.toString()+"--");
				b = dao.doCreate(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return b;
	}

	@Override
	public boolean doDelete(int id)  {
		boolean b = false;
		try {
			b = dao.doDelete(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public List<User> findAll()  {
		List<User> all = null;
		try {
			all = dao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return all;
	}

	@Override
	public User findById(int userId) {
		User u1 = null;
		try {
			u1 = dao.findById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u1;
	}

	@Override
	public User findByName(String username) {
		User u1 = null;
		try {
			u1 = dao.findByName(username);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u1;
	}

	@Override
	public boolean setUserActive(int userId) {
		boolean b = false;
		try {
			b = dao.setUserActive(userId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public boolean setUserLocked(int userId)  {
		boolean b = false;
		try {
			b = dao.setUserLocked(userId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				dbc.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

}
