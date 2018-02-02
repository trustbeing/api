package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.AdminPermissionMapper;
import com.waipan.api.dao.mapper.AdminRoleMapper;
import com.waipan.api.dao.mapper.InfoAdminMapper;
import com.waipan.api.model.entity.AdminPermission;
import com.waipan.api.model.entity.AdminRole;
import com.waipan.api.model.entity.InfoAdmin;
import com.waipan.api.service.AdminPermissionService;
import com.waipan.api.util.StringExtension;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:16 2018/1/26
 * @Modified By:
 */
@Component("adminPermissionService")
public class AdminPermissionServiceImpl implements AdminPermissionService {

	@Resource
	AdminPermissionMapper adminPermissionMapper;

	@Resource
	InfoAdminMapper infoAdminMapper;

	@Resource
	AdminRoleMapper adminRoleMapper;

	public boolean authorize(String controller, String action, long admin_id) {
		InfoAdmin admin = infoAdminMapper.getOneById(admin_id);
		if(admin==null) return false;
		if(admin.getIs_super()>0) return true;
		AdminRole adminRole = adminRoleMapper.getOnById(admin.getPermission_role());
		if(adminRole == null) return false;
		String[] permissionids = adminRole.getPermission_ids().split("|");

		List<AdminPermission> permissions = adminPermissionMapper.getListByIds(StringExtension.join(",",Arrays.asList(permissionids)));

		if(permissions==null || permissions.size()==0) return false;

		for (AdminPermission permission: permissions){
			if(permission.getPermission_controller().toLowerCase().equals("all"))
				return true;
			if(permission.getPermission_controller().toLowerCase().equals(controller.toLowerCase())){
				if(permission.getPermission_action().toLowerCase().equals("all")|| permission.getPermission_action().toLowerCase().equals(action.toLowerCase()))
					return true;
			}
		}
		return false;

	}
}
