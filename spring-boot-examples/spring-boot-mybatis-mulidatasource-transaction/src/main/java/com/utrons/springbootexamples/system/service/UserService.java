package com.utrons.springbootexamples.system.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utrons.springbootexamples.system.dao.utesta.UserDao;
import com.utrons.springbootexamples.system.model.User;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017-11-07 12:22
 * @link
 * @see
 */
@Service
public class UserService {
	private final UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAll() {
		return this.userDao.getAll();
	}

	public User get(Long id) {
		return this.userDao.get(id);
	}

	@Transactional(value="utestATransactionManager")
	public void insert(User user) {
		this.userDao.insert(user);
		throw new RuntimeException("Bussiness Exception");
	}

	/* 默认使用@Primary声明的事务 */
	@Transactional
	public void update(User user) {
		this.userDao.update(user);
	}

	public void delete(Long id) {
		this.userDao.delete(id);
	}
}
