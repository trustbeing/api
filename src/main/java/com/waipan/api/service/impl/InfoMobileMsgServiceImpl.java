package com.waipan.api.service.impl;

import com.waipan.api.dao.mapper.InfoMobileMsgMapper;
import com.waipan.api.model.entity.InfoMobileMsg;
import com.waipan.api.service.InfoMobileMsgService;
import com.waipan.api.util.StringExtension;
import com.waipan.api.util.enums.EnumInfoMobileMsgType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 10:20 2018/1/26
 * @Modified By:
 */

@Component("infoMobileMsgService")
public class InfoMobileMsgServiceImpl implements InfoMobileMsgService {

	@Resource
	InfoMobileMsgMapper infoMobileMsgMapper;

	@Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public String insert(String mobile,String request_ip, EnumInfoMobileMsgType msg_type, String msg_content, String result,String verify_code) {
		InfoMobileMsg model = new InfoMobileMsg();
		model.setMobile(mobile);
		model.setRequest_ip(request_ip);
		model.setMsg_type(msg_type.getIndex());
		model.setVerify_code(verify_code);
		model.setMsg_content(msg_content);
		model.setSend_result(result);
		if (infoMobileMsgMapper.insert(model)<=0){
			return "创建记录失败";
		}

		return StringExtension.getEmpty();
	}

	@Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public String insert(String mobile,String request_ip, EnumInfoMobileMsgType msg_type, String msg_content, String result) {
		InfoMobileMsg model = new InfoMobileMsg();
		model.setMobile(mobile);
		model.setRequest_ip(request_ip);
		model.setMsg_type(msg_type.getIndex());
		model.setVerify_code(StringExtension.getEmpty());
		model.setMsg_content(msg_content);
		model.setSend_result(result);
		if (infoMobileMsgMapper.insert(model)<=0){
			return "创建记录失败";
		}
		return StringExtension.getEmpty();
	}
}
