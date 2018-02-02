package com.waipan.api.service;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:33 2018/1/26
 * @Modified By:
 */
public interface AdminLogService {
	void insert(long admin_id, String ref_table,long ref_id, String content,String remark);
}
