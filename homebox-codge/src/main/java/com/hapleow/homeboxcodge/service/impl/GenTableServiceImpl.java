package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.dao.GenColumnMapper;
import com.hapleow.homeboxcodge.dao.GenTableMapper;
import com.hapleow.homeboxcodge.model.GenColumn;
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
        List<GenTable> list = genTableMapper.list();
        list.forEach(item -> {
            List<GenColumn> genColumns = genColumnMapper.list(item.getTableName());
            item.setGenColumns(genColumns);
        });
        return list;
    }

}
