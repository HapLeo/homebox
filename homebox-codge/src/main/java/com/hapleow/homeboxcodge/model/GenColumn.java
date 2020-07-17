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

    private String columnName;

    private String columnComment;

    private String columnType;

    private String columnKey;
}
