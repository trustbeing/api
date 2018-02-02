package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.InfoAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:04 2018/1/24
 * @Modified By:
 */
@Repository(value = "infoAdminMapper")
public interface InfoAdminMapper {

	@Select("select * from info_admin where user_name = #{user_name}")
	InfoAdmin getOneByUserName(@Param("user_name") String user_name);

	@Select("select * from info_admin where id = #{id}")
	InfoAdmin getOneById(@Param("id") long id);
}
