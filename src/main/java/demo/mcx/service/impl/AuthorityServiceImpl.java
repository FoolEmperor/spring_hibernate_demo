package demo.mcx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.mcx.dao.AuthorityDao;
import demo.mcx.model.AcctAuthority;
import demo.mcx.service.AuthorityService;

/**
 * 创建时间：2015-2-6 下午3:24:16
 * 
 * @author andy
 * @version 2.2 
 * AuthorityService 的实现
 */
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;

	public AcctAuthority load(String id) {
		return authorityDao.load(id);
	}

	
	public AcctAuthority get(String id) {
		return authorityDao.get(id);
	}

	
	public List<AcctAuthority> findAll() {
		return authorityDao.findAll();
	}

	
	public void persist(AcctAuthority entity) {
		authorityDao.persist(entity);
	}

	
	public String save(AcctAuthority entity) {
		return authorityDao.save(entity);
	}

	
	public void saveOrUpdate(AcctAuthority entity) {
		authorityDao.saveOrUpdate(entity);
	}

	
	public void delete(String id) {
		authorityDao.delete(id);
	}

	
	public void flush() {
		authorityDao.flush();
	}

}
