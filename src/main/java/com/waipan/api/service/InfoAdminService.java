package com.waipan.api.service;

import com.waipan.api.model.entity.InfoAdmin;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:08 2018/1/24
 * @Modified By:
 */
public interface InfoAdminService {

	InfoAdmin getOneByUserName(String user_name);

	InfoAdmin getOneById(long loginId);

	int getPermissionCmpId(int cmp_id, InfoAdmin admin);
}
