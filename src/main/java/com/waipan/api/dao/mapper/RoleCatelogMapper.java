package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.RoleCatelog;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:52 2018/1/26
 * @Modified By:
 */
@Repository("roleCatelogMapper")
public interface RoleCatelogMapper {

	@Select("select * from role_catelog where id in (${ids})")
	@Results()
	List<RoleCatelog> getListByIds(@Param("ids") String ids);
}
