package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.AdminLoginHis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:09 2018/1/25
 * @Modified By:
 */
@Repository(value = "adminLoginHisMapper")
public interface AdminLoginHisMapper {

	@Select("select count(*) from admin_login_his where admin_id = #{admin_id} and login_ip = #{login_ip}")
	long getHisIpCount(@Param("admin_id") long admin_id, @Param("login_ip") String login_ip);

	@Select("select count(*) from admin_login_his where admin_id = #{admin_id} and ip_mask = #{ip_mask}")
	long getHisMaskIpCount(@Param("admin_id") long admin_id,@Param("ip_mask") String ip_mask);

	@Insert("insert into admin_login_his (admin_id, login_ip, ip_mask, cmp_id, is_area_calc, area, agent) values (#{admin_id},#{login_ip},#{ip_mask},#{cmp_id},#{is_area_calc},#{area},#{agent})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	long insert(AdminLoginHis adminLoginHis);
}
