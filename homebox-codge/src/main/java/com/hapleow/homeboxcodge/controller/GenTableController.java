package com.hapleow.homeboxcodge.controller;

import com.hapleow.homeboxcodge.common.AjaxResult;
import com.hapleow.homeboxcodge.model.GenTable;
import com.hapleow.homeboxcodge.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表结构信息
 *
 * @author wuyulin
 * @date 2020/7/17
 */
@RestController
@RequestMapping("/genTable")
public class GenTableController {

    @Autowired
    private IGenTableService genTableService;

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Object list(GenTable genTable) {
        return AjaxResult.success(genTableService.list(genTable));
    }

}
