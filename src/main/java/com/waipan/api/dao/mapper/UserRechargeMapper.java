package com.waipan.api.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:59 2018/2/1
 * @Modified By:
 */
@Repository("userRechargeMapper")
public interface UserRechargeMapper {

	@Insert("insert into user_recharge (user_id,recharge_type,money,sys_user_id,third_code,remark,cmp_id) VALUES (#{user_id},#{recharge_type},#{money},#{sys_user_id},#{third_code},#{remark},#{cmp_id})")
	Long insert(@Param("user_id") Long user_id, @Param("recharge_type") Integer recharge_type, @Param("money") BigDecimal money, @Param("sys_user_id") Long sys_user_id, @Param("third_code") String third_code, @Param("remark") String remark, @Param("cmp_id") Integer cmp_id);

}
