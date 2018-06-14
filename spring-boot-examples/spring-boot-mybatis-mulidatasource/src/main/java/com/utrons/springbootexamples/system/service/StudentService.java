package com.utrons.springbootexamples.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utrons.springbootexamples.system.dao.utestb.StudentDao;
import com.utrons.springbootexamples.system.model.Student;

/**
 * 
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017年11月8日 上午9:50:23
 * @link
 * @see
 */
@Service
public class StudentService {
	private final StudentDao studentDao;

	public StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getAll() {
		return this.studentDao.getAll();
	}

	public Student get(Long id) {
		return this.studentDao.get(id);
	}

	public void insert(Student student) {
		this.studentDao.insert(student);
	}

	public void update(Student student) {
		this.studentDao.update(student);
	}

	public void delete(Long id) {
		this.studentDao.delete(id);
	}
}
