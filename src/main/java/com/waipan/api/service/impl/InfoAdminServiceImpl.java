package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.InfoAdminMapper;
import com.waipan.api.model.entity.InfoAdmin;
import com.waipan.api.service.InfoAdminService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:08 2018/1/24
 * @Modified By:
 */

@Component("infoAdminService")
public class InfoAdminServiceImpl implements InfoAdminService{

	@Resource
	private InfoAdminMapper infoAdminMapper;

	public InfoAdmin getOneByUserName(String user_name) {
		return infoAdminMapper.getOneByUserName(user_name);
	}

	public InfoAdmin getOneById(long id) {
		return infoAdminMapper.getOneById(id);
	}

	public int getPermissionCmpId(int cmp_id, InfoAdmin admin) {
		if (admin.getCmp_id() > 0)
			cmp_id = admin.getCmp_id();
		return cmp_id;
	}
}
