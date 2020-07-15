package com.hapleow.homeboxcodge.service.impl;

import com.hapleow.homeboxcodge.dao.CodgeMapper;
import com.hapleow.homeboxcodge.service.ICodgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/7/15
 */
@Service
public class CodgeService implements ICodgeService {

    @Autowired
    private CodgeMapper codgeMapper;

    @Override
    public List<Map<String, Object>> listTables() {
        return codgeMapper.listTables();
    }
}
