package com.waipan.api.dao.provider;

import com.waipan.api.model.entity.InfoUser;
import com.waipan.api.util.StringExtension;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 17:42 2018/1/26
 * @Modified By:
 */
public class InfoUserProvider  extends AbstractProvider{

	private final String TABLE = "info_user";

	public  String getList(Map<String, Object> param) {
		SQL sql = new SQL().SELECT("*").FROM(TABLE);

		addWhere(sql,"id",param.get("0"),Long.class,StringExtension.getEmpty(),"=");
		addWhere(sql,"mobile", param.get("mobile"),String.class,"mobile","=");
		addWhere(sql,"account_money",param.get("2"),BigDecimal.class,StringExtension.getEmpty(),">=");
		addWhere(sql,"account_money",param.get("3"),BigDecimal.class,StringExtension.getEmpty(),"<=");
		addWhere(sql,"nick_name", param.get("nick_name"),String.class,"nick_name","=");
		addWhere(sql,"ref_id",param.get("5"),Long.class,StringExtension.getEmpty(),"=");
		addWhere(sql,"create_time",param.get("create_times"),String.class,"create_times",">=");
		addWhere(sql,"create_time",param.get("create_timee"),String.class,"create_timee","<=");
		addWhere(sql,"real_name", param.get("real_name"),String.class,"real_name","=");
		addWhere(sql,"id_card", param.get("id_card"),String.class,"id_card","=");
		if((Integer)param.get("10") >-1){
			addWhere(sql,"cmp_id",param.get("10"),Integer.class,StringExtension.getEmpty(),"=");

		}

		Integer pageIndex = (Integer) param.get("11");
		Integer pageSize = (Integer) param.get("12");
		if(pageIndex>0 && pageSize>0){
			int start = (pageIndex-1)*pageSize;
			return sql.toString()+" order by id desc limit "+start+","+pageSize;
		}
		return sql.toString();

	}

	public  String getCount(Map<String, Object> param) {
		SQL sql = new SQL().SELECT("Count(*)").FROM(TABLE);
		addWhere(sql,"id",param.get("0"),Long.class,StringExtension.getEmpty(),"=");
		addWhere(sql,"mobile", param.get("mobile"),String.class,"mobile","=");
		addWhere(sql,"account_money",param.get("2"),BigDecimal.class,StringExtension.getEmpty(),">=");
		addWhere(sql,"account_money",param.get("3"),BigDecimal.class,StringExtension.getEmpty(),"<=");
		addWhere(sql,"nick_name", param.get("nick_name"),String.class,"nick_name","=");
		addWhere(sql,"ref_id",param.get("5"),Long.class,StringExtension.getEmpty(),"=");
		addWhere(sql,"create_time",param.get("create_times"),String.class,"create_times",">=");
		addWhere(sql,"create_time",param.get("create_timee"),String.class,"create_timee","<=");
		addWhere(sql,"real_name", param.get("real_name"),String.class,"real_name","=");
		addWhere(sql,"id_card", param.get("id_card"),String.class,"id_card","=");
		if((Integer)param.get("10") >-1){
			addWhere(sql,"cmp_id",param.get("10"),Integer.class,StringExtension.getEmpty(),"=");

		}

		return sql.toString();

	}
}
