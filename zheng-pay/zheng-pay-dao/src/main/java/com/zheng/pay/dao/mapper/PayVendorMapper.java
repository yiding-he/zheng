package com.zheng.pay.dao.mapper;

import com.zheng.pay.dao.model.PayVendor;
import com.zheng.pay.dao.model.PayVendorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayVendorMapper {
    long countByExample(PayVendorExample example);

    int deleteByExample(PayVendorExample example);

    int deleteByPrimaryKey(Integer payVendorId);

    int insert(PayVendor record);

    int insertSelective(PayVendor record);

    List<PayVendor> selectByExample(PayVendorExample example);

    PayVendor selectByPrimaryKey(Integer payVendorId);

    int updateByExampleSelective(@Param("record") PayVendor record, @Param("example") PayVendorExample example);

    int updateByExample(@Param("record") PayVendor record, @Param("example") PayVendorExample example);

    int updateByPrimaryKeySelective(PayVendor record);

    int updateByPrimaryKey(PayVendor record);
}
