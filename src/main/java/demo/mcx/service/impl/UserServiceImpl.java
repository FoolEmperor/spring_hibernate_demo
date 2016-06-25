package demo.mcx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.mcx.dao.UserDao;
import demo.mcx.model.AcctUser;
import demo.mcx.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	public AcctUser get(String id){
		return userDao.get(id);
	}
	
	public AcctUser load(String id){
		return userDao.load(id);
	}
	
	public List<AcctUser> findAll(){
		return userDao.findAll();
	}
	
	public AcctUser power(String id){
		String hql ="select user from AcctUser user inner join user.acctRoles"
				+ " where user.id='"+id+"'";
		AcctUser user=userDao.hqlQuery(hql);
		return user;
	}

	public String save(AcctUser acctUser) {
		// TODO Auto-generated method stub
		return userDao.save(acctUser);
	}
}
