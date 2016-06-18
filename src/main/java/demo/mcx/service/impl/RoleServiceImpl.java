package demo.mcx.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.mcx.dao.RoleDao;
import demo.mcx.model.AcctRole;
import demo.mcx.service.RoleService;

/**
 * 创建时间：2015-2-6 下午3:24:16
 * 
 * @author andy
 * @version 2.2 UserService 的实现
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	
	public AcctRole load(String id) {
		return roleDao.load(id);
	}

	
	public AcctRole get(String id) {
		return roleDao.get(id);
	}

	
	public List<AcctRole> findAll() {
		return roleDao.findAll();
	}

	
	public void persist(AcctRole entity) {
		roleDao.persist(entity);
	}

	
	public String save(AcctRole entity) {
		return roleDao.save(entity);
	}

	
	public void saveOrUpdate(AcctRole entity) {
		roleDao.saveOrUpdate(entity);
	}

	
	public void delete(String id) {
		roleDao.delete(id);
	}

	
	public void flush() {
		roleDao.flush();
	}

}
