package demo.mcx.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.mcx.dao.RoleDao;
import demo.mcx.model.AcctRole;


@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	
	public AcctRole load(String id) {
		return (AcctRole) this.getCurrentSession().load(AcctRole.class, id);
	}
	
	
	public AcctRole get(String id) {
		return (AcctRole) this.getCurrentSession().get(AcctRole.class, id);
	}

	@SuppressWarnings("unchecked")
	
	public List<AcctRole> findAll() {
		Query query = this.getCurrentSession().createQuery("from AcctRole");
		return query.list();
	}

	
	public void persist(AcctRole entity) {
		this.getCurrentSession().persist(entity);

	}

	
	public String save(AcctRole entity) {
		return (String) this.getCurrentSession().save(entity);
	}

	
	public void saveOrUpdate(AcctRole entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	
	public void delete(String id) {
		AcctRole entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	
	public void flush() {
		this.getCurrentSession().flush();

	}

}
