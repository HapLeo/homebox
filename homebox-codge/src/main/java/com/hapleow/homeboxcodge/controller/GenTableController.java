package com.hapleow.homeboxcodge.controller;

import com.hapleow.homeboxcodge.common.AjaxResult;
import com.hapleow.homeboxcodge.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表结构信息
 *
 * @author wuyulin
 * @date 2020/7/17
 */
@RestController
@RequestMapping("/table")
public class GenTableController {

    @Autowired
    private IGenTableService hbTableService;

    /**
     * 导入
     *
     * @return
     */
    @RequestMapping("/importTable")
    public Object importTable(String tables) {
        hbTableService.importTable(tables);
        return AjaxResult.success();
    }

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Object list() {
        return hbTableService.list();
    }

    /**
     * 明细
     *
     * @return
     */
    @RequestMapping("/detail/{id}")
    public Object detail(@PathVariable("id") Integer id) {
        return hbTableService.detail(id);
    }
}
