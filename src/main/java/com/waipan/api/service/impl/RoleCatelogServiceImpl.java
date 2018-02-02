package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.RoleCatelogMapper;
import com.waipan.api.model.entity.RoleCatelog;
import com.waipan.api.service.RoleCatelogService;
import com.waipan.api.util.StringExtension;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:53 2018/1/26
 * @Modified By:
 */
@Component("roleCatelogService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class RoleCatelogServiceImpl implements RoleCatelogService {

	@Resource
	private RoleCatelogMapper roleCatelogMapper;

	public String getPathByIds(List<Long> ids, int is_super) {
		if (ids==null||ids.size()==0) return StringExtension.getEmpty();
		List<RoleCatelog> models = roleCatelogMapper.getListByIds(StringExtension.join(",",ids));

		List<String> resultArray = new ArrayList<String>();
		for (RoleCatelog model : models) {
			if (is_super <= 0 && model.getSort_index() >= 400) {
				continue;
			}
			resultArray.add(model.getName() + ";" + model.getVisit_url());
		}
		return StringExtension.join(",", resultArray);
	}
}
