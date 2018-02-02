package com.waipan.api.controller;

import com.waipan.api.model.entity.InfoAdmin;
import com.waipan.api.model.entity.InfoUser;
import com.waipan.api.service.AdminPermissionService;
import com.waipan.api.service.InfoAdminService;
import com.waipan.api.service.InfoUserService;
import com.waipan.api.util.DateTimeExtension;
import com.waipan.api.util.RequestHelper;
import com.waipan.api.util.ResponseResult;
import com.waipan.api.util.annotation.Authorization;
import com.waipan.api.util.enums.EnumOperatorType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:28 2018/1/24
 * @Modified By:
 */
@RestController
@RequestMapping("InfoUser")
public class InfoUserController {

	@Resource
	private InfoAdminService infoAdminService;

	@Resource
	private AdminPermissionService adminPermissionService;

	@Resource
	private InfoUserService infoUserService;

	//region  后台管理接口

	@RequestMapping(value="GetListByAdmin",method = RequestMethod.GET)
	@Authorization
	public ResponseResult getListByAdmin(@RequestParam(value="id",required = false) long id, @RequestParam(value="mobile",required = false) String mobile,
	                                     @RequestParam(value="nick_name",required = false) String nick_name, @RequestParam(value="real_name",required = false) String real_name,
	                                     @RequestParam(value="id_card",required = false) String id_card, @RequestParam(value="create_times",required = false) String create_times,
	                                     @RequestParam(value="create_timee",required = false) String create_timee, @RequestParam(value="ref_id",required = false) long ref_id,
	                                     @RequestParam(value="moneys",required = false) BigDecimal moneys, @RequestParam(value="moneye",required = false) BigDecimal moneye,
	                                     @RequestParam(value="cmp_id",required = false) int cmp_id, @RequestParam(value="page_size") int page_size, @RequestParam(value="page_index") int page_index,
	                                     HttpServletRequest request) {

		long loginId = RequestHelper.getCurrentLoginId(request);
		int loginType = RequestHelper.getCurrentLoginType(request);
		if (loginType != EnumOperatorType.SysUser.getIndex()){
			return ResponseResult.returnAuthorizeFailure();
		}

		InfoAdmin admin = infoAdminService.getOneById(loginId);
		if (!adminPermissionService.authorize("InfoUser", "GetListByAdmin", admin.getId()))
			return ResponseResult.returnNoPermission();

		cmp_id = infoAdminService.getPermissionCmpId(cmp_id,admin);

		List<InfoUser> infoUserList = infoUserService.getListByAdmin(id, mobile,moneys,moneye,nick_name,ref_id,create_times,create_timee,real_name,id_card, cmp_id, page_index, page_size);
		if(infoUserList==null||infoUserList.size()==0) return ResponseResult.returnSuccess(null);

		HashSet<Long> refIds = new HashSet<Long>();
		for (InfoUser user:infoUserList){
			long refId = user.getRef_id();
			if(refId>0 && !refIds.contains(refId)) {
				refIds.add(refId);
			}
		}


		List<InfoUser> refUsers = infoUserService.getListByIds(new ArrayList(refIds));

		final List<HashMap<String,Object>> resultData = new ArrayList<HashMap<String, Object>>();
		for (InfoUser user : infoUserList) {

			InfoUser rUser = new InfoUser();
			for (InfoUser refUser:refUsers){
				if(refUser.getId()==user.getRef_id()){
					rUser = refUser;
					break;
				}
			}

			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("id",user.getId());
			map.put("nick_name",user.getNick_name());
			map.put("mobile",user.getMobile());
			map.put("create_time", DateTimeExtension.format(user.getCreate_time()));
			map.put("reak_name",user.getReal_name());
			map.put("account_money",user.getAccount_money());
			map.put("is_lock",user.getIs_lock());
			map.put("ref_id",user.getRef_id());
			map.put("ref_info",rUser.getNick_name());
			map.put("cmp_id",user.getCmp_id());

			resultData.add(map);
		}

		return ResponseResult.returnSuccess(resultData);

	}

	@RequestMapping(value="GetCountByAdmin",method = RequestMethod.GET)
	@Authorization
	public ResponseResult getCountByAdmin(@RequestParam(value="id",required = false) long id, @RequestParam(value="mobile",required = false) String mobile,
	                                      @RequestParam(value="nick_name",required = false) String nick_name, @RequestParam(value="real_name",required = false) String real_name,
	                                      @RequestParam(value="id_card",required = false) String id_card, @RequestParam(value="create_times",required = false) String create_times,
	                                      @RequestParam(value="create_timee",required = false) String create_timee, @RequestParam(value="ref_id",required = false) long ref_id,
	                                      @RequestParam(value="moneys",required = false) BigDecimal moneys, @RequestParam(value="moneye",required = false) BigDecimal moneye,
	                                      @RequestParam(value="cmp_id",required = false) int cmp_id,
	                                      HttpServletRequest request){
		long loginId = RequestHelper.getCurrentLoginId(request);
		int loginType = RequestHelper.getCurrentLoginType(request);
		if (loginType != EnumOperatorType.SysUser.getIndex()){
			return ResponseResult.returnAuthorizeFailure();
		}

		InfoAdmin admin = infoAdminService.getOneById(loginId);
		if (!adminPermissionService.authorize("InfoUser", "GetListByAdmin", admin.getId()))
			return ResponseResult.returnNoPermission();

		cmp_id = infoAdminService.getPermissionCmpId(cmp_id,admin);

		long result = infoUserService.getCountByAdmin(id, mobile,moneys,moneye,nick_name,ref_id,create_times,create_timee,real_name,id_card, cmp_id);
		return ResponseResult.returnSuccess(result);
	}

	@RequestMapping(value="ChangeMoneyByAdmin",method = RequestMethod.POST)
	@Authorization
	public ResponseResult changeMoneyByAdmin(@RequestParam("user_id") Long user_id,@RequestParam("type") Integer type,@RequestParam("changemoney") BigDecimal changemoney, @RequestParam("remark") String remark, @RequestParam("ref_table") String ref_table, @RequestParam("ref_id") Long ref_id, HttpServletRequest request){
		long loginId = RequestHelper.getCurrentLoginId(request);
		int loginType = RequestHelper.getCurrentLoginType(request);
		if (loginType != EnumOperatorType.SysUser.getIndex()){
			return ResponseResult.returnAuthorizeFailure();
		}
		InfoAdmin admin = infoAdminService.getOneById(loginId);
		if (!adminPermissionService.authorize("InfoUser", "ChangeMoneyByAdmin", admin.getId()))
			return ResponseResult.returnNoPermission();

		InfoUser user = infoUserService.getById(user_id);
		if(user==null) return ResponseResult.returnFailure("用户不存在");
		try {
			String result = infoUserService.changeMoneyByAdmin(user_id,type,changemoney,remark,ref_table,ref_id,admin.getId());
			return ResponseResult.returnStringResult(result);
		} catch (Exception ex) {
			 return ResponseResult.returnFailure(ex.getMessage());
		}
	}

	//endregion

}
