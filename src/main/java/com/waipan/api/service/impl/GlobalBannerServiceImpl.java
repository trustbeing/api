package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.GlobalBannerMapper;
import com.waipan.api.model.entity.GlobalBanner;
import com.waipan.api.service.GlobalBannerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:18 2018/1/24
 * @Modified By:
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Component("globalBannerSerivce")
public class GlobalBannerServiceImpl implements GlobalBannerService {

	@Resource
	private GlobalBannerMapper globalBannerMapper;


	public List<GlobalBanner> getList() {
		return globalBannerMapper.getList();
	}
}
