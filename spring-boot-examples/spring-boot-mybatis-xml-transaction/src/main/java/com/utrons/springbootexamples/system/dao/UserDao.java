package com.utrons.springbootexamples.system.dao;

import com.utrons.springbootexamples.system.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户DAO接口
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017-11-07 12:20
 * @link
 * @see
 */
@Mapper
public interface UserDao {
	public abstract List<User> getAll();

	public abstract User getUser(Long id);

	public abstract void insert(User user);

	public abstract void update(User user);

	public abstract void delete(Long id);
}

