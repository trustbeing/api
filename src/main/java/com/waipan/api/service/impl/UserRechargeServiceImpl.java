package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.UserRechargeMapper;
import com.waipan.api.service.UserRechargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:00 2018/2/1
 * @Modified By:
 */
@Service("userRechargeService")
public class UserRechargeServiceImpl implements UserRechargeService {

	@Resource
	private UserRechargeMapper userRechargeMapper;


}
