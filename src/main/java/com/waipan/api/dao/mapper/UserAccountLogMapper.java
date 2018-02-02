package com.waipan.api.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:10 2018/2/1
 * @Modified By:
 */
@Repository("userAccountLogMapper")
public interface UserAccountLogMapper {

	@Insert("INSERT INTO user_account_log (user_id,change_type,change_money,pre_money,now_money,ref_table,ref_id,detail,remark,cmp_id) values (#{user_id},#{change_type},#{change_money},#{pre_money},#{now_money},#{ref_table},#{ref_id},#{detail},#{remark},#{cmp_id})")
	Long insert(@Param("user_id") Long user_id, @Param("change_type")int change_type, @Param("change_money")BigDecimal change_money, @Param("pre_money")BigDecimal pre_money, @Param("now_money")BigDecimal now_money, @Param("ref_table")String ref_table, @Param("ref_id")Long ref_id, @Param("detail")String detail, @Param("remark")String remark, @Param("cmp_id")Integer cmp_id);

}
