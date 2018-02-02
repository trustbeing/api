package com.waipan.api.controller;

import com.waipan.api.dao.redis.RedisCache;
import com.waipan.api.model.dto.TokenModel;
import com.waipan.api.model.entity.AdminRole;
import com.waipan.api.model.entity.InfoAdmin;
import com.waipan.api.service.*;
import com.waipan.api.util.*;
import com.waipan.api.util.annotation.Authorization;
import com.waipan.api.util.enums.EnumApiErrorCode;
import com.waipan.api.util.enums.EnumInfoMobileMsgType;
import com.waipan.api.util.enums.EnumOperatorType;
import com.waipan.api.util.enums.EnumTrueOrFalseState;
import com.waipan.api.util.mobile.AliyunSms;
import com.waipan.api.util.mobile.MobileHelper;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:07 2018/1/24
 * @Modified By:
 */
@RestController
@RequestMapping("InfoAdmin")
public class InfoAdminController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Resource
	private InfoAdminService infoAdminService;

	@Resource
	private AdminLoginHisService adminLoginHisService;

	@Resource
	private InfoMobileMsgService infoMobileMsgService;

	@Resource
	private AdminLogService adminLogService;

	@Resource
	private AdminRoleService adminRoleService;

	@Resource
	private RoleCatelogService roleCatelogService;

	@Resource
	private TokenManagerService tokenManagerService;

	@Resource
	private RedisCache redisCache;

	@RequestMapping(value="Login",method = RequestMethod.POST)
	public ResponseResult login(@RequestParam("user_name") String user_name, @RequestParam("pass_word") String pass_word,@RequestParam(value="verify",required = false) String verify, HttpServletRequest request, HttpServletResponse response) {
		InfoAdmin admin = infoAdminService.getOneByUserName(user_name);
		if (admin != null) {
			String requestIp = IpHelper.getRequestIp(request);
			if (Md5Helper.getMd5(pass_word).equals(admin.getPass_word())) {
				if (admin.getIs_delete() == EnumTrueOrFalseState.True.getIndex())
					return ResponseResult.returnFailure("该用户已删除");

				if (adminLoginHisService.getHisIpCount(admin.getId(), requestIp) <= 0 && adminLoginHisService.getHisMaskIpCount(admin.getId(), requestIp) <= 0 && StringExtension.isNotEmpty(admin.getMobile()) && admin.getMobile() != "99999999999") {
					if (StringExtension.isNotEmpty(verify)) {
						String code =  redisCache.get("MOBILE_CODE_"+admin.getMobile());
						if(StringExtension.isEmpty(code)|| !code.equals(verify)){
							return ResponseResult.returnFailure("验证码无效!");

						}
					}
					else
					{
						String code = MobileHelper.setCode(admin.getMobile(), 6);
						String result =  redisCache.set("MOBILE_CODE_" + admin.getMobile(), code,5);
						//新IP首次登录，发送短信验证码
						String smsResult = AliyunSms.sendSms(admin.getMobile(),"SMS_83255287","{\"code\":\"" + code + "\"}");
						infoMobileMsgService.insert(admin.getMobile(),requestIp, EnumInfoMobileMsgType.AdminLogin,"验证码" + code + "，您正在进行身份验证，打死不要告诉别人哦！",smsResult,code);

						return ResponseResult.returnFailure(MobileHelper.hide(admin.getMobile()),
							 EnumApiErrorCode.MobileCodeLogin.getIndex());

					}
				}

				TokenModel token = tokenManagerService.createToken(admin.getId(),EnumOperatorType.SysUser.getIndex(),requestIp);
				adminLogService.insert(admin.getId(), "admin_log", admin.getId(), "后台登录，登录地址：" + requestIp, StringExtension.getEmpty());
				try {
					adminLoginHisService.insert(admin.getId(), requestIp);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return ResponseResult.returnSuccess(token.getAuthToken());
			}

		}

		return ResponseResult.returnFailure("用户名或密码错误");
	}

	@RequestMapping(value="GetSelf",method = RequestMethod.GET)
	@Authorization
	public ResponseResult getSelf(HttpServletRequest request){
		long loginId = RequestHelper.getCurrentLoginId(request);
		int loginType = RequestHelper.getCurrentLoginType(request);
		if (loginId<=0 || loginType != EnumOperatorType.SysUser.getIndex()){
			return ResponseResult.returnAuthorizeFailure();
		}

		InfoAdmin admin = infoAdminService.getOneById(loginId);
		AdminRole role =adminRoleService.GetOneById(admin.getPermission_role());
		if(role==null) return ResponseResult.returnFailure("找不到用户角色");
		String allPath = role.getAll_path();
		String[] rolePaths = role.getAll_path().split(",");
		List<Long> catelogIds = new ArrayList<Long>();
		for (int i=0;i<rolePaths.length;i++) {
			catelogIds.add(Long.parseLong(rolePaths[i]));
		}


		String paths = roleCatelogService.getPathByIds(catelogIds,admin.getIs_super());

		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id",admin.getId());
		map.put("nick_name",admin.getNick_name());
		map.put("permission",admin.getPermission_role());
		map.put("cmp_id",admin.getCmp_id());
		map.put("is_super",admin.getIs_super());
		map.put("default_path",role.getDefault_path());
		map.put("all_path",paths);

		return ResponseResult.returnSuccess(map);
	}

}
