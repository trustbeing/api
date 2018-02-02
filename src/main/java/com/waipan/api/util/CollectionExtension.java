package com.waipan.api.util;

import java.util.Collection;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:54 2018/1/24
 * @Modified By:
 */
public class CollectionExtension {
	public static boolean isNotEmpty(Collection<?> c){
		return c != null && c.size() != 0;
	}
}
