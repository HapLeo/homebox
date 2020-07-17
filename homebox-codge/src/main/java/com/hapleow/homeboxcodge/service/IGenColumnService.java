package com.hapleow.homeboxcodge.service;

import com.hapleow.homeboxcodge.model.GenColumn;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
public interface IGenColumnService {

    List<GenColumn> list(String tableName);
}
