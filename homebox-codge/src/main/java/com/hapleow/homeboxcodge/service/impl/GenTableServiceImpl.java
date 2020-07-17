package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.dao.GenColumnMapper;
import com.hapleow.homeboxcodge.dao.GenTableMapper;
import com.hapleow.homeboxcodge.model.GenTable;
import com.hapleow.homeboxcodge.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
@Service
public class GenTableServiceImpl implements IGenTableService {

    @Autowired
    private GenTableMapper genTableMapper;

    @Autowired
    private GenColumnMapper genColumnMapper;

    @Override
    public List<GenTable> list() {
        return genTableMapper.list();
    }

    @Override
    public GenTable detail(Integer id) {
        return genTableMapper.detail(id);
    }

    @Override
    public void importTable(String tables) {
        String[] tableNames = tables.split(",");
        genTableMapper.importTable(tableNames);
        for (String tableName : tableNames) {
            genColumnMapper.importColumn(tableName);
        }
    }

    @Override
    public List<GenTable> listFromSchema() {
        return genTableMapper.listFromSchema();
    }
}
