package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.UserAccountLogMapper;
import com.waipan.api.service.UserAccountLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:11 2018/2/1
 * @Modified By:
 */
@Service("userAccountLogService")
public class UserAccountLogServiceImpl implements UserAccountLogService {

	@Resource
	private UserAccountLogMapper userAccountLogMapper;

}
