package com.zheng.cms.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.zheng.cms.rpc"
})
@MapperScan(basePackages = {
    "com.zheng.cms.dao.mapper",
    "com.zheng.cms.rpc.mapper",
    "com.zheng.pay.dao.mapper",
    "com.zheng.ucenter.dao.mapper",
    "com.zheng.upms.dao.mapper",
})
public class ZhengCmsAdminConfigurator {

}
