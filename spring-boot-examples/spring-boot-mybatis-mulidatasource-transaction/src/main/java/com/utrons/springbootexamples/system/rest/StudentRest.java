/*
 * Copyright (c) 2017 朱泽才 版权所有
 */
package com.utrons.springbootexamples.system.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utrons.springbootexamples.system.model.Student;
import com.utrons.springbootexamples.system.service.StudentService;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017年11月8日 上午9:51:30
 * @link
 * @see
 */
@RestController
@RequestMapping(value = "/system/student")
public class StudentRest {
	private final StudentService studentService;

	public StudentRest(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this.studentService.getAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getStudent(@PathVariable long id) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("datas", this.studentService.get(id));

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insert(@RequestBody Student student) throws JsonProcessingException {
		this.studentService.insert(student);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, @RequestBody Student student) throws JsonProcessingException {
		student.setId(id);
		this.studentService.update(student);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) throws JsonProcessingException {
		this.studentService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return new ObjectMapper().writeValueAsString(map);
	}
}