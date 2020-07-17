package com.hapleow.homeboxcodge.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 表信息
 *
 * @author wuyulin
 * @date 2020/7/17
 */
@Data
public class GenTable {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表说明
     */
    private String tableComment;

    /**
     * 表字段列表
     */
    private List<GenColumn> genColumns;

    /**
     * 表名称（驼峰格式）
     * 用于生成变量名
     */
    private String tableNameVariable;

    /**
     * 表名称(驼峰格式且首字母大写)
     * 用于生成类名
     */
    private String tableNameClass;


    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
