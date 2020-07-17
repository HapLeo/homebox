package com.hapleow.homeboxcodge.service;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/7/15
 */
public interface ICodgeService {

    List<Map<String,Object>> listTables();

    Object execute();
}
