package com.utrons.springbootexamples.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/system/user")
public class UserRest {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list() throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("datas", "list");

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable long id) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("datas", "getUser");

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("datas", "delete");

		return new ObjectMapper().writeValueAsString(map);
	}
}
