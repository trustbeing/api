package com.waipan.api.service;

import com.waipan.api.util.enums.EnumInfoMobileMsgType; /**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 10:20 2018/1/26
 * @Modified By:
 */
public interface InfoMobileMsgService {

	String insert(String mobile, String request_ip, EnumInfoMobileMsgType msg_type, String msg_content, String result);

	String insert(String mobile, String request_ip, EnumInfoMobileMsgType msg_type, String msg_content, String result,String verify_code);
}
