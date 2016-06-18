package demo.mcx.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.mcx.dao.UserDao;
import demo.mcx.model.AcctUser;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public AcctUser hqlQuery(String hql){
		List<AcctUser> acctUsers = this.getCurrentSession().createQuery(hql).list();
		return acctUsers.get(0);
	}
	
	public AcctUser load(String id) {
		// TODO Auto-generated method stub
		return (AcctUser) this.getCurrentSession().load(AcctUser.class, id);
	}

	public AcctUser get(String id) {
		// TODO Auto-generated method stub
		return (AcctUser) this.getCurrentSession().get(AcctUser.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AcctUser> findAll() {
		// TODO Auto-generated method stub
		List<AcctUser> acctUsers = this.getCurrentSession().createQuery("from AcctUser").setCacheable(true).list();
		return acctUsers;
	}

	public void persist(AcctUser entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public String save(AcctUser entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(AcctUser entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		AcctUser entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

}
