package com.test.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springcloud.dao.TUserMapper;
import com.test.springcloud.entity.TUser;

@Service
public class TUserServiceImpl implements TUserService{
	
	@Autowired
	private TUserMapper mapper;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TUser> selectAll() {
		return mapper.selectAll();
	}

	public int updateByPrimaryKey(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<TUser> selectAssocition() {
		return mapper.selectAssocition();
	}

	public List<TUser> selectAssocition2() {
		// TODO Auto-generated method stub
		return mapper.selectAssocition2();
	}

	public TUser selectIncludeJobs(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TUser> selectUserHealthReport() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TUser> selectUserRolesInfo() {
		return mapper.selectUserRolesInfo();
	}

}
