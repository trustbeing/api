package com.waipan.api.dao.mapper;

import com.waipan.api.model.entity.GlobalBanner;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "globalBannerMapper")
public interface GlobalBannerMapper {

    @Select("select * from global_banner")
    List<GlobalBanner> getList();
}