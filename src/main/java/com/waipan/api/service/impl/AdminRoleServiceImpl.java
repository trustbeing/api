package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.AdminRoleMapper;
import com.waipan.api.model.entity.AdminRole;
import com.waipan.api.service.AdminRoleService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:48 2018/1/26
 * @Modified By:
 */
@Component("adminRoleService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AdminRoleServiceImpl implements AdminRoleService {

	@Resource
	private AdminRoleMapper adminRoleMapper;

	public AdminRole GetOneById(Long id) {
		return adminRoleMapper.getOnById(id);
	}
}
