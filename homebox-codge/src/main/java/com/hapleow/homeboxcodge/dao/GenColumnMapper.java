package com.hapleow.homeboxcodge.dao;

import com.hapleow.homeboxcodge.model.GenColumn;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
public interface GenColumnMapper {


    List<GenColumn> list(String tableName);
}
