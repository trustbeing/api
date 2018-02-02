package com.waipan.api.service;

import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:53 2018/1/26
 * @Modified By:
 */
public interface RoleCatelogService {

	String getPathByIds(List<Long> ids, int is_super);
}
