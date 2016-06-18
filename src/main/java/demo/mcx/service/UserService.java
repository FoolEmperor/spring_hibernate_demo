package demo.mcx.service;

import java.util.List;

import demo.mcx.model.AcctUser;

public interface UserService {
	AcctUser get(String id);
	List<AcctUser> findAll();
	AcctUser power(String id);
	AcctUser load(String id);
	String save(AcctUser acctUser);
}
