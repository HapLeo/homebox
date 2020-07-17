package com.hapleow.homeboxcodge.service;

import com.hapleow.homeboxcodge.model.GenTable;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
public interface IGenTableService {


    List<GenTable> list();

    GenTable detail(Integer id);

    void importTable(String tables);

    List<GenTable> listFromSchema();
}
