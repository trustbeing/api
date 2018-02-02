package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.InfoMobileMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 10:21 2018/1/26
 * @Modified By:
 */
@Repository(value = "infoMobileMsgMapper")
public interface InfoMobileMsgMapper {

	@Insert("insert into info_mobile_msg (mobile, request_ip, verify_code, msg_type, msg_content,send_result) values (#{mobile},#{request_ip},#{verify_code},#{msg_type},#{msg_content},#{send_result})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	int insert(InfoMobileMsg model);
}
