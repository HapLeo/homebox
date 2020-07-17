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

    private Long columnId;

    private Long columnTableId;

    private String columnName;

    private String columnComment;
}
