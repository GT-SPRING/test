package com.itqf.mapper;

import com.itqf.pojo.HouseInfo;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/22
 * @Time: 下午4:24
 */
public interface HouseInfoMapper {

    public  int saveHouseInfo(HouseInfo houseInfo);

    public List<HouseInfo> findAll();

}
