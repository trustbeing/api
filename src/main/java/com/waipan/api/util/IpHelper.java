package com.waipan.api.util;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:17 2018/1/25
 * @Modified By:
 */
public class IpHelper {

	private static final Logger logger = Logger.getLogger(IpHelper.class);

	public static String getMaskCode(String ip){
		if(StringExtension.isEmpty(ip)) return "";
		String[] ipArray = ip.split(",");
		if(ipArray.length!=4) return ip;
		try{
			int value = Integer.parseInt(ipArray[2]);
			int mask = getInnerMask(value);
			return ipArray[0] + "." + ipArray[1] + "." + mask + ".0";
		}catch(Exception ex){
			logger.error(ex);
			return ip;
		}
	}

	private static int getInnerMask(int value){
		if (value <= 2) return 0;
		int result = 2;
		while (result <= value)
		{
			result = result * 2;
		}
		return result / 2;
	}

	public static String getRequestIp(HttpServletRequest request){

		if (request != null) {
			String realIp = request.getHeader("X-Real-IP");
			if (!StringExtension.isEmpty(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
				return realIp;
			}
			String remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (!StringExtension.isEmpty(remoteAddr) && !"unknown".equalsIgnoreCase(remoteAddr)) {
				int index = remoteAddr.indexOf(',');
				if (index != -1) {
					return  remoteAddr.substring(0, index);
				} else {
					return remoteAddr;
				}
			}
			return request.getRemoteAddr();
		}
		return StringExtension.getEmpty();
	}
}
