package com.waipan.api.service;

import com.waipan.api.model.entity.InfoUser;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:36 2018/1/26
 * @Modified By:
 */
public interface InfoUserService {

	List<InfoUser> getListByIds(List<Long> ids);

	List<InfoUser> getListByAdmin(long id, String mobile, BigDecimal moneys, BigDecimal moneye, String nick_name, long ref_id, String create_times, String create_timee, String real_name, String id_card, int cmp_id, int page_index, int page_size);

	long getCountByAdmin(long id, String mobile, BigDecimal moneys, BigDecimal moneye, String nick_name, long ref_id, String create_times, String create_timee, String real_name, String id_card, int cmp_id);

	InfoUser getById(Long id);

	String changeMoneyByAdmin(Long id, Integer type, BigDecimal changemoney, String remark, String ref_table, Long ref_id, Long admin_id) throws Exception;
}
