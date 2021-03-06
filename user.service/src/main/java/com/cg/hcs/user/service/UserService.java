package com.cg.hcs.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.user.dao.UsersDAO;
import com.cg.hcs.user.dto.Users;

@Service
public class UserService 
{
	@Autowired
	UsersDAO udao;
	public void setUdao(UsersDAO udao)
	{
		this.udao = udao;
	}
	
	@Transactional(readOnly = true)
	public Optional<Users> getUserById(String user_id)
	{
		return udao.findById(user_id);
	}
	
	@Transactional
	public Users addUser(Users user)
	{
		return udao.save(user);
	}
}