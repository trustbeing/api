package com.waipan.api.service;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:13 2018/1/25
 * @Modified By:
 */
public interface AdminLoginHisService {

	long getHisIpCount(long admin_id,String ip);

	long getHisMaskIpCount(long admin_id,String ip);

	void insert(Long admin_id, String requestIp) throws Exception;
}
