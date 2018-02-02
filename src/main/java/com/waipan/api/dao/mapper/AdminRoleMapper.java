package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.AdminRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:47 2018/1/26
 * @Modified By:
 */
@Repository("adminRoleMapper")
public interface AdminRoleMapper {

	@Select("select * from admin_role where id =#{id}")
	AdminRole getOnById(@Param("id") Long id);
}
