package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.AdminPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:15 2018/1/26
 * @Modified By:
 */
@Repository("adminPermissionMapper")
public interface AdminPermissionMapper {

	@Select("select * from admin_permission where id in (#{ids})")
	List<AdminPermission> getListByIds(@Param("ids") String ids);
}
