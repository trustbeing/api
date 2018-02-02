package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.AdminLoginHisMapper;
import com.waipan.api.model.entity.AdminLoginHis;
import com.waipan.api.service.AdminLoginHisService;
import com.waipan.api.util.IpHelper;
import com.waipan.api.util.StringExtension;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:14 2018/1/25
 * @Modified By:
 */

@Component("adminLoginHisService")
public class AdminLoginHisServiceImpl implements AdminLoginHisService {

	@Resource
	private AdminLoginHisMapper adminLoginHisMapper;

	public long getHisIpCount(long admin_id, String ip) {
		return adminLoginHisMapper.getHisIpCount(admin_id,ip);
	}

	public long getHisMaskIpCount(long admin_id, String ip) {
		String maskip = IpHelper.getMaskCode(ip);
		if (StringExtension.isEmpty(maskip)) return 0;
		return adminLoginHisMapper.getHisMaskIpCount(admin_id,maskip);
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void insert(Long admin_id, String requestIp) throws Exception{
		String maskIp = IpHelper.getMaskCode(requestIp);
		AdminLoginHis model = new AdminLoginHis();
		model.setAdmin_id(admin_id);
		model.setLogin_ip(requestIp);
		model.setCmp_id(0);
		model.setIs_area_calc(0);
		model.setArea(StringExtension.getEmpty());
		model.setAgent(StringExtension.getEmpty());
		model.setIp_mask(maskIp);
		long newId = adminLoginHisMapper.insert(model);
		if(newId<0){
			throw new Exception("添加失败");
		}
	}
}
