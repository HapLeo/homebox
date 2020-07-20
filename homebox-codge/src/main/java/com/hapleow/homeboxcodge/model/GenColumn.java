package com.hapleow.homeboxcodge.model;

import lombok.Data;

/**
 * 列信息
 *
 * @author wuyulin
 * @date 2020/7/17
 */
@Data
public class GenColumn {

    private String tableName;

    private String columnName;

    private String columnComment;

    private String columnType;

    private String columnKey;

    /**
     * 列名称（驼峰格式）
     * 用于生成变量名
     */
    private String columnNameVariable;

    /**
     * 列名称(驼峰格式且首字母大写)
     * 用于生成类名
     */
    private String columnNameClass;
}
