package demo.mcx.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import demo.mcx.dao.AuthorityDao;
import demo.mcx.model.AcctAuthority;

/**
 * 创建时间：2015-2-6 下午2:45:14
 * 
 * @author andy
 * @version 2.2
 */
@Repository("authorityDao")
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public AcctAuthority load(String id) {
		return (AcctAuthority) this.getCurrentSession().load(AcctAuthority.class, id);
	}
	
	
	public AcctAuthority get(String id) {
		return (AcctAuthority) this.getCurrentSession().get(AcctAuthority.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AcctAuthority> findAll() {
		Query query = this.getCurrentSession().createQuery("from AcctAuthority ");
		return query.list();
	}

	
	public void persist(AcctAuthority entity) {
		this.getCurrentSession().persist(entity);

	}

	
	public String save(AcctAuthority entity) {
		return (String) this.getCurrentSession().save(entity);
	}

	
	public void saveOrUpdate(AcctAuthority entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	
	public void delete(String id) {
		AcctAuthority entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	
	public void flush() {
		this.getCurrentSession().flush();

	}

}
