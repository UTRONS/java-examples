/*
 * Copyright (c) 2017 朱泽才 版权所有
 */
package com.utrons.springbootexamples.system.dao.utestb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.utrons.springbootexamples.system.model.Student;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017年11月8日 上午9:49:40
 * @link
 * @see
 */
@Mapper
public interface StudentDao {
	public abstract List<Student> getAll();

	public abstract Student get(Long id);

	public abstract void insert(Student student);

	public abstract void update(Student student);

	public abstract void delete(Long id);
}