package demo.mcx.dao;

import java.util.List;

import demo.mcx.model.AcctUser;

public interface UserDao extends GenericDao<AcctUser, String> {
	AcctUser hqlQuery(String hql);
}
