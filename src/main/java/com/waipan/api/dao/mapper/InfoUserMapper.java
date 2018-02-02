package com.waipan.api.dao.mapper;

import com.waipan.api.dao.provider.InfoUserProvider;
import com.waipan.api.model.entity.InfoUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:36 2018/1/26
 * @Modified By:
 */
@Repository("infoUserMapper")
@CacheNamespace(size = 512)
public interface InfoUserMapper {

	@Select("select * from info_user where id in (${ids}) ")
	List<InfoUser> getListByIds(@Param("ids") String ids);

	@SelectProvider(type = InfoUserProvider.class,method = "getList")
	List<InfoUser> getList(long id, @Param("mobile") String mobile, BigDecimal moneys, BigDecimal moneye,@Param("nick_name") String nick_name, long ref_id, @Param("create_times")String create_times,@Param("create_timee") String create_timee, @Param("real_name")String real_name,@Param("id_card") String id_card, int cmp_id, int page_index, int page_size);

	@SelectProvider(type = InfoUserProvider.class,method = "getCount")
	long getCount(long id, @Param("mobile") String mobile, BigDecimal moneys, BigDecimal moneye,@Param("nick_name") String nick_name, long ref_id, @Param("create_times")String create_times,@Param("create_timee") String create_timee, @Param("real_name")String real_name,@Param("id_card") String id_card, int cmp_id);

	@Select("select * from info_user where id = (#{id}) ")
	InfoUser getById(Long id);

	@Update("Update info_user set account_money = account_money+#{change_money} where id=#{id}")
	int addAccountMoney(@Param("id") Long id,@Param("change_money") BigDecimal change_money);
}
