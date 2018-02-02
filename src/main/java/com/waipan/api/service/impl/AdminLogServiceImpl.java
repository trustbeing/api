package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.AdminLogMapper;
import com.waipan.api.model.entity.AdminLog;
import com.waipan.api.service.AdminLogService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:34 2018/1/26
 * @Modified By:
 */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Component("adminLogService")
public class AdminLogServiceImpl implements AdminLogService {

	@Resource
	private AdminLogMapper adminLogMapper;

	public void insert(long admin_id, String ref_table, long ref_id, String content, String remark) {
		AdminLog model = new AdminLog();
		model.setAdmin_id(admin_id);
		model.setRef_table(ref_table);
		model.setRef_id(ref_id);
		model.setContent(content);
		model.setRemark(remark);
		model.setCmp_id(0);
		adminLogMapper.insert(model);
	}
}
