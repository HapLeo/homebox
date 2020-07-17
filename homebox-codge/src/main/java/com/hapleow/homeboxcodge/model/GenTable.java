package com.hapleow.homeboxcodge.model;

import lombok.Data;

import java.util.List;

/**
 * 表信息
 *
 * @author wuyulin
 * @date 2020/7/17
 */
@Data
public class GenTable {

    private Long tableId;

    private String tableName;

    private String tableComment;

    private List<GenColumn> genColumns;
}
