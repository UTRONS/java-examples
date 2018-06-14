package com.utrons.springbootexamples.system.model;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017-11-07 12:20
 * @link
 * @see
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017-11-06 10:08
 * @link
 * @see
 */
public class User implements Serializable {
	private static final long serialVersionUID = -6473568680969588229L;
	private long id;
	private String username;
	private String password;
	private int sex;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
