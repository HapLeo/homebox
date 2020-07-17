package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.common.StringUtil;
import com.hapleow.homeboxcodge.dao.GenColumnMapper;
import com.hapleow.homeboxcodge.model.GenColumn;
import com.hapleow.homeboxcodge.service.IGenColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
@Service
public class GenColumnServiceImpl implements IGenColumnService {

    @Autowired
    private GenColumnMapper genColumnMapper;

    @Override
    public List<GenColumn> list(GenColumn genColumn) {

        List<GenColumn> list = genColumnMapper.list(genColumn);
        list.forEach(item -> {
            item.setColumnNameVariable(StringUtil.underlineToCamel(genColumn.getColumnName()));
            item.setColumnNameClass(StringUtil.firstLatterUpperCamel(genColumn.getColumnName()));
        });

        return list;
    }
}
