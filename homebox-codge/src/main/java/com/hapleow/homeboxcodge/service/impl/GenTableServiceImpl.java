package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.common.ExceptionUtil;
import com.hapleow.homeboxcodge.common.StringUtil;
import com.hapleow.homeboxcodge.dao.GenColumnMapper;
import com.hapleow.homeboxcodge.dao.GenTableMapper;
import com.hapleow.homeboxcodge.model.GenColumn;
import com.hapleow.homeboxcodge.model.GenTable;
import com.hapleow.homeboxcodge.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<GenTable> list(GenTable genTable) {
        List<GenTable> list = genTableMapper.list(genTable);
        list.forEach(item -> {
            GenColumn genColumn = new GenColumn();
            genColumn.setTableName(item.getTableName());
            List<GenColumn> genColumns = genColumnMapper.list(genColumn);
            item.setGenColumns(genColumns);
            item.setTableNameVariable(StringUtil.underlineToCamel(item.getTableName()));
            item.setTableNameClass(StringUtil.firstLatterUpperCamel(item.getTableName()));
            item.setCreateTime(LocalDateTime.now());
            item.setAuthor("wyl");
        });
        return list;
    }


    @Override
    public GenTable getByTableName(String tableName) {
        GenTable condition = new GenTable();
        condition.setTableName(tableName);
        List<GenTable> list = list(condition);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }
}
