package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.AdminLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:30 2018/1/26
 * @Modified By:
 */
@Repository("adminLogMapper")
public interface AdminLogMapper {

	@Insert("insert into admin_log (admin_id, ref_table, ref_id, content, remark, cmp_id) values (#{admin_id},#{ref_table},#{ref_id},#{content},#{remark},#{cmp_id})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	long insert(AdminLog adminLog);
}
