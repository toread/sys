package com.toread.sys.utils;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.ConfigGenerator;

import java.io.IOException;

/**
 * Created by toread on 16-10-19.
 */
public class CustomGenerator {
    public static void generator(){
        ConfigGenerator cg = new ConfigGenerator();
        // 配置 MySQL 连接
        cg.setDbDriverName("com.mysql.jdbc.Driver");
        cg.setDbUser("root");
        cg.setDbPassword("toread");
        cg.setDbUrl("jdbc:mysql://localhost:3308/access_ctl?characterEncoding=utf8");
        // 配置包名
        cg.setEntityPackage("com.toread.sys.entity");
        cg.setMapperPackage("com.toread.sys.mapper");
        cg.setServicePackage("com.toread.sys.service");
        cg.setXmlPackage("com.toread.sys.mapper.xml");
        cg.setServiceImplPackage("com.toread.sys.service.impl");
        // 配置表主键策略
        cg.setIdType(IdType.ID_WORKER);
        cg.setDbPrefix(true);
        // 配置保存路径
        cg.setSaveDir("/home/toread/prj/sys/src/main/java");
        cg.setTableNames(new String[]{"sys_department","sys_menu","sys_resouce_menu","sys_resource","sys_role","sys_role_resource","sys_user","sys_user_department","sys_user_role"});
        // 其他参数请根据上面的参数说明自行配置，当所有配置完善后，运行AutoGenerator.run()方法生成Code
        // 生成代码
        AutoGenerator.run(cg);
    }
}
