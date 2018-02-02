package com.waipan.api.service;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:15 2018/1/26
 * @Modified By:
 */
public interface AdminPermissionService {

	boolean authorize(String controller, String action, long admin_id);
}
