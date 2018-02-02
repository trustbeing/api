package com.waipan.api.controller;

import com.waipan.api.model.entity.GlobalBanner;
import com.waipan.api.service.GlobalBannerService;
import com.waipan.api.util.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 12:17 2018/1/24
 * @Modified By:
 */
@RestController
@RequestMapping("/Home")
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Resource
	private GlobalBannerService globalBannerService;


	//region 客户端接口
	/** 
	 * @Description: 获取轮播滚动图片
	 * @Author:WangChenGang
	 * @Date:2018/1/24 17:59
	 * @param:
	 * @return:
	 */
	@RequestMapping(value="/GetBanner",method= RequestMethod.GET,produces="application/json")
	public ResponseResult getBanner(){
		List<GlobalBanner> models =globalBannerService.getList();
		final List<HashMap<String,Object>> resultData = new ArrayList<HashMap<String, Object>>();
		for (GlobalBanner model : models) {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("id",model.getId());
			map.put("img_url",model.getImg_url());
			resultData.add(map);
		}

		return ResponseResult.returnSuccess(resultData);
	}
	//endregion
}
