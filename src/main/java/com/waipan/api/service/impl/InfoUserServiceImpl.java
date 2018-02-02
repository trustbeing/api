package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.AdminLogMapper;
import com.waipan.api.dao.mapper.InfoUserMapper;
import com.waipan.api.dao.mapper.UserAccountLogMapper;
import com.waipan.api.dao.mapper.UserRechargeMapper;
import com.waipan.api.model.entity.AdminLog;
import com.waipan.api.model.entity.InfoUser;
import com.waipan.api.model.entity.RoleCatelog;
import com.waipan.api.service.InfoUserService;
import com.waipan.api.util.StringExtension;
import com.waipan.api.util.enums.EnumUserAccountChangeType;
import com.waipan.api.util.enums.EnumUserRechargeType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:36 2018/1/26
 * @Modified By:
 */
@Component("infoUserService")
public class InfoUserServiceImpl implements InfoUserService{

	@Resource
	private InfoUserMapper infoUserMapper;

	@Resource
	private UserRechargeMapper userRechargeMapper;

	@Resource
	private UserAccountLogMapper userAccountLogMapper;

	@Resource
	private AdminLogMapper adminLogMapper;


	public List<InfoUser> getListByIds(List<Long> ids) {
		if (ids==null||ids.size()==0) return new ArrayList<InfoUser>();
		return infoUserMapper.getListByIds(StringExtension.join(",",ids));
	}

	public List<InfoUser> getListByAdmin(long id, String mobile, BigDecimal moneys, BigDecimal moneye, String nick_name, long ref_id, String create_times, String create_timee, String real_name, String id_card, int cmp_id, int page_index, int page_size) {
		return infoUserMapper.getList(id, "%"+mobile+"%",moneys,moneye,nick_name,ref_id,create_times,create_timee,real_name,id_card, cmp_id, page_index, page_size);
	}

	public long getCountByAdmin(long id, String mobile, BigDecimal moneys, BigDecimal moneye, String nick_name, long ref_id, String create_times, String create_timee, String real_name, String id_card, int cmp_id) {
		return infoUserMapper.getCount(id, "%"+mobile+"%",moneys,moneye,nick_name,ref_id,create_times,create_timee,real_name,id_card, cmp_id);
	}

	public InfoUser getById(Long id) {
		return infoUserMapper.getById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public String changeMoneyByAdmin(Long id, Integer type, BigDecimal changemoney, String remark, String ref_table, Long ref_id, Long admin_id) throws Exception{
		if(type== EnumUserRechargeType.AliPay.getIndex()||type== EnumUserRechargeType.BankTransfer.getIndex()) {
			if (changemoney.compareTo(BigDecimal.ZERO) < 0) return "无效的充值金额";
			InfoUser user = infoUserMapper.getById(id);
			if (user == null) return "用户不存在";
			if (infoUserMapper.addAccountMoney(user.getId(), changemoney) != 1) {
				throw new Exception("更新账户失败");
			}

			Long rechargeId = userRechargeMapper.insert(id, type, changemoney, admin_id, ref_table, remark, user.getCmp_id());
			if (rechargeId <= 0) {
				throw new Exception("添加充值记录失败");
			}

			if (userAccountLogMapper.insert(id, EnumUserAccountChangeType.UserRechange.getIndex(), changemoney, user.getAccount_money(), user.getAccount_money().add(changemoney), "user_recharge", rechargeId, EnumUserRechargeType.getByIndex(type).getName() + "-" + ref_table, StringExtension.getEmpty(), user.getCmp_id()) <= 0) {
				throw new Exception("添加用户账户记录失败");
			}

			AdminLog adminLog = new AdminLog();
			adminLog.setAdmin_id(admin_id);
			adminLog.setRef_table(ref_table);
			adminLog.setRef_id(ref_id);
			adminLog.setContent("用户充值，编号：" + id + "，充值方式：" + EnumUserRechargeType.getByIndex(type).getName() + "，金额：" + changemoney);
			adminLog.setRemark(remark);
			adminLog.setCmp_id(0);
			if(adminLogMapper.insert(adminLog)<=0){
				throw new Exception("创建管理员日志失败");
			}

			return StringExtension.getEmpty();
		}else{
			return "开发中";
		}
	}
}
