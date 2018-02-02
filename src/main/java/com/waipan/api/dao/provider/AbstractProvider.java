package com.waipan.api.dao.provider;

import com.waipan.api.util.StringExtension;
import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:28 2018/1/26
 * @Modified By:
 */
public class AbstractProvider {

	public <T> void addWhere(SQL sql,String key,Object value,Class<T> type,String paramName,String operate) {
		T t = (T) value;
		if (type.getName().equals("java.lang.Long")) {
			if ((Long) t != 0) {
				sql.WHERE(key + " " + operate + " " + t);
			}
		} else if (type.getName().equals("java.lang.Integer")) {
			if ((Integer) t != 0) {
				sql.WHERE(key + " " + operate + " " + t);
			}
		}
		else if (type.getName().equals("java.lang.String")) {
			String valueStr = (String) t;
			if (StringExtension.isNotEmpty(valueStr)) {
				if (valueStr.contains("%")) {
					if (valueStr.replace('%', ' ').trim().length() > 0) {
						sql.WHERE(key + " like #{" + paramName + "}");
					}
					return;
				} else {
					sql.WHERE(key + " " + operate + " #{" + paramName + "}");
				}
			}
		}else if (type.getName().equals("java.math.BigDecimal")) {
			if (((BigDecimal)t).compareTo(BigDecimal.ZERO) != 0) {
				sql.WHERE(key + " " + operate + " " + t);
			}
		}


	}
}
