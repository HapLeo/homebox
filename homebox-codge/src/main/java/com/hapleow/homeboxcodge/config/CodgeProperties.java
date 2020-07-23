package com.hapleow.homeboxcodge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 生成器的yaml属性
 *
 * @author wuyulin
 * @date 2020/7/23
 */
@ConfigurationProperties(prefix = "codge")
@Data
public class CodgeProperties {

    /**
     * 模板路径
     */
    private String templatePath;

    /**
     * 生成类的根路径
     */
    private String classRootPath;

    /**
     * 生成类的包名
     */
    private String classPackage;


}
