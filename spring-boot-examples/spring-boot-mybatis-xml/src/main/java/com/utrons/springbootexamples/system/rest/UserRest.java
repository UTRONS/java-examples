package com.utrons.springbootexamples.system.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utrons.springbootexamples.system.model.User;
import com.utrons.springbootexamples.system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017-11-07 11:45
 * @link
 * @see
 */
@RestController
@RequestMapping(value = "/system/user")
public class UserRest {
	private final UserService userService;

	public UserRest(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this.userService.getAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable long id) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("datas", this.userService.getUser(id));

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insert(@RequestBody User user) throws JsonProcessingException {
		this.userService.insert(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, @RequestBody User user) throws JsonProcessingException {
		user.setId(id);
		this.userService.update(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return new ObjectMapper().writeValueAsString(map);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) throws JsonProcessingException {
		this.userService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return new ObjectMapper().writeValueAsString(map);
	}
}

